package Todo.list.Todo.list.repository;

import Todo.list.Todo.list.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface  TaskRepository extends JpaRepository<Task,Integer> {
    List<Task> findByTodoId(Integer todoId);
}
