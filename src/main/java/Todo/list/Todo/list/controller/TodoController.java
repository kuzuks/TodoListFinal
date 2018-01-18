package Todo.list.Todo.list.controller;

import Todo.list.Todo.list.entity.Task;
import Todo.list.Todo.list.entity.Todo;
import Todo.list.Todo.list.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public List<Todo> getAllTodos() throws SQLException {
        return todoService.getAllTodos();
    }

    @GetMapping("/todos/{id}")
    public Todo getTodo(@PathVariable("id") Integer id) throws NoSuchElementException {
        return todoService.getTodo(id);
    }

    @PostMapping("/todos")
    public void addTodo(@RequestBody Todo todo) throws SQLException {
        todoService.addTodo(todo);
    }

    @PutMapping("/todos/{id}")
    public void updateTodo(@RequestBody Todo todo, @PathVariable("id") Integer id) throws SQLException{
        todoService.updateTodo(todo);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable("id") Integer id) throws SQLException{
        todoService.deleteTodo(id);
    }

}
