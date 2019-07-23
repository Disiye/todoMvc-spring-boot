package com.thoughtworks.todomvc.controller;


import com.thoughtworks.todomvc.entity.ToDoMvc;
import com.thoughtworks.todomvc.exception.ItemNotNniqueException;
import com.thoughtworks.todomvc.service.ToDoMvcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/todo-mvcs")
public class ToDoMvcController {

    @Autowired
    private ToDoMvcService toDoMvcService;

    @PostMapping
    public ResponseEntity createTodoMvc(@RequestBody ToDoMvc toDoMvc) throws ItemNotNniqueException {
        toDoMvcService.addTodoMvc(toDoMvc);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        toDoMvcService.deleteTodoMvc(id);
    }

    @DeleteMapping()
    public void deleteAll() {
        toDoMvcService.deleteAllTodoMvc();
    }

    @GetMapping()
    public ResponseEntity findAll(HttpServletResponse response) {
        return ResponseEntity.ok().body(toDoMvcService.findAll());
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody ToDoMvc toDoMvc, @PathVariable String id) {
        return toDoMvcService.updateTodoMvc(toDoMvc, id);
    }
}
