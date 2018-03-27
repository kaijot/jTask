package net.kistowski.jTask.task;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Integer>{


    List<Task> findAllByOrderByToDoDate();

    List<Task> findAllByIsDoneIsFalseOrderByToDoDate();

    List<Task> findAllByIsDoneIsTrueOrderByToDoDate();

    List<Task> findAllByToDoDateIsLessThan(LocalDateTime currentDate);
}
