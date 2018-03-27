package net.kistowski.jTask.task;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class TaskDto {

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 3, message = "Please enter minimum {min} characters")
    private String name;
    @Size(min = 3, message = "Please enter minimum {min} characters")
    @NotBlank(message = "Description cannot be empty")
    private String description;
    private LocalDateTime toDoDate;
    private TaskPriority priority;
    private boolean isDone;
}