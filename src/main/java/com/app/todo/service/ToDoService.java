package com.app.todo.service;

import com.app.todo.domain.todo.ToDo;
import com.app.todo.dto.todo.ToDoIdDTO;
import com.app.todo.dto.todo.ToDoListResponseDTO;
import com.app.todo.dto.todo.ToDoRequestDTO;
import com.app.todo.dto.todo.ToDoUpdateDTO;
import com.app.todo.exceptions.NotFoundException;
import com.app.todo.repositories.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public ToDoListResponseDTO getAllToDos() {
        List<ToDo> toDoList = this.toDoRepository.findAll();
        return new ToDoListResponseDTO(toDoList);
    }

    public ToDoIdDTO createToDo(ToDoRequestDTO toDoRequestDTO) {
        ToDo toDo = new ToDo();
        toDo.setTitle(toDoRequestDTO.title());
        toDo.setChecked(false);

        this.toDoRepository.save(toDo);

        return new ToDoIdDTO(toDo.getId());
    }

    public ToDoIdDTO checkToDo(String toDoId, ToDoUpdateDTO checked) {
        ToDo toDoToUpdate = this.toDoRepository.findById(toDoId).orElseThrow(() -> new NotFoundException("to do not found with this id: " + toDoId));
        toDoToUpdate.setChecked(checked.checked());
        this.toDoRepository.save(toDoToUpdate);
        return new ToDoIdDTO(toDoToUpdate.getId());
    }

    public void deleteToDo(String toDoId) {
        this.toDoRepository.deleteById(toDoId);
    }
}
