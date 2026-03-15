package com.example.gridnevpaveldmitrievich;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editFirstname, editLastname;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editFirstname = findViewById(R.id.edit_firstname);
        editLastname = findViewById(R.id.edit_lastname);
        btnNext = findViewById(R.id.btn_next);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = editFirstname.getText().toString();
                String lastname = editLastname.getText().toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("firstname", firstname);
                intent.putExtra("lastname", lastname);
                startActivity(intent);
            }
        });
    }
}