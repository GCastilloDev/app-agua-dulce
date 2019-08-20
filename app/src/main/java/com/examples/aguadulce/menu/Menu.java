package com.examples.aguadulce.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.examples.aguadulce.R;
import com.examples.aguadulce.clave_aleatoria.ClaveAleatorioVista;
import com.examples.aguadulce.galeria_fotos.GaleriaFotografica;
import com.examples.aguadulce.graficas.Graficas;

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

    public void irGenerarClave(View v){
        startActivity(new Intent(this, ClaveAleatorioVista.class));
    }

    public void irGraficas(View v){
        startActivity(new Intent(this, Graficas.class));
    }

    public void irFotos(View v){
        startActivity(new Intent(this, GaleriaFotografica.class));
    }

}
