package com.examples.aguadulce.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.examples.aguadulce.R;
import com.examples.aguadulce.menu.Menu;

public class Login extends AppCompatActivity {

    private String phoneNumber;
    private EditText etPsw;
    private boolean visible = false;
    private ImageView ivMostrarOcultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        solicitarPermisos();

    }

    public void mostrarOcultar(View v){
        if(!visible){
            etPsw.setInputType(InputType.TYPE_CLASS_TEXT);
            ivMostrarOcultar.setImageResource(R.drawable.ic_visibility_off_black_24dp);
            visible = true;
        }

        if(!visible){
            etPsw.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
            ivMostrarOcultar.setImageResource(R.drawable.ic_visibility_black_24dp);
            visible = false;
        }

    }

    public void ingresar(View v){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
        finish();
    }

    /*
    Metodo que pide permisos para obtener el número celular
     */
    private void solicitarPermisos() {

        TelephonyManager tm = (TelephonyManager) this.getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);


        // Inicio para solicitar permisos y obtener el número celular
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_PHONE_STATE)){

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE},0);

            }else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE},0);
            }

        }else{
            phoneNumber  = tm.getLine1Number();
            Toast.makeText(this,"Tu numero1 es: " + phoneNumber,Toast.LENGTH_LONG).show();
        }
        // Fin de solicitud de permisos
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 0: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    TelephonyManager tm = (TelephonyManager) this.getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
                    if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {

                        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                                Manifest.permission.READ_PHONE_STATE)){

                        }else {
                            // No explanation needed; request the permission
                            ActivityCompat.requestPermissions(this,
                                    new String[]{Manifest.permission.READ_PHONE_STATE},
                                    0);

                            // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                            // app-defined int constant. The callback method gets the
                            // result of the request.
                        }

                    }else{
                        phoneNumber  = tm.getLine1Number();
                        Toast.makeText(this,"Tu numero2 es: " + phoneNumber,Toast.LENGTH_LONG).show();
                    }
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }


}
