package com.app.todo.repositories;

import com.app.todo.domain.todo.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, String> {
}
