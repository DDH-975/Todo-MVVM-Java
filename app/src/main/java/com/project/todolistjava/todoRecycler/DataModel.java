package com.project.todolistjava.todoRecycler;

public class DataModel {
    private String todo;
    private int id;

    public DataModel(String todo, int id) {
        this.todo = todo;
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public int getId() {
        return id;
    }

}
