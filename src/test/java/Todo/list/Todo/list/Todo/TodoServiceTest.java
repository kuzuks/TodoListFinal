package Todo.list.Todo.list.Todo;

import Todo.list.Todo.list.entity.Todo;
import Todo.list.Todo.list.repository.TodoRepository;
import Todo.list.Todo.list.service.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoServiceTest {
    @Autowired
    private TodoService todoService;

    @MockBean
    private TodoRepository todoRepository;

    @Test
    public void addTodo() throws SQLException{
        Todo todo = new Todo(1,"name 1");
        todoService.addTodo(todo);
    }

    @Test
    public void getInitialTodos() throws SQLException{
        List<Todo> todos = todoService.getAllTodos();
        assertThat(todos.size()).isEqualTo(0);
    }

    @Test (expected = NullPointerException.class)
    public void  getTodoById() {
        Todo todo = todoService.getTodo(12);
        assertThat(todo.getId()).isEqualTo(null);
    }
}
