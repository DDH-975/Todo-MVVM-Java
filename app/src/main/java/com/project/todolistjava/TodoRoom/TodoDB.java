package com.project.todolistjava.TodoRoom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {TodoEntity.class}, version = 1)
public abstract class TodoDB extends RoomDatabase {
    public abstract TodoDao dao();

    private static volatile TodoDB INSTANCE;

    public static TodoDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TodoDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    TodoDB.class, "todo_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
