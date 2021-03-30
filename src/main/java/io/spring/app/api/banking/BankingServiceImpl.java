package io.spring.app.api.banking;

import io.spring.app.core.account.Account;
import io.spring.app.core.account.AccountRepository;
import io.spring.app.core.bill.Bill;
import io.spring.app.core.bill.BillRepository;
import io.spring.app.core.fee.Fee;
import io.spring.app.core.opt.OptRepository;
import io.spring.app.core.opt.Otp;
import io.spring.app.core.student.Student;
import io.spring.app.core.student.StudentRepository;
import io.spring.app.event.SendEmailEvent;
import io.spring.app.exception.MyException;
import io.spring.app.utils.GenerateOpt;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankingServiceImpl implements BankingService {
    private final AccountRepository accountRepository;
    private final StudentRepository studentRepository;
    private final GenerateOpt generateOpt;
    private final BillRepository billRepository;
    private final OptRepository optRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    @Transactional
    public long processBanking(BankingRequest request) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Account account = getAccount(username);
        Student student = getStudent(request.getStudentCode());

        Fee fee = getFeeOfStudent(student);
        validateAmount(request, account, fee);

        Otp otp = createOtp();
        optRepository.save(otp);

        Bill bill = new Bill();
        bill.setAccount(account);
        bill.setFee(fee);
        bill.setOtp(otp);
        bill.setCost(request.getAmount());
        billRepository.save(bill);

        SendEmailEvent sendEmailEvent = new SendEmailEvent(
                this, account.getEmail(),
                "Code: " + otp.getContent()
        );
        applicationEventPublisher.publishEvent(sendEmailEvent);

        return bill.getId();
    }

    private void validateAmount(BankingRequest request, Account account, Fee fee) {
        if (request.getAmount() <= 0) {
            throw new MyException("Amount must be greater than 0!");
        }

        if (request.getAmount() % 1000 != 0) {
            throw new MyException("Amount must be divisible by 1000!");
        }

        if (request.getAmount() > account.getBalance()) {
            throw new MyException("Amount must be less than balance!");
        }

        if (request.getAmount() > fee.getCost()) {
            throw new MyException("Amount must be less than fee!");
        }
    }

    private Otp createOtp() {
        int minutes = 5;
        Otp otp = new Otp();
        otp.setContent(generateOpt.newOpt());
        otp.setExpireAt(LocalDateTime.now().plusMinutes(minutes));
        return otp;
    }

    private Fee getFeeOfStudent(Student student) {
        List<Fee> fees = student.getFees();
        Collections.sort(fees, Comparator.comparingInt(Fee::getTerm));
        return fees.get(fees.size() - 1);
    }

    private Account getAccount(String username) {
        Optional<Account> optAccount = accountRepository.findAccountByUsername(username);
        if (optAccount.isEmpty()) {
            throw new MyException("Username invalid!");
        }
        return optAccount.get();
    }

    private Student getStudent(String studentCode) {
        Optional<Student> optStudent = studentRepository.findByStudentCode(studentCode);
        if (optStudent.isEmpty()) {
            throw new MyException("Student code invalid!");
        }
        return optStudent.get();
    }
}
