package com.example.gridnevpaveldmitrievich;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        List<ItemModel> data = new ArrayList<>();
        data.add(new ItemModel("Кошка", R.drawable.cat));
        data.add(new ItemModel("Собака", R.drawable.dog));
        data.add(new ItemModel("Птица", R.drawable.bird));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(data);
        recyclerView.setAdapter(adapter);
    }
}