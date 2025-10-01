package com.project.todolistjava.TodoRoom;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TodoRepository {
    private TodoDao dao;
    private LiveData<List<TodoEntity>> allData;
    private Executor executor = Executors.newSingleThreadExecutor();

    public TodoRepository(Application application) {
        TodoDB db = TodoDB.getDatabase(application);
        dao = db.dao();
        allData = dao.getAllData();
    }

    public LiveData<List<TodoEntity>> getAllData() {
        return allData;
    }


    public void InsertData(TodoEntity todoEntity) {
        executor.execute(() -> dao.setInsertTodo(todoEntity));
    }


    public void deleteAllData() {
        executor.execute(() -> dao.deleteAllTodo());

    }


    public void deleteDataWhereId(int id) {
        executor.execute(() -> dao.deleteDataWhereId(id));
    }

}
