package com.app.todo.dto.todo;

import com.app.todo.domain.todo.ToDo;

import java.util.List;

public record ToDoListResponseDTO(List<ToDo> toDoList) {
}
