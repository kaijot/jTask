package pl.codespring.jTask.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {

        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {

        List<Task> tasks = new ArrayList<>();
        taskRepository.findAllByOrderByToDoDate()
                .forEach(tasks::add);
        return tasks;
    }


    public void addTask(Task task) {

        taskRepository.save(task);
    }

    public void deleteTask(int id) {

        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        }
    }

    public void changeStatus(int id) {

        if (taskRepository.existsById(id)) {
            Task task = taskRepository.findById(id).get();
            task.changeStatus();
            taskRepository.save(task);
        }
    }

    public void editTask(Task task) {

        taskRepository.save(task);
    }

    public Optional<Task> getTask(int id) {
        return taskRepository.findById(id);
    }


    public List<Task> getOutdatedTasks() {

        List<Task> tasks = new ArrayList<>();
        LocalDateTime currentDate = LocalDateTime.now();
        taskRepository.findAllByToDoDateIsLessThan(currentDate)
                .forEach(tasks::add);
        return tasks;
    }
}
