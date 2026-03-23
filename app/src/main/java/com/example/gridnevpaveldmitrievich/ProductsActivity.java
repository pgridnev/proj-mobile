package com.example.gridnevpaveldmitrievich;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity {

    private TextView tvTitle;
    private ListView listView;
    private Button btnAdd, btnRemove;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> products = new ArrayList<>();
    private String currentCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        tvTitle = findViewById(R.id.tv_category_title);
        listView = findViewById(R.id.list_products);
        btnAdd = findViewById(R.id.btn_add);
        btnRemove = findViewById(R.id.btn_remove);

        currentCategory = getIntent().getStringExtra("category");
        tvTitle.setText("Категория: " + currentCategory);

        // Наполняем список в зависимости от категории
        fillProducts(currentCategory);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, products);
        listView.setAdapter(adapter);

        // Позволяем выбирать элементы для удаления
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddDialog();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = listView.getCheckedItemPosition();
                if (position != ListView.INVALID_POSITION) {
                    products.remove(position);
                    adapter.notifyDataSetChanged();
                    listView.clearChoices();
                    Toast.makeText(ProductsActivity.this, "Элемент удалён", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ProductsActivity.this, "Выберите элемент для удаления", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void fillProducts(String category) {
        products.clear();
        switch (category) {
            case "Фрукты":
                products.add("Яблоко");
                products.add("Груша");
                products.add("Банан");
                products.add("Апельсин");
                break;
            case "Овощи":
                products.add("Помидор");
                products.add("Огурец");
                products.add("Морковь");
                break;
            case "Ягоды":
                products.add("Клубника");
                products.add("Малина");
                products.add("Черника");
                break;
        }
    }

    private void showAddDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Добавить продукт");
        final EditText input = new EditText(this);
        builder.setView(input);
        builder.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String newProduct = input.getText().toString().trim();
                if (!newProduct.isEmpty()) {
                    products.add(newProduct);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(ProductsActivity.this, "Добавлено", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ProductsActivity.this, "Название не может быть пустым", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("Отмена", null);
        builder.show();
    }
}