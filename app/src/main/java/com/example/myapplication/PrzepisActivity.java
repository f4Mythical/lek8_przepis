package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrzepisActivity extends AppCompatActivity {
private TextView Opis,Skladniki,Nazwa;
private ImageView Obraz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_przepis);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;



        });
        Opis = findViewById(R.id.textViewOpis);
        Nazwa = findViewById(R.id.textViewTytul);
        Skladniki = findViewById(R.id.textViewSkladniki);
        Obraz = findViewById(R.id.imageView);
        int idPrzepisuDoWyswietlenia = getIntent().getIntExtra("ID",0);
        Przepis przepis = RepozytoriumPrzepisow.zwrocPrzepisOId(idPrzepisuDoWyswietlenia);
        wyswietlprzepis(przepis);

    }
    private void wyswietlprzepis(Przepis przepis){
        Nazwa.setText(przepis.getNazwaPrzepisu());
        Skladniki.setText(przepis.getSkladniki());
        Opis.setText(przepis.getOpis());
        Obraz.setImageResource(przepis.getIdObrazka());

    }
}

