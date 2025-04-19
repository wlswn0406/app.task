package app.task.slice.api.todo;

import app.task.api.todo.TodoMapper;
import app.task.domain.Todo;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
@MapperScan("app.task.api.todo")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TodoMapperTest {

    @Autowired
    private TodoMapper todoMapper;

    @Test
    public void findTodo() {
        Optional<Todo> todo = todoMapper.findTodo(1);
        assertThat(todo).isPresent();
    }

}