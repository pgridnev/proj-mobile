package com.example.gridnevpaveldmitrievich;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SpinnerActivity extends AppCompatActivity {

    private String[] cities = {"Москва", "Санкт-Петербург", "Казань", "Новосибирск", "Екатеринбург"};
    private TextView tvSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        Spinner spinner = findViewById(R.id.spinner);
        tvSelected = findViewById(R.id.tv_selected);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvSelected.setText("Выбрано: " + cities[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tvSelected.setText("Ничего не выбрано");
            }
        });
    }
}