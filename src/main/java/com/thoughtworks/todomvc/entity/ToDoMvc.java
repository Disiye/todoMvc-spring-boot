package com.thoughtworks.todomvc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "TODO_MVC")
public class ToDoMvc {

    @Id
    private String id;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "COMPLETE")
    private boolean complete;


    public ToDoMvc() {
    }

    public ToDoMvc(String id, String text, boolean complete) {
        this.id = id;
        this.text = text;
        this.complete = complete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
