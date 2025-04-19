package app.task.it.api;

import app.task.common.filter.JwtAuthenticationFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 통합 테스트를 위한 기본 설정을 제공하는 추상 클래스
 *
 */
@SpringBootTest
@ExtendWith(RestDocumentationExtension.class)
public abstract class AbstractRestDocTest {

    @Value("${server.host}")
    private String serverHost;

    @Value("${server.port}")
    private int serverPort;

    @Autowired
    protected WebApplicationContext context;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    protected MockMvc mockMvc;

    @BeforeEach
    public void setUp(RestDocumentationContextProvider provider) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
            .addFilter(jwtAuthenticationFilter)
            .apply(MockMvcRestDocumentation.documentationConfiguration(provider)
                .uris()
                .withScheme("http")
                .withHost(serverHost)
                .withPort(serverPort))
            .build();
    }

}