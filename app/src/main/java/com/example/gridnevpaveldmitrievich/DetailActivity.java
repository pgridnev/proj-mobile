package com.example.gridnevpaveldmitrievich;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.res.Configuration;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_ITEM = "selected_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Если устройство в альбомной ориентации – закрываем активность
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.activity_detail);

        String selectedItem = getIntent().getStringExtra(EXTRA_ITEM);
        if (selectedItem == null) selectedItem = "Не выбрано";

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.detailFragment);
        if (fragment instanceof DetailFragment) {
            ((DetailFragment) fragment).setSelectedItem(selectedItem);
        }
    }
}