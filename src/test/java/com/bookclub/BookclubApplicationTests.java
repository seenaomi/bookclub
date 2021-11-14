package com.bookclub;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class BookclubApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    public void shouldLoginSuccessfullyAsUser() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Logged in as <strong>user</strong>")));
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    public void shouldDenyUserAccessToForbiddenContent() throws Exception {
        this.mockMvc.perform(get("/monthly-books")).andDo(print()).andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "ADMIN")
    public void shouldAllowAdminAccessToUserForbiddenContent() throws Exception {
        this.mockMvc.perform(get("/monthly-books")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Monthly Books")));
    }

}
