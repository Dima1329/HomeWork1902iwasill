package com.samsung.myitschool.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> cities;
    private MyRecylerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cities = new ArrayList<>();
        cities.add("Москва");
        cities.add("Санкт-Петербург");
        cities.add("Калининград");
        cities.add("Берлин");
        cities.add("Мюнхен");
        cities.add("Нюрнберг");
        RecyclerView recyclerView = findViewById(R.id.cities);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecylerViewAdapter(this,cities);
        recyclerView.setAdapter(adapter);

        ExtendedFloatingActionButton btn_add = findViewById(R.id.floatingActionButton);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> items = new ArrayList<>();
                items.add("Париж");
                items.add("Нью-Йорк");
                items.add("Стокгольм");
                cities.addAll(items);
                adapter.notifyItemRangeInserted(6,items.size());
            }
        });



    }
}
