package io.spring.app;

import io.spring.app.core.account.Account;
import io.spring.app.core.fee.Fee;
import io.spring.app.core.fee.FeeRepository;
import io.spring.app.core.student.Student;
import io.spring.app.core.account.AccountRepository;
import io.spring.app.core.student.StudentRepository;

import java.time.LocalDate;
import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener(classes = ContextRefreshedEvent.class)
    public void fakeData(ContextRefreshedEvent event) {
        System.out.println("\n------------------------------FAKE DATA--------------------------------\n");
        ApplicationContext context = event.getApplicationContext();

        AccountRepository accountRepository = context.getBean(AccountRepository.class);
        fakeAccount(accountRepository);

        StudentRepository studentRepository = context.getBean(StudentRepository.class);
        FeeRepository feeRepository = context.getBean(FeeRepository.class);
        fakeStudent(studentRepository, feeRepository);


    }

    private String createStudentCode(int value) {
        return "1021700" + ((value > 9) ? value : "0" + value);
    }

    private String createFullName(Random random) {
        String[] firstName = {"Tam", "Kim", "Loc", "Nghia", "Hieu"};
        String[] lastName = {"Nguyen", "Vo", "Tran", "Le", "Ho"};
        String[] middleName = {"Minh", "Cong", "Huu", "Trong", "Van"};

        return lastName[random.nextInt(lastName.length)]
                + " "
                + middleName[random.nextInt(middleName.length)]
                + " "
                + firstName[random.nextInt(firstName.length)];
    }

    public void fakeStudent(StudentRepository studentRepository, FeeRepository feeRepository) {
        for (int i = 0; i < 40; i++) {
            Random random = new Random(System.currentTimeMillis());

            Student student = new Student();
            student.setDateOfBirth(LocalDate.of(1999, 06, 25));
            student.setFullName(createFullName(random));
            student.setStudentCode(createStudentCode(i));
            student.setFees(new ArrayList<>());
            studentRepository.save(student);

            // 7_000_000 - 8_000_000
            int cost = (random.nextInt(10) + 70) * 100000;

            Fee fee = new Fee();
            fee.setCost(cost);
            fee.setTerm(1);
            fee.setStudent(student);
            feeRepository.save(fee);
        }
    }

    public void fakeAccount(AccountRepository accountRepository) {
        Account account = new Account();
        account.setFullName("Vo Van Tam");
        account.setUsername("admin");
        account.setPassword(new BCryptPasswordEncoder().encode("123456"));
        account.setEmail("vovantam.dev@gmail.com");
        account.setPhone("0859292354");
        account.setBalance(30_000_000);

        accountRepository.save(account);
    }
}
