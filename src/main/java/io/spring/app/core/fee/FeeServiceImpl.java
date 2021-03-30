package io.spring.app.core.fee;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeeServiceImpl implements FeeService {
    private final FeeRepository feeRepository;
    private final ModelMapper modelMapper;

    @Override
    public FeeData getFeeOfStudentByStudentId(String studentCode) {
        List<Fee> fees = feeRepository.findFeesByStudent_StudentCode(studentCode);
        Collections.sort(fees, Comparator.comparingInt(Fee::getTerm));

        int lastIndex = fees.size() - 1;
        Fee lastFee = fees.get(lastIndex);
        return convertToData(lastFee);
    }

    private FeeData convertToData(Fee fee) {
        return modelMapper.map(fee, FeeData.class);
    }
}
