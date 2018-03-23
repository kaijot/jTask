package pl.codespring.jTask.task;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class TaskDto {

    @NotBlank(message = "Name cannot be empty")
    @Size(min=3, message ="Please enter minimum {min} characters")
    private String name;
    @Size(min=3, message ="Please enter minimum {min} characters")
    @NotBlank(message = "Description cannot be empty")
    private String description;



}
