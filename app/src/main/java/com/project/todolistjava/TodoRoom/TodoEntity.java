package com.project.todolistjava.TodoRoom;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TodoEntity {
    @PrimaryKey(autoGenerate = true)
    private int id = 0;
    private String todo;

    public TodoEntity() {
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


}
