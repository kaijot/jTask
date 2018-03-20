package pl.codespring.testproject.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private  TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll()
                .forEach(tasks::add);
        return tasks;

    }
    public void addTask(Task task){
        taskRepository.save(task);
    }

    public void deleteTask(int id){
        taskRepository.deleteById(id);
    }
}
