package Todo.list.Todo.list.Task;

import Todo.list.Todo.list.controller.TaskController;
import Todo.list.Todo.list.service.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@SpringBootTest
public class Task {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private TaskController taskController;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getTasks() throws Exception {
        this.mockMvc.perform(get("/tasks").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"));
    }
    @Test
    public void getTask() throws Exception {
        this.mockMvc.perform(get("/tasks/1").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void notFoundExceptio() throws Exception {
        this.mockMvc.perform(get("/tasks/6").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().is4xxClientError());
    }
}
