package pl.codespring.jTask.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/")
    public String showIndexPage(Model model) {
        Task task = new Task();
        model.addAttribute("tasks", taskService.getAllTasks());
        model.addAttribute("newtask", task);

        return "index";
    }

    @RequestMapping(value = "/addtask", method = RequestMethod.POST)
    public String addTask(@ModelAttribute Task task) {
        taskService.addTask(task);
        return "redirect:/";
    }

    @RequestMapping(value = "/deletetask/{id}", method = RequestMethod.DELETE)
    public String removeTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @RequestMapping("/showtasks")
    public String showTasks(Model model) {

        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks";
    }

    @RequestMapping(value = "/changestatus/{id}", method = RequestMethod.PUT)
    public String changeStatus(@PathVariable int id) {
        taskService.changeStatus(id);
        return "redirect:/";
    }

    @RequestMapping("/edittask/{id}")
    public String editTask(@PathVariable int id, Model model){
        Task task = taskService.getTask(id);
        model.addAttribute("taskToEdit",task);
        return "edittask";
    }

    @RequestMapping(value="/doEditTask", method = RequestMethod.PUT)
    public String doEditTask(@ModelAttribute Task task){
        taskService.editTask(task);
        return "redirect:/";

    }

}
