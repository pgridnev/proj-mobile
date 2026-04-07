package com.example.gridnevpaveldmitrievich;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private EditText editName, editCompany, editAge;
    private TextView textResult;


    private ActivityResultLauncher<Intent> resultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editCompany = findViewById(R.id.editCompany);
        editAge = findViewById(R.id.editAge);
        textResult = findViewById(R.id.textResult);

        Button btnSendData = findViewById(R.id.btnSendData);
        Button btnSendObject = findViewById(R.id.btnSendObject);
        Button btnStartForResult = findViewById(R.id.btnStartForResult);
        Button btnThirdActivity = findViewById(R.id.btnThirdActivity);


        resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            if (data != null) {
                                String message = data.getStringExtra("RESULT_MESSAGE");
                                textResult.setText("Результат: " + message);
                            }
                        } else {
                            textResult.setText("Операция отменена");
                        }
                    }
                }
        );


        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String company = editCompany.getText().toString();
                int age = Integer.parseInt(editAge.getText().toString());

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("company", company);
                intent.putExtra("age", age);
                startActivity(intent);
            }
        });


        btnSendObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String company = editCompany.getText().toString();
                int age = Integer.parseInt(editAge.getText().toString());

                User user = new User(name, company, age);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("user_serializable", (Serializable) user);   // Serializable
                intent.putExtra("user_parcelable", (Parcelable) user);     // Parcelable
                startActivity(intent);
            }
        });


        btnStartForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("request_result", true);
                resultLauncher.launch(intent);
            }
        });


        btnThirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}