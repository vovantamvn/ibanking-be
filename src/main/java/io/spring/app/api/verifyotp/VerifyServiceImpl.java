package io.spring.app.api.verifyotp;

import io.spring.app.core.bill.Bill;
import io.spring.app.core.bill.BillRepository;
import io.spring.app.exception.MyException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VerifyServiceImpl implements VerifyService{
    private final BillRepository billRepository;

    @Override
    @Transactional
    public void verify(VerifyRequest request) {
        Bill bill = getBill(request.getBillId());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!username.equals(bill.getAccount().getUsername())) {
            throw new MyException("You don't have permition");
        }


    }

    private Bill getBill(long id) {
        Optional<Bill> optionalBill = billRepository.findById(id);
        if (optionalBill.isEmpty()){
            throw new MyException("billId invalid!");
        }
        return optionalBill.get();
    }
}
