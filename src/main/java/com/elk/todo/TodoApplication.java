package com.elk.todo;

import com.elk.todo.domain.ToDo;
import com.elk.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

    @Autowired
    private ToDoRepository toDoRepository;

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    public void run(String... args) throws Exception {
        ToDo toDo = new ToDo();
        toDo.setName("Test Task#1");
        toDo.setDescription("cnjdksbv duisgvi gviu esgviu sf");
        toDo.setCreatedBy("Hiten P. Singh");
        toDoRepository.save(toDo);
    }

}
