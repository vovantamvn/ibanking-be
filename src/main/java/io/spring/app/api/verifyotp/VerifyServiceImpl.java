package io.spring.app.api.verifyotp;

import io.spring.app.core.account.Account;
import io.spring.app.core.account.AccountRepository;
import io.spring.app.core.bill.Bill;
import io.spring.app.core.bill.BillRepository;
import io.spring.app.core.fee.Fee;
import io.spring.app.core.fee.FeeRepository;
import io.spring.app.core.opt.Otp;
import io.spring.app.core.student.Student;
import io.spring.app.event.SendEmailEvent;
import io.spring.app.exception.MyException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VerifyServiceImpl implements VerifyService {
    private final BillRepository billRepository;
    private final FeeRepository feeRepository;
    private final AccountRepository accountRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    @Transactional
    public void verify(VerifyRequest request) {
        Bill bill = getBill(request.getBillId());
        if (!bill.isValid()) {
            throw new MyException("Bill invalid!");
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!username.equals(bill.getAccount().getUsername())) {
            throw new MyException("You don't have permission");

        }

        Otp otp = bill.getOtp();
        if (otp.getExpireAt().isBefore(LocalDateTime.now())) {
            throw new MyException("Expired OTP");
        }

        long cost = bill.getCost();

        Account account = bill.getAccount();
        long oldBalance = account.getBalance();
        account.setBalance(oldBalance - cost);

        Fee fee = bill.getFee();
        long oldCost = fee.getCost();
        fee.setCost(oldCost - cost);

        bill.setValid(false);

        billRepository.save(bill);
        accountRepository.save(account);
        feeRepository.save(fee);

        sendEmail(account, fee, bill);
    }

    private void sendEmail(Account account, Fee fee, Bill bill) {
        Student student = fee.getStudent();

        String content = "Chào " + account.getFullName() + "\n" +
                "Bạn đã vừa thực hiện giao dịch nộp học phí thành công!\n" +
                "MSSV: " + student.getStudentCode() + "\n" +
                "Số tiền: " + bill.getCost() + "\n" +
                "Thời gian: " + bill.getUpdateAt() + "\n" +
                "Số dư tài khoản: " + account.getBalance() + "\n";

        SendEmailEvent sendEmailEvent = new SendEmailEvent(this, account.getEmail(), content);
        applicationEventPublisher.publishEvent(sendEmailEvent);
    }

    private Bill getBill(long id) {
        Optional<Bill> optionalBill = billRepository.findById(id);
        if (optionalBill.isEmpty()) {
            throw new MyException("billId invalid!");
        }
        return optionalBill.get();
    }
}
