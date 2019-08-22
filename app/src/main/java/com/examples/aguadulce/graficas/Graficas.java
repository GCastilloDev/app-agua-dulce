package com.examples.aguadulce.graficas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.examples.aguadulce.R;
import com.examples.aguadulce.menu.Menu;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Graficas extends AppCompatActivity {

    private PieChart graficaPastel;
    private BarChart graficaBarra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficas);

        graficaPastel = findViewById(R.id.graficaPastel);
        graficaBarra = findViewById(R.id.graficaBarra);

        crearGraficaPastel();
        crearGraficaBarras();
    }

    private void crearGraficaPastel() {

        Description description = new Description();
        description.setText("Gráfica de pastel AD");
        description.setTextSize(12f);
        graficaPastel.setDescription(description);

        ArrayList<PieEntry> entradas = new ArrayList<>();
        entradas.add(new PieEntry(18.5f, "Uno"));
        entradas.add(new PieEntry(26.7f, "Dos"));
        entradas.add(new PieEntry(24.0f, "Tres"));
        entradas.add(new PieEntry(30.8f, "Cuatro"));

        PieDataSet pieDataSet = new PieDataSet(entradas, "Texto descripción\nuaiassa");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(18f);
        pieDataSet.setFormSize(20f);
        pieDataSet.setForm(Legend.LegendForm.CIRCLE);
        pieDataSet.setFormLineWidth(10f);
        //pieDataSet.setSelectionShift(50f); Distancia entre la descripcion y el grafico
        //pieDataSet.setSliceSpace(10f); Lineas divisoras


        PieData pieData = new PieData(pieDataSet);
        // pieData.setValueFormatter(new YourValueFormatter());


        graficaPastel.setData(pieData);
        graficaPastel.animateX(1500);
        //graficaPastel.setCenterTextRadiusPercent(.5f);
        graficaPastel.setHoleRadius(20.0f);
        //graficaPastel.setTransparentCircleAlpha(0);
        graficaPastel.setTransparentCircleRadius(30.0f);
        graficaPastel.setEntryLabelTextSize(15f);

    }


    private void crearGraficaBarras(){

        //CREAMOS LISTA CON VALORES
        ArrayList<BarEntry> entradas = new ArrayList<>();
        entradas.add(new BarEntry(0f,2f));
        entradas.add(new BarEntry(1f,4f));
        entradas.add(new BarEntry(2f,6f));
        entradas.add(new BarEntry(3f,8f));
        entradas.add(new BarEntry(4f,3f));
        entradas.add(new BarEntry(5f,1f));

        //MANDAMOS LOS DATOS PARA CREAR LA GRAFICA
        BarDataSet datos = new BarDataSet(entradas, "GRAFICA DE BARRAS");

        BarData data = new BarData(datos);

        //PONEMOS COLOR A CADA GRAFICA
        datos.setColors(ColorTemplate.COLORFUL_COLORS);

        //SEPARACION ENTRE LAS BARRAS
        data.setBarWidth(0.9f);

        graficaBarra.setData(data);

        //PONE LAS BARRAS CENTRADAS
        graficaBarra.setFitBars(true);
        graficaBarra.animateXY(1500,1500);
        graficaBarra.invalidate();


    }
}
