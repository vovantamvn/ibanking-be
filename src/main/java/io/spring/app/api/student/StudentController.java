package io.spring.app.api.student;

import io.spring.app.core.fee.FeeData;
import io.spring.app.core.fee.FeeService;
import io.spring.app.core.student.StudentData;
import io.spring.app.core.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/students")
public class StudentController {
    private final StudentService studentService;
    private final FeeService feeService;

    @GetMapping(path = "/{studentCode}")
    public ResponseEntity<StudentData> findByStudentCode(@PathVariable String studentCode) {
        return ResponseEntity.ok(studentService.findByStudentCode(studentCode));
    }

    @GetMapping(path = "/{studentCode}/fees")
    public ResponseEntity<FeeData> findFeeOfStudent(@PathVariable String studentCode) {
        FeeData feeData = feeService.getFeeOfStudentByStudentId(studentCode);
        return ResponseEntity.ok(feeData);
    }
}
