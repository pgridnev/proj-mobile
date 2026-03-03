package com.example.gridnevpaveldmitrievich;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyAppLifecycle";

    private EditText etName, etGroup, etAge, etGrade;
    private Button btnProgrammatic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etGroup = findViewById(R.id.etGroup);
        etAge = findViewById(R.id.etAge);
        etGrade = findViewById(R.id.etGrade);
        btnProgrammatic = findViewById(R.id.btnProgrammatic);

        // программный способ перехода:
        btnProgrammatic.setOnClickListener(v -> {
            Log.i(TAG, "btnProgrammatic clicked (programmatic)");
            openSecondActivityAndSendData();
            Toast.makeText(MainActivity.this, "Открываю вторую Activity (программно)", Toast.LENGTH_SHORT).show();
        });
    }

    public void onDeclarativeOpen(View view) {
        Log.i(TAG, "onDeclarativeOpen called (declarative)");
        openSecondActivityAndSendData();
        Toast.makeText(this, "Открываю вторую Activity (декларативно)", Toast.LENGTH_SHORT).show();
    }

    private void openSecondActivityAndSendData() {
        String name = etName.getText().toString().trim();
        String group = etGroup.getText().toString().trim();
        String age = etAge.getText().toString().trim();
        String grade = etGrade.getText().toString().trim();

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("EXTRA_NAME", name);
        intent.putExtra("EXTRA_GROUP", group);
        intent.putExtra("EXTRA_AGE", age);
        intent.putExtra("EXTRA_GRADE", grade);
        startActivity(intent);
    }

    @Override protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart()");
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
}