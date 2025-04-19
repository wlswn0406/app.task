package app.task.api.todo;

import app.task.api.todo.dto.TodoResponseDTO;
import app.task.domain.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoMapper {

    Optional<Todo> findTodo(Integer id);

    List<TodoResponseDTO> findAllTodos(String userId);

    /*
    Optional<Todo> findTodo(Integer id);

    List<Todo> findImportantTodos(boolean isImportant);

    List<Todo> findAllTodos();

    void create(Todo todo);

    void update(Todo todo);

    void delete(Integer id);
    */

}