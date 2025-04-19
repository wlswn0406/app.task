package app.task.it.api.todo;

import app.task.api.auth.JwtTokenProvider;
import app.task.api.todo.TodoService;
import app.task.it.api.AbstractRestDocTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TodoControllerTest extends AbstractRestDocTest {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private TodoService todoService;

    @Test
    public void getTodos() throws Exception {

        String userId = "test1";
        String token = jwtTokenProvider.createToken(userId);

        super.mockMvc.perform(
            get("/api/todos")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.data").isArray())
            .andDo(document("/api/todos",
                responseFields(
                    fieldWithPath("success").description("API 성공 여부"),
                    fieldWithPath("message").description("응답 메시지").optional(),
                    fieldWithPath("data").description("할일 데이터").optional(),
                    fieldWithPath("data[].tid").description("할 일 ID"),
                    fieldWithPath("data[].title").description("제목"),
                    fieldWithPath("data[].description").description("설명").optional(),
                    fieldWithPath("data[].sortOrder").description("순서"),
                    fieldWithPath("data[].isDone").description("완료 여부").optional(),
                    fieldWithPath("data[].isImportant").description("중요 여부").optional(),
                    fieldWithPath("data[].isNotified").description("알림 여부").optional()
                )
            ));

    }

}