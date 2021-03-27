package io.spring.app.api;

import io.spring.app.TokenUtils;
import io.spring.app.core.account.AccountService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class AccountControllerTest {
    @MockBean
    private AccountService accountService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findByUsername() throws Exception {
        String token = TokenUtils.getToken();

        mockMvc.perform(MockMvcRequestBuilders
                .get("/accounts/admin")
                .header("Authorization", token))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(accountService).findByUsername("admin");
    }
}
