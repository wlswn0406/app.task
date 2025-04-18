package app.task.api.todo;

import app.task.api.todo.dto.TodoCreate;
import app.task.api.todo.dto.TodoResponse;
import app.task.api.todo.dto.TodoUpdate;
import app.task.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final ModelMapper modelMapper;

    private final TodoMapper todoMapper;

    public TodoResponse findTodo(Integer id) {
        return todoMapper.findTodo(id)
                .map(todo -> modelMapper.map(todo, TodoResponse.class))
                .orElse(null);
    }

    public List<TodoResponse> findImportantTodos() {
        return null;
    }

    public List<TodoResponse> findAllTodos() {
        return null;
    }

    //@Transactional
    public TodoResponse create(TodoCreate todo) {
        return null;
    }

    public TodoResponse update(Integer id, TodoUpdate todo) {
        return null;
    }

    public Void delete(Integer id) {
        return null;
    }

}