package Todo.list.Todo.list.service;

import Todo.list.Todo.list.entity.Task;
import Todo.list.Todo.list.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(Integer id) throws SQLException {
        return taskRepository.findByTodoId(id);
    }

    public Task getTask(Integer todoId, Integer taskId) throws NoSuchElementException {
        List <Task> tasks = new ArrayList<>();
        tasks.addAll(taskRepository.findByTodoId(todoId));


        if(tasks.size() == 0){
            throw new NoSuchElementException("Task not Found");
        }else{
            return tasks.stream().filter(t -> t.getId() == taskId).findFirst().get();
        }
    }

    public Task addTask(Task task) throws SQLException{
        taskRepository.save(task);
        return task;
    }

    public void updateTask(Task task, Integer taskId) throws SQLException{

        Task tempTask = taskRepository.findOne(taskId);
        tempTask.setTitle(task.getTitle());
        tempTask.setDescription(task.getDescription());
        tempTask.setStatus(task.getStatus());
        taskRepository.save(tempTask);
    }

    public void deleteTask(Integer id) throws NoSuchElementException{
        taskRepository.delete((id));
    }


}
