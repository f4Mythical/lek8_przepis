package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListaPrzepisowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_przepisow);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String kategoriaPrzepisu = getIntent().getStringExtra("KATEGORIA");


        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(kategoriaPrzepisu);


        ArrayList<Przepis> przepisy = RepozytoriumPrzepisow.getPrzepisy();
// TODO wyswietlic przepisy z tej kategori

        ListView listView = findViewById(R.id.listViewPrzepis);
        ArrayAdapter<Przepis> arrayAdapter = new ArrayAdapter<>(
                ListaPrzepisowActivity.this,
                android.R.layout.simple_list_item_1,
                przepisy
        );
        listView.setAdapter(arrayAdapter);
    }
}