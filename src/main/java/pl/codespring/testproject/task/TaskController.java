package pl.codespring.testproject.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/")
    public String showIndexPage(Model model) {
        Task task = new Task();
        model.addAttribute("tasks", taskService.getAllTasks());
        model.addAttribute("newtask", task);
        return "index";
    }

    @RequestMapping(value = "/addtask", method = RequestMethod.POST)
    public String  addTask(@ModelAttribute Task task) {
        taskService.addTask(task);
        return "redirect:/";
    }

    @RequestMapping(value = "/deletetask/{id}", method = RequestMethod.DELETE)
    public String removeTask(@PathVariable int id){
        taskService.deleteTask(id);
        return "redirect:/";
    }


}
