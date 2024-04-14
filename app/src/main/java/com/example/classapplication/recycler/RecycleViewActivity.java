package com.example.classapplication.recycler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classapplication.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity extends AppCompatActivity {
    Button addButton;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<Person> personList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        personList = RecyclerHelper.personList;
        addButton = findViewById(R.id.addDataCard);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new MyAdapter(RecycleViewActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        fillRecyclerView();
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddEditrecyclerItem.class));
            }
        });
    }

    private void fillRecyclerView() {
        personList.add(new Person("VIT", "vit@vit.ac.in", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBmhiayzUj7t9rq8b1nL1S0eSDUHYeK1d6kPvb3OFtsQ&s", 20));
        personList.add(new Person("VIT1", "vit1@vit.ac.in", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBmhiayzUj7t9rq8b1nL1S0eSDUHYeK1d6kPvb3OFtsQ&s", 20));
        personList.add(new Person("VIT2", "vit2@vit.ac.in", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBmhiayzUj7t9rq8b1nL1S0eSDUHYeK1d6kPvb3OFtsQ&s", 20));
        personList.add(new Person("VIT3", "vit3@vit.ac.in", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBmhiayzUj7t9rq8b1nL1S0eSDUHYeK1d6kPvb3OFtsQ&s", 20));
        personList.add(new Person("VIT4", "vit4@vit.ac.in", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBmhiayzUj7t9rq8b1nL1S0eSDUHYeK1d6kPvb3OFtsQ&s", 20));
        personList.add(new Person("VIT5", "vit5@vit.ac.in", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBmhiayzUj7t9rq8b1nL1S0eSDUHYeK1d6kPvb3OFtsQ&s", 20));
        personList.add(new Person("VIT6", "CBDHSJBHSD", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBmhiayzUj7t9rq8b1nL1S0eSDUHYeK1d6kPvb3OFtsQ&s", 20));
        personList.remove(0);
    }

}