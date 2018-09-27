package com.elk.todo.repository;

import com.elk.todo.domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {

    void deleteByUniqueId(String todoId);

}
