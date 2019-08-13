package com.examples.aguadulce.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.examples.aguadulce.R;

public class Menu extends AppCompatActivity {

    private TextView tvBienvenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tvBienvenido = findViewById(R.id.tvBienvenido);

        String mensajeBienvenida = tvBienvenido.getText().toString() + "\nGustavo Castillo Nájera";
        tvBienvenido.setText(mensajeBienvenida);
    }
}
