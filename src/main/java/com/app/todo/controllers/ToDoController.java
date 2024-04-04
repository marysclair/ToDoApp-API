package com.app.todo.controllers;

import com.app.todo.dto.todo.ToDoIdDTO;
import com.app.todo.dto.todo.ToDoListResponseDTO;
import com.app.todo.dto.todo.ToDoRequestDTO;
import com.app.todo.dto.todo.ToDoUpdateDTO;
import com.app.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoService toDoService;

    @GetMapping
    public ResponseEntity<ToDoListResponseDTO> getAllToDos(){
        ToDoListResponseDTO todos = this.toDoService.getAllToDos();
        return ResponseEntity.ok(todos);
    }

    @PostMapping
    public ResponseEntity<ToDoIdDTO> createToDo(@RequestBody ToDoRequestDTO body, UriComponentsBuilder uriComponentsBuilder){
        System.out.println(body);
        ToDoIdDTO todo = this.toDoService.createToDo(body);
        var uri = uriComponentsBuilder.path("/todos/{id}").buildAndExpand(todo.toDoId()).toUri();

        return ResponseEntity.created(uri).body(todo);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ToDoIdDTO> updateToDoCheck(@RequestBody ToDoUpdateDTO body, @PathVariable String id){
        ToDoIdDTO toDo = this.toDoService.checkToDo(id, body);
        return ResponseEntity.ok(toDo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteToDo(@PathVariable String id){
        this.toDoService.deleteToDo(id);
        return ResponseEntity.ok("Deletado com sucesso!");
    }
}
