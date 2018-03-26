package pl.codespring.jTask.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    // Instead of two queries - thymeleaf if statement
   /* public List<Task> getAllTasks(Boolean status) {
        List<Task> tasks = new ArrayList<>();
        if (status) {
            taskRepository.findAllByIsDoneIsTrueOrderByToDoDate()
                    .forEach(tasks::add);
        } else {
            taskRepository.findAllByIsDoneIsFalseOrderByToDoDate()
                    .forEach(tasks::add);
        }
        return tasks;

    }*/

    public List<Task> getAllTasks(){
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

    public Task getTask(int id) {
        if (taskRepository.existsById(id)) {
            return taskRepository.findById(id).get();
        }else{
            return null;
        }
    }
}
