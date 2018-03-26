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

    private int id;

    private LocalDateTime toDoDate;
    private TaskPriority priority;
    private boolean isDone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getToDoDate() {
        return toDoDate;
    }

    public void setToDoDate(LocalDateTime toDoDate) {
        this.toDoDate = toDoDate;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
