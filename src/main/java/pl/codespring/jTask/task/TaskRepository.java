package pl.codespring.jTask.task;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Integer> {


    List<Task> findAllByOrderByToDoDate();

    List<Task> findAllByIsDoneIsFalseOrderByToDoDate();

    List<Task> findAllByIsDoneIsTrueOrderByToDoDate();
}
