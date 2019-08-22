package com.examples.aguadulce.informacion_catastral;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.examples.aguadulce.R;

import java.util.ArrayList;

public class InfoCatastral extends AppCompatActivity {

    public ArrayList<InformacionCatastral> lista;
    RecyclerView recyclerId;
    private EditText etId;
    private EditText etNombre;
    private EditText etDomicilio;
    private EditText etNumeroCatastral;
    private Button btnGuardar;
    private Button btnEditar;
    private Button btnCompartir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_catastral);


        etId = findViewById(R.id.etId);
        etNombre = findViewById(R.id.etNombre);
        etDomicilio = findViewById(R.id.etDomicilio);
        etNumeroCatastral = findViewById(R.id.etNumeroCatastral);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnEditar = findViewById(R.id.btnEditar);
        btnCompartir = findViewById(R.id.btnCompartir);

        deshabilitarView();

        lista = new ArrayList<InformacionCatastral>();
        recyclerId = findViewById(R.id.recyclerId);
        recyclerId.setLayoutManager(new LinearLayoutManager(this));

        llenarPersonajes();
        crearAdaptador();

    }

    private void crearAdaptador(){
        AdaptadorCatastral adapter = new AdaptadorCatastral(lista);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = lista.get(recyclerId.getChildAdapterPosition(view)).getNombre();
                String id = Integer.toString(lista.get(recyclerId.getChildAdapterPosition(view)).getId());
                String domicilio = lista.get(recyclerId.getChildAdapterPosition(view)).getDomicilio();
                String numeroCatastral = lista.get(recyclerId.getChildAdapterPosition(view)).getCuenta();

                btnCompartir.setEnabled(true);
                int color = getResources().getColor(R.color.blanco);
                btnCompartir.setTextColor(color);

                etId.setText(id);
                etNombre.setText(nombre);
                etDomicilio.setText(domicilio);
                etNumeroCatastral.setText(numeroCatastral);
            }
        });

        recyclerId.setAdapter(adapter);
    }

    private void llenarPersonajes() {
        lista.add(new InformacionCatastral("Gustavo","552390","Calle siempre viva",0));
        lista.add(new InformacionCatastral("Yosiel","552390","Calle siempre viva",1));
        lista.add(new InformacionCatastral("David Emanuel","552390","Calle siempre viva",2));
        lista.add(new InformacionCatastral("Orlando","552390","Calle siempre viva",3));
        lista.add(new InformacionCatastral("Luis David","552390","Calle siempre viva",4));
        lista.add(new InformacionCatastral("Tirso Antonio","552390","Calle siempre viva",5));
        lista.add(new InformacionCatastral("Alejandro","552390","Calle siempre viva",6));
        lista.add(new InformacionCatastral("Carlos","552390","Calle siempre viva",7));
        lista.add(new InformacionCatastral("Perla","552390","Calle siempre viva",8));
        lista.add(new InformacionCatastral("Karla","552390","Calle siempre viva",9));
        lista.add(new InformacionCatastral("Isaias","552390","Calle siempre viva",10));
        lista.add(new InformacionCatastral("Antonio","552390","Calle siempre viva",11));
        lista.add(new InformacionCatastral("Rogelio","552390","Calle siempre viva",12));
        lista.add(new InformacionCatastral("Hugo","552390","Calle siempre viva",13));
        lista.add(new InformacionCatastral("Rafael","552390","Calle siempre viva",14));
    }

    public void guardar(View v){
        InformacionCatastral iC = new InformacionCatastral();
        iC.setId(Integer.parseInt(etId.getText().toString()));
        iC.setNombre(etNombre.getText().toString());
        iC.setCuenta(etNumeroCatastral.getText().toString());
        iC.setDomicilio(etDomicilio.getText().toString());

        int index = Integer.parseInt(etId.getText().toString());

        lista.set(index,iC);

        llenarPersonajes();
        crearAdaptador();


        deshabilitarView();
        vaciarCampos();


        Toast.makeText(this, "Su registro a sido actualizado con éxito!",Toast.LENGTH_LONG).show();

    }

    public void vaciarCampos(){
        etId.setText("");
        etNombre.setText("");
        etDomicilio.setText("");
        etNumeroCatastral.setText("");
    }

    public void deshabilitarView(){
        etId.setEnabled(false);
        etNombre.setEnabled(false);
        etDomicilio.setEnabled(false);
        etNumeroCatastral.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCompartir.setEnabled(false);

        int color = getResources().getColor(R.color.fondo_cardview_graficas);

        btnGuardar.setTextColor(color);
        btnCompartir.setTextColor(color);
    }

    public void habilitarView(){
        etId.setEnabled(true);
        etNombre.setEnabled(true);
        etDomicilio.setEnabled(true);
        etNumeroCatastral.setEnabled(true);
        btnGuardar.setEnabled(true);


        int color = getResources().getColor(R.color.blanco);

        btnGuardar.setTextColor(color);

    }

    public void editar(View v){
        habilitarView();
    }

    public void compartir(View v){
        Intent compartir = new Intent(Intent.ACTION_SEND);
        compartir.setType("text/plain");

        String nombre = etNombre.getText().toString();
        String numeroCatastral = etNumeroCatastral.getText().toString();
        String domicilio = etDomicilio.getText().toString();

        String mensaje = "Nombre: " + nombre +
                        "\nNúmero catastral: " + numeroCatastral +
                        "\nDomicilio: " + domicilio;

        compartir.putExtra(Intent.EXTRA_SUBJECT,"Información Catastral")
                .putExtra(Intent.EXTRA_TEXT,mensaje);

        startActivity(Intent.createChooser(compartir,"Compartir vía"));
    }
}
