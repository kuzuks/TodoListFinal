package Todo.list.Todo.list.repository;

import Todo.list.Todo.list.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoRepository extends JpaRepository<Todo,Integer> {
}
