package pl.codespring.jTask.task;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

import static pl.codespring.jTask.task.TaskPriority.MEDIUM;

enum TaskPriority {LOW, MEDIUM, HIGH}
@Data
@Entity
public class Task {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private LocalDateTime toDoDate;
    private TaskPriority priority;
    private boolean isDone;

    {
        this.name = "Task name";
        this.toDoDate = LocalDateTime.now().plusDays(1).withHour(17).withMinute(0);
        this.description = "Task description";
        this.priority=MEDIUM;
        this.isDone=false;

    }

    public Task() {

    }

    public Task(String name, String description, LocalDateTime toDoDate, TaskPriority priority, boolean isDone) {
        this.name = name;
        this.description = description;
        this.toDoDate = toDoDate;
        this.priority = priority;
        this.isDone=isDone;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
    public void changeStatus(){
        isDone=!isDone;
    }


}
