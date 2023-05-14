package com.example.pethelp;

import static com.example.pethelp.R.drawable.cachorro1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pethelp.enums.Caes;

import java.util.Locale;

public class AnimalActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        Intent i = getIntent();
        int id = i.getIntExtra("Cao",R.id.Cachorro1);
        ImageView imageView = findViewById(R.id.FotoAnimal);
        Caes cao = Caes.valueOf(i.getStringExtra("Nome").toUpperCase(Locale.ROOT));
        Drawable drawable = getResources().getDrawable(cao.getImagem());
        imageView.setBackground(drawable);
        Caes enumCao = (Caes) i.getSerializableExtra("Enum");
        Object[] s = new Object[5];
        s[0] = enumCao.getRaca();
        s[1] = enumCao.getCor();
        s[2] = enumCao.getGenero();
        s[3] = enumCao.getTemperamento();
        s[4] = enumCao.isCastrado();
        setDados(s);

    }

    private void setDados(Object[] dados){
        ((EditText)findViewById(R.id.Raca)).setText((String) dados[0]);
        ((EditText)findViewById(R.id.Cor)).setText((String) dados[1]);
        ((EditText)findViewById(R.id.Genero)).setText((String) dados[2]);
        ((EditText)findViewById(R.id.Temperamento)).setText((String) dados[3]);
        ((EditText)findViewById(R.id.Castrado)).setText(((Boolean) dados[4]).toString());
    }









}