package com.example.gridnevpaveldmitrievich;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView tvName, tvSurname;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); // создайте свой layout

        tvName = findViewById(R.id.tv_name);
        tvSurname = findViewById(R.id.tv_surname);
        btnBack = findViewById(R.id.btn_back);

        // Получаем данные из Intent
        String name = getIntent().getStringExtra("name");
        String surname = getIntent().getStringExtra("surname");

        tvName.setText("Имя: " + name);
        tvSurname.setText("Фамилия: " + surname);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", "Данные получены");
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}