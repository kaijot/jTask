package pl.codespring.testproject.task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class Task {
    @Id
    @GeneratedValue
     int id;
     String name;



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

    }

    public Task(){

    }
    public Task(int id, String name) {

        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                Objects.equals(name, task.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
