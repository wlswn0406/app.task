package app.task.api.todo;

import app.task.api.todo.dto.TodoCreate;
import app.task.api.todo.dto.TodoResponseDTO;
import app.task.api.todo.dto.TodoUpdate;
import app.task.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final ModelMapper modelMapper;

    private final TodoMapper todoMapper;

    public TodoResponseDTO findTodo(Integer id) {
        return todoMapper.findTodo(id)
                .map(todo -> modelMapper.map(todo, TodoResponseDTO.class))
                .orElse(null);
    }

    public List<TodoResponseDTO> findImportantTodos() {
        return null;
    }

    public List<TodoResponseDTO> findAllTodos(String userId) {
        return todoMapper.findAllTodos(userId);
    }

    //@Transactional
    public TodoResponseDTO create(TodoCreate todo) {
        return null;
    }

    public TodoResponseDTO update(Integer id, TodoUpdate todo) {
        return null;
    }

    public Void delete(Integer id) {
        return null;
    }

}