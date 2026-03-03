package com.example.gridnevpaveldmitrievich;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "MyAppLifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "SecondActivity: onCreate()");
        setContentView(R.layout.activity_second);

        TextView tvName = findViewById(R.id.tvName);
        TextView tvGroup = findViewById(R.id.tvGroup);
        TextView tvAge = findViewById(R.id.tvAge);
        TextView tvGrade = findViewById(R.id.tvGrade);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("EXTRA_NAME", "");
            String group = extras.getString("EXTRA_GROUP", "");
            String age = extras.getString("EXTRA_AGE", "");
            String grade = extras.getString("EXTRA_GRADE", "");

            tvName.setText("ФИО: " + name);
            tvGroup.setText("Группа: " + group);
            tvAge.setText("Возраст: " + age);
            tvGrade.setText("Желаемая оценка: " + grade);
        }
    }

    @Override protected void onStart() { super.onStart(); Log.d(TAG, "SecondActivity: onStart()"); }
    @Override protected void onResume() { super.onResume(); Log.d(TAG, "SecondActivity: onResume()"); }
    @Override protected void onPause() { super.onPause(); Log.d(TAG, "SecondActivity: onPause()"); }
    @Override protected void onStop() { super.onStop(); Log.d(TAG, "SecondActivity: onStop()"); }
    @Override protected void onDestroy() { super.onDestroy(); Log.d(TAG, "SecondActivity: onDestroy()"); }
}