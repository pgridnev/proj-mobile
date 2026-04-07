package com.example.gridnevpaveldmitrievich;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textReceived = findViewById(R.id.textReceived);
        Button btnBack = findViewById(R.id.btnBack);
        Button btnCancel = findViewById(R.id.btnCancel);


        Bundle extras = getIntent().getExtras();
        StringBuilder sb = new StringBuilder();

        if (extras != null) {
            // Простые типы
            if (extras.containsKey("name")) {
                String name = extras.getString("name");
                String company = extras.getString("company");
                int age = extras.getInt("age");
                sb.append("Простой объект:\n");
                sb.append("Name: ").append(name).append("\n");
                sb.append("Company: ").append(company).append("\n");
                sb.append("Age: ").append(age).append("\n");
            }


            if (extras.containsKey("user_serializable")) {
                User user = (User) extras.getSerializable("user_serializable");
                sb.append("\nSerializable User:\n");
                sb.append(user.toString()).append("\n");
            }


            if (extras.containsKey("user_parcelable")) {
                User user = extras.getParcelable("user_parcelable");
                sb.append("\nParcelable User:\n");
                sb.append(user.toString()).append("\n");
            }
        }

        textReceived.setText(sb.toString());

        boolean needResult = getIntent().getBooleanExtra("request_result", false);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (needResult) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("RESULT_MESSAGE", "Данные успешно обработаны");
                    setResult(Activity.RESULT_OK, resultIntent);
                }
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (needResult) {
                    setResult(Activity.RESULT_CANCELED);
                }
                finish();
            }
        });
    }
}