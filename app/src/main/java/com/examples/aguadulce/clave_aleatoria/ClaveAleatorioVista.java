package com.examples.aguadulce.clave_aleatoria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.examples.aguadulce.R;
import com.examples.aguadulce.menu.Menu;
import com.examples.aguadulce.utilidades.ClaveAleatoria;

public class ClaveAleatorioVista extends AppCompatActivity {

    private TextView tvClaveActiva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clave_aleatoria);

        tvClaveActiva = findViewById(R.id.tvClaveActiva);
        tvClaveActiva.setText("Null");
    }

    /**
     * Método para el boton generar clave, que genera la clave, la manda al textview y manda
     * un cuadro de dialogo mostrando la clave.
     * @param v
     */
    public void generarClave(View v){
        String clave = ClaveAleatoria.generarClave();
        tvClaveActiva.setText(clave);
        mostrarDialogo(clave);
    }


    /**
     * Método que muestra un cuadro de dialogo con la clave nueva generada
     * @param clave De tipo <b>String</b> con la clave nueva generada para mostrarla en el cuadro de dialogo.
     */
    private void mostrarDialogo(String clave){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Contraseña Generada")
                .setMessage("La contraseña nueva es: " + clave)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Toast.makeText(getApplicationContext(),"Prueba",Toast.LENGTH_LONG).show();
                    }
                }).show();
    }

    /**
     * Método del botón compartir clave
     * @param v
     */
    public void compartirClave(View v){
        Intent compartir = new Intent(Intent.ACTION_SEND);
        compartir.setType("text/plain");
        String clave = tvClaveActiva.getText().toString();
        String mensaje = "La clave es: " + clave;
        compartir.putExtra(Intent.EXTRA_SUBJECT,"Clave generada")
                .putExtra(Intent.EXTRA_TEXT,mensaje);

        startActivity(Intent.createChooser(compartir,"Compartir vía"));
    }

    /**
     * Método para el boton regresar al menu
     * @param v
     */
    public void regresar(View v){
        startActivity(new Intent(this, Menu.class));
        finish();
    }
}
