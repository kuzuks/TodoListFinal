package Todo.list.Todo.list.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Todos")
public class Todo {
    @Id
    @Column(name ="Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String Name;

    @OneToMany(mappedBy = "todo", targetEntity = Task.class)
    private List<Task> tasks = new ArrayList<>();

    public Todo(){

    }

    public Todo( Integer id, String name) {
        this.id = id;
        Name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Task> getAllTasks(){
        return tasks;
    }
}
