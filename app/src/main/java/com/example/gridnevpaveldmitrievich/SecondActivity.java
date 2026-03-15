package com.example.gridnevpaveldmitrievich;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView tvFirstname, tvLastname;
    private EditText editSubject;
    private Button btnEnterInfo;

    // ActivityResultLauncher для получения результата из ThirdActivity
    private ActivityResultLauncher<Intent> thirdActivityLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvFirstname = findViewById(R.id.tv_firstname);
        tvLastname = findViewById(R.id.tv_lastname);
        editSubject = findViewById(R.id.edit_subject);
        btnEnterInfo = findViewById(R.id.btn_enter_info);

        // Получаем данные из MainActivity
        String firstname = getIntent().getStringExtra("firstname");
        String lastname = getIntent().getStringExtra("lastname");
        tvFirstname.setText("Имя: " + firstname);
        tvLastname.setText("Фамилия: " + lastname);

        // Регистрируем callback для получения результата из ThirdActivity
        thirdActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            String day = result.getData().getStringExtra("day");
                            String time = result.getData().getStringExtra("time");
                            String comment = result.getData().getStringExtra("comment");
                            String message = "Занятие запланировано: " + day + " в " + time + " (" + comment + ")";
                            Toast.makeText(SecondActivity.this, message, Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(SecondActivity.this, "Операция отменена", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        btnEnterInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Передаём предмет в третью активность (можем передать, если нужно)
                String subject = editSubject.getText().toString();
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("subject", subject);
                thirdActivityLauncher.launch(intent);
            }
        });
    }
}