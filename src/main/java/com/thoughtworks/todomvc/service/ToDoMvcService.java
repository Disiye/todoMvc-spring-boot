package com.thoughtworks.todomvc.service;

import com.thoughtworks.todomvc.entity.ToDoMvc;
import com.thoughtworks.todomvc.exception.ItemNotNniqueException;
import com.thoughtworks.todomvc.repository.ToDoMvcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ToDoMvcService {

    @Autowired
    private
    ToDoMvcRepository toDoMvcRepository;

    public void addTodoMvc(ToDoMvc toDoMvc) throws ItemNotNniqueException {
        try {
            toDoMvcRepository.saveAndFlush(toDoMvc);
        }catch (Exception e) {
            throw new ItemNotNniqueException("This record already exists!");
        }
    }

    public void deleteTodoMvc(String id) {
        toDoMvcRepository.deleteById(id);
    }

    public ResponseEntity<ToDoMvc> getOne(String id) {
        ToDoMvc toDoMvc = toDoMvcRepository.findById(id).get();
        return ResponseEntity.ok().body(toDoMvc);
    }

    public ResponseEntity updateTodoMvc(ToDoMvc toDoMvc, String id) {
        ToDoMvc toDoMvcDb = toDoMvcRepository.findById(id).get();
        toDoMvcDb.setComplete(toDoMvc.isComplete());
        toDoMvcDb.setText(toDoMvc.getText());
        return ResponseEntity.ok().body(toDoMvcDb);
    }

    public List<ToDoMvc> findAll() {
        return toDoMvcRepository.findAll();
    }

    public void deleteAllTodoMvc() {
        toDoMvcRepository.deleteAll();
    }
}
