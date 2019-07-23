package com.thoughtworks.todomvc.repository;

import com.thoughtworks.todomvc.entity.ToDoMvc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoMvcRepository extends JpaRepository<ToDoMvc, String> {

}
