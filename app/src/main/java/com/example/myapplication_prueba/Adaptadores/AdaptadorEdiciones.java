package com.example.myapplication_prueba.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.myapplication_prueba.Modelo.Libro;
import com.example.myapplication_prueba.R;
import java.util.ArrayList;

public class AdaptadorEdiciones extends ArrayAdapter<Libro>
{
    public AdaptadorEdiciones(Context context, ArrayList<Libro>datos)
    {
        super(context,R.layout.lyitem_edisiones,datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitem_edisiones, null);

        TextView txtNombreEdision = (TextView) item.findViewById(R.id.id_title);
        txtNombreEdision.setText(getItem(position).getTitle());

        TextView txtVolumen = (TextView) item.findViewById(R.id.textView_Volumen);
        txtVolumen.setText(getItem(position).getVolumen());

        TextView txtyear= (TextView) item.findViewById(R.id.textView_year);
        txtyear.setText(getItem(position).getYear());

        ImageView imageView = (ImageView)item.findViewById(R.id.imgPortada_RevistaEdi);
        // el glide es la "implementation 'com.github.bumptech.glide:glide:4.15.0'"
        Glide.with(this.getContext()).load(getItem(position).getCover()).into(imageView);
        return(item);
    }
}
