package com.project.todolistjava;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.project.todolistjava.TodoRoom.TodoEntity;
import com.project.todolistjava.TodoRoom.TodoRepository;

import java.util.List;


public class Todo_ViewModel extends AndroidViewModel {
    private TodoRepository repository;
    private LiveData<List<TodoEntity>> liveData;


    public Todo_ViewModel(@NonNull Application application) {
        super(application);
        repository = new TodoRepository(application);
        liveData = repository.getAllData();

    }

    public LiveData<List<TodoEntity>> getAllData() {
        return liveData;
    }

    public void deleteAllData() {
        repository.deleteAllData();
    }

    public void deleteDataWhereId(int id) {
        repository.deleteDataWhereId(id);
    }

    public void insertData(TodoEntity data) {
        repository.InsertData(data);
    }


}
