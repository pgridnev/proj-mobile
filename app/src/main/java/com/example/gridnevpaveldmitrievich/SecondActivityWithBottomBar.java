package com.example.gridnevpaveldmitrievich;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SecondActivityWithBottomBar extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_with_bottom);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true); // показываем кнопку назад
            actionBar.setTitle("Главная");
        }

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Устанавливаем слушатель
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                int id = item.getItemId();
                if (id == R.id.action_home) {
                    fragment = new HomeBottomFragment();
                    if (actionBar != null) actionBar.setTitle("Главная");
                } else if (id == R.id.action_notifications) {
                    fragment = new NotificationsBottomFragment();
                    if (actionBar != null) actionBar.setTitle("Уведомления");
                } else if (id == R.id.action_settings) {
                    fragment = new SettingsBottomFragment();
                    if (actionBar != null) actionBar.setTitle("Настройки");
                }

                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, fragment)
                            .commit();
                }
                return true;
            }
        });

        // По умолчанию показываем Home
        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.action_home);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Обработка кнопки "Назад" в ActionBar
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}