package com.examples.aguadulce.informacion_catastral;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.examples.aguadulce.R;

import java.util.ArrayList;

public class InfoCatastral extends AppCompatActivity {

    ArrayList<InformacionCatastral> lista;
    RecyclerView recyclerId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_catastral);

        lista = new ArrayList<InformacionCatastral>();
        recyclerId = findViewById(R.id.recyclerId);
        recyclerId.setLayoutManager(new LinearLayoutManager(this));

        llenarPersonajes();

        AdaptadorCatastral adapter = new AdaptadorCatastral(lista);
        recyclerId.setAdapter(adapter);
    }

    private void llenarPersonajes() {
        lista.add(new InformacionCatastral("Gustavo","552390","Calle siempre viva"));
        lista.add(new InformacionCatastral("Yosiel","552390","Calle siempre viva"));
        lista.add(new InformacionCatastral("David Emanuel","552390","Calle siempre viva"));
        lista.add(new InformacionCatastral("Orlando","552390","Calle siempre viva"));
        lista.add(new InformacionCatastral("Luis David","552390","Calle siempre viva"));
        lista.add(new InformacionCatastral("Tirso Antonio","552390","Calle siempre viva"));
        lista.add(new InformacionCatastral("Alejandro","552390","Calle siempre viva"));
        lista.add(new InformacionCatastral("Carlos","552390","Calle siempre viva"));
        lista.add(new InformacionCatastral("Perla","552390","Calle siempre viva"));
        lista.add(new InformacionCatastral("Karla","552390","Calle siempre viva"));
        lista.add(new InformacionCatastral("Isaias","552390","Calle siempre viva"));
        lista.add(new InformacionCatastral("Antonio","552390","Calle siempre viva"));
        lista.add(new InformacionCatastral("Rogelio","552390","Calle siempre viva"));
        lista.add(new InformacionCatastral("Hugo","552390","Calle siempre viva"));
        lista.add(new InformacionCatastral("Rafael","552390","Calle siempre viva"));
    }
}
