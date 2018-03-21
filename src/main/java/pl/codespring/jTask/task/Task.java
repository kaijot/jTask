package pl.codespring.jTask.task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

enum TaskPriority {LOW, MEDIUM, HIGH}

@Entity
public class Task {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private LocalDateTime toDoDate;
    private TaskPriority priority;




    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    {
        this.name = "Task name";
        this.toDoDate = LocalDateTime.now();
        this.description = "Task description";

    }

    public Task() {

    }

    public Task(String name, String description, LocalDateTime toDoDate, TaskPriority priority) {
        this.name = name;
        this.description = description;
        this.toDoDate = toDoDate;
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                Objects.equals(name, task.name) &&
                Objects.equals(description, task.description) &&
                Objects.equals(toDoDate, task.toDoDate) &&
                priority == task.priority;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, toDoDate, priority);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", toDoDate=" + toDoDate +
                ", priority=" + priority +
                '}';
    }
}
