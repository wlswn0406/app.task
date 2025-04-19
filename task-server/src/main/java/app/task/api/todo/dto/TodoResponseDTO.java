package app.task.api.todo.dto;

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
public class TodoResponseDTO {

    private Integer tid;
    private String title;
    private String description;
    private Integer sortOrder;
    private Boolean isDone;
    private Boolean isImportant;
    private Boolean isNotified;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class TodoCategory {
        private Integer categoryId;
        private String categoryName;
        private Integer categorySortOrder;
        private Boolean isChecked;
        private Integer userId;
    }

}