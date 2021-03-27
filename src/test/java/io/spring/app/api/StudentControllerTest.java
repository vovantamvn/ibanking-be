package io.spring.app.api;

import io.spring.app.TokenUtils;
import io.spring.app.core.student.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class StudentControllerTest {
    @MockBean
    private StudentService studentService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findByStudentCode() throws Exception {
        String token = TokenUtils.getToken();

        mockMvc.perform(MockMvcRequestBuilders
                .get("/students/102170053")
                .header("Authorization", token))
                .andExpect(status().isOk());

        Mockito.verify(studentService).findByStudentCode("102170053");
    }
}
