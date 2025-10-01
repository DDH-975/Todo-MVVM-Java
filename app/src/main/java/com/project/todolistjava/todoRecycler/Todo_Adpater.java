package com.project.todolistjava.todoRecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.todolistjava.OndeleteClickListener;
import com.project.todolistjava.R;
import com.project.todolistjava.TodoRoom.TodoEntity;

import java.util.ArrayList;
import java.util.List;

public class Todo_Adpater extends RecyclerView.Adapter<Todo_Adpater.Viewholder> {
    private List<TodoEntity> data = new ArrayList<>();
    private OndeleteClickListener listener;

    public Todo_Adpater(OndeleteClickListener listener) {
        this.listener = listener;
    }

    public void setData(List<TodoEntity> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public Todo_Adpater.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_todo_item, parent, false);
        Viewholder holder = new Viewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Todo_Adpater.Viewholder holder, int position) {
        holder.todo.setText(data.get(position).getTodo());
        holder.delete.setOnClickListener(it -> {
            listener.deleteClick(data.get(position).getId());
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageButton delete;
        private TextView todo;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            delete = itemView.findViewById(R.id.btnDelete);
            todo = itemView.findViewById(R.id.tvTodo);
        }
    }
}
