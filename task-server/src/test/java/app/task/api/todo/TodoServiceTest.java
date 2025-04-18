package app.task.api.todo;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @Mock
    private TodoMapper todoMapper;

    @InjectMocks
    private TodoService todoService;

}