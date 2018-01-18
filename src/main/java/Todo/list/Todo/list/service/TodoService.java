package Todo.list.Todo.list.service;

import Todo.list.Todo.list.entity.Todo;
import Todo.list.Todo.list.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos()  throws SQLException {
        return todoRepository.findAll();
    }

    public Todo getTodo(Integer id) throws NoSuchElementException {
        return todoRepository.findOne(id);
    }

    public void addTodo(Todo todo)  throws SQLException{
        todoRepository.save(todo);
    }

    public void updateTodo(Todo todo)  throws SQLException{
        todoRepository.save(todo);
    }

    public void deleteTodo(Integer id)  throws SQLException{
        todoRepository.delete(id);
    }
}
