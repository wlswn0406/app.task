package app.task.api.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponse {

    private Integer tid;
    private Integer categoryId;
    private String categoryName;
    private String title;
    private String description;
    private Integer sortOrder;
    private Boolean isDone;
    private Boolean isImportant;
    private Boolean isNotified;

}