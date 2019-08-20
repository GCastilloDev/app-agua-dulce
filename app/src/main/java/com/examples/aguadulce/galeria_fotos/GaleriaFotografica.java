package com.examples.aguadulce.galeria_fotos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.examples.aguadulce.R;

public class GaleriaFotografica extends AppCompatActivity {

    private GridView gvGaleria;
    private String [] nombres = {"Terreno 1","Terreno 2","Terreno 3","Terreno 4","Terreno 5","Terreno 6","Terreno 7","Terreno 8"};
    private int [] terrenos = {R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,R.drawable.img_5,R.drawable.img_6,R.drawable.img_7,R.drawable.img_8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria_fotografica);

        gvGaleria = findViewById(R.id.gvGaleria);

        Adaptador adaptador = new Adaptador();
        gvGaleria.setAdapter(adaptador);
        gvGaleria.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(),GaleriaItem.class);
                intent.putExtra("name",nombres[i]);
                intent.putExtra("image",terrenos[i]);
                startActivity(intent);
            }
        });
    }

    private class Adaptador extends BaseAdapter {


        @Override
        public int getCount() {
            return terrenos.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.galeria_item,null);

            TextView nombre = view1.findViewById(R.id.tvText);
            ImageView imagen = view1.findViewById(R.id.images);

            nombre.setText(nombres[i]);
            imagen.setImageResource(terrenos[i]);

            return view1;
        }
    }
}
