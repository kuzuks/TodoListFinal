package Todo.list.Todo.list.controller;

import Todo.list.Todo.list.entity.Task;
import Todo.list.Todo.list.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks/{todoId}")
    public List<Task> getAllTasks(@PathVariable Integer todoId) throws SQLException {
        return taskService.getAllTasks(todoId);
    }
    @GetMapping("/tasks/{todoId}/{id}")
    public Task getTask(@PathVariable("todoId") Integer todoId, @PathVariable("id") Integer id) throws NoSuchElementException {
        return taskService.getTask(todoId,id);
    }
    @PostMapping("/tasks/{id}")
    public void addTask(@RequestBody Task task, @PathVariable Integer id) throws SQLException {
        Task tempTask = new Task( task.getTitle(), task.getStatus() ,task.getDescription(),id);
        taskService.addTask(tempTask);
    }
    @PutMapping("/tasks/{id}")
    public void updateTask(@RequestBody Task task, @PathVariable Integer id) throws SQLException{
        taskService.updateTask(task,id);
    }
    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable("id") Integer id) throws NoSuchElementException{
        taskService.deleteTask(id);
    }



}
