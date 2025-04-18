package app.task.api.todo;

import app.task.api.AbstractController;
import app.task.api.todo.dto.TodoCreate;
import app.task.api.todo.dto.TodoResponse;
import app.task.api.todo.dto.TodoUpdate;
import app.task.common.ApiResponse;
import app.task.common.util.LoggerUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TodoController extends AbstractController {

    private static final Logger log = LoggerUtil.getLogger(TodoController.class);

    private final TodoService todoService;

    // [todo] 특정 할일 가져오기
    @GetMapping("/todos/{id}")
    public ResponseEntity<ApiResponse<?>> getTodo(@PathVariable Integer id) {
        return null;
    }

    // [todo] 중요한 할일 가져오기
    @GetMapping("/todos/important")
    public ResponseEntity<ApiResponse<List<?>>> getTodosByImportant() {
        return null;
    }

    // [todo] 모든 할일 가져오기
    @GetMapping("/todos")
    public ResponseEntity<ApiResponse<List<?>>> getTodos() {
        return null;
    }

    // [todo] 할일 등록
    @PostMapping("/todos")
    public ResponseEntity<ApiResponse<?>> createTodo(@RequestBody @Valid TodoCreate todo) {
        return null;
    }

    // [todo] 특정 할일 수정
    @PostMapping("/todos/{id}")
    public ResponseEntity<ApiResponse<?>> updateTodo(@PathVariable Integer id,
            @RequestBody @Valid TodoUpdate todo) {
        return null;
    }

    // [todo] 특정 할일 삭제
    @DeleteMapping("/todos/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTodo(@PathVariable Integer id) {
        return null;
    }

}