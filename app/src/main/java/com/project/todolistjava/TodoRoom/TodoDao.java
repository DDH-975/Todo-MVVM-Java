package com.project.todolistjava.TodoRoom;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TodoDao {
    @Query("SELECT * FROM TODOENTITY")
    LiveData<List<TodoEntity>> getAllData();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void setInsertTodo(TodoEntity todo);

    @Query("DELETE FROM TodoEntity")
    void deleteAllTodo();

    @Query("DELETE FROM TodoEntity WHERE id = :id")
    void deleteDataWhereId(int id);

}
