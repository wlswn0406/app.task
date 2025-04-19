package app.task.it.api.auth;

import app.task.api.auth.AuthService;
import app.task.api.auth.dto.LoginDTO;
import app.task.it.api.AbstractRestDocTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthControllerTest extends AbstractRestDocTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AuthService authService;

    @Test
    public void loginTest() throws Exception {

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setId("test1");
        loginDTO.setPassword("12345");

        super.mockMvc.perform(
            post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginDTO)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data").exists())
                .andExpect(jsonPath("$.data.id").exists())
                .andExpect(jsonPath("$.data.token").exists())
                .andDo(document("/api/auth/login",
                        requestFields(
                                fieldWithPath("id").description("사용자 아이디"),
                                fieldWithPath("password").description("사용자 비밀번호")
                        ),
                        responseFields(
                                fieldWithPath("success").description("API 성공 여부"),
                                fieldWithPath("message").description("응답 메시지").optional(),
                                fieldWithPath("data").description("로그인 응답 데이터"),
                                fieldWithPath("data.id").description("사용자 ID"),
                                fieldWithPath("data.token").description("인증 토큰").optional()
                        )
                ));
    }

}