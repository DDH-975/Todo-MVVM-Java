package com.project.todolistjava;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.todolistjava.TodoRoom.TodoEntity;
import com.project.todolistjava.databinding.ActivityMainBinding;
import com.project.todolistjava.todoRecycler.Todo_Adpater;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private Todo_ViewModel viewModel;
    private ActivityMainBinding binding;
    private Todo_Adpater adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            Insets imeInsets = insets.getInsets(WindowInsetsCompat.Type.ime());
            int bottomInset = imeInsets.bottom > 0 ? imeInsets.bottom : systemBars.bottom;

            v.setPadding(
                    systemBars.left,
                    systemBars.top,
                    systemBars.right,
                    bottomInset
            );
            return insets;
        });



        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()))
                .get(Todo_ViewModel.class);

        binding.setViewmodel(viewModel);
        binding.setLifecycleOwner(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        adapter = new Todo_Adpater(id -> {
            viewModel.deleteDataWhereId(id);
        });

        recyclerView.setAdapter(adapter);

        viewModel.getAllData().observe(this, todoData -> {
            adapter.setData(todoData);
            adapter.notifyDataSetChanged();
        });


        binding.btnAdd.setOnClickListener(it -> {
            String todoList = binding.etTodo.getText().toString().trim();
            Log.i("버튼클릭", todoList);
            if (todoList.isEmpty()) {
                Toast.makeText(this, "할일을 입력해주세요", Toast.LENGTH_SHORT).show();
            } else {
                TodoEntity data = new TodoEntity();
                data.setTodo(todoList);
                viewModel.insertData(data);
                Log.i("data", data.getTodo());
            }
        });


    }
}