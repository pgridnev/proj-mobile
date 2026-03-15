package com.example.gridnevpaveldmitrievich;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editName, editSurname;
    private Button btnGoToSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // используйте любой из созданных layout

        editName = findViewById(R.id.edit_name);
        editSurname = findViewById(R.id.edit_surname);
        btnGoToSecond = findViewById(R.id.btn_submit);

        btnGoToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String surname = editSurname.getText().toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("surname", surname);
                startActivity(intent);
            }
        });
    }
}