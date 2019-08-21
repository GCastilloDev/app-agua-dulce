package com.examples.aguadulce.informacion_catastral;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.examples.aguadulce.R;

import java.util.ArrayList;

public class AdaptadorCatastral extends RecyclerView.Adapter<AdaptadorCatastral.ViewHolder> {

    ArrayList<InformacionCatastral> lista;

    public AdaptadorCatastral(ArrayList<InformacionCatastral> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_catastral_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String textoUno = "Contribuyente: ";
        String textoDos = "Número de cuenta: ";
        String textoTres = "Domicilio: ";

        holder.tvNombre.setText(textoUno + lista.get(position).getNombre());
        holder.tvCuenta.setText(textoDos + lista.get(position).getCuenta());
        holder.tvDomicilio.setText(textoTres + lista.get(position).getDomicilio());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNombre;
        TextView tvCuenta;
        TextView tvDomicilio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvCuenta = itemView.findViewById(R.id.tvCuenta);
            tvDomicilio = itemView.findViewById(R.id.tvDomicilio);
        }
    }
}
