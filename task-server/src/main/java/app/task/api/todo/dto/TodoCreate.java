package app.task.api.todo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoCreate {

    @NotBlank(message = "카테고리 ID는 필수입니다")
    private Integer categoryId;

    @NotBlank(message = "제목은 필수입니다")
    private String title;

    private String description;
    private Integer sortOrder;
    private Boolean isImportant;
    private Boolean isNotified;

}