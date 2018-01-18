package Todo.list.Todo.list.Task;

import Todo.list.Todo.list.controller.TaskController;
import Todo.list.Todo.list.entity.Task;
import Todo.list.Todo.list.entity.Todo;
import Todo.list.Todo.list.repository.TaskRepository;
import Todo.list.Todo.list.repository.TodoRepository;
import Todo.list.Todo.list.service.TaskService;
import Todo.list.Todo.list.service.TodoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {

    private MockMvc mockMvc;
    @Autowired
    private TaskService taskService;

   @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private TaskRepository taskRepository;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getTasks() throws Exception {
        this.mockMvc.perform(get("/tasks/1").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"));
    }


    @Test (expected = SQLException.class)
    public void getNonExistentTask() throws  SQLException{
        List<Task> task = taskService.getAllTasks(19);
    }

    @Test
    public void getInitialTasks(){
        assertThat(taskRepository.findAll().size()).isEqualTo(0);
    }

    @Test (expected = NoSuchElementException.class)
    public void deleteTaskNotFound(){
        taskService.deleteTask(90);
    }






}
