package com.example.gridnevpaveldmitrievich; // замените на свой пакет

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCategories = findViewById(R.id.btn_categories);
        Button btnRecycler = findViewById(R.id.btn_recycler);
        Button btnScroll = findViewById(R.id.btn_scroll);
        Button btnSpinner = findViewById(R.id.btn_spinner);
        Button btnDrawer = findViewById(R.id.btn_drawer);
        Button btnBottomBar = findViewById(R.id.btn_bottombar);

        btnCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CategoryActivity.class));
            }
        });

        btnRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecyclerActivity.class));
            }
        });

        btnScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ScrollActivity.class));
            }
        });

        btnSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SpinnerActivity.class));
            }
        });

        btnDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainDrawerActivity.class));
            }
        });

        btnBottomBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivityWithBottomBar.class));
            }
        });
    }
}