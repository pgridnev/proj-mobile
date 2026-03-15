package com.example.gridnevpaveldmitrievich;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    private EditText editDay, editTime, editComment;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        editDay = findViewById(R.id.edit_day);
        editTime = findViewById(R.id.edit_time);
        editComment = findViewById(R.id.edit_comment);
        btnOk = findViewById(R.id.btn_ok);

        // Можно получить предмет из SecondActivity (если нужно)
        String subject = getIntent().getStringExtra("subject");

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String day = editDay.getText().toString();
                String time = editTime.getText().toString();
                String comment = editComment.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("day", day);
                resultIntent.putExtra("time", time);
                resultIntent.putExtra("comment", comment);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}