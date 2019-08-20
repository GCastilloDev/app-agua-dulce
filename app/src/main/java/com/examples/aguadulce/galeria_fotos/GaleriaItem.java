package com.examples.aguadulce.galeria_fotos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.examples.aguadulce.R;

public class GaleriaItem extends AppCompatActivity {

    TextView tvDatos;
    ImageView ivDatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.galeria_item_description);

        tvDatos = findViewById(R.id.tvDatos);
        ivDatos = findViewById(R.id.ivDatos);

        Intent intent = getIntent();

        tvDatos.setText(intent.getStringExtra("name"));
        ivDatos.setImageResource(intent.getIntExtra("image",0));

    }
}
