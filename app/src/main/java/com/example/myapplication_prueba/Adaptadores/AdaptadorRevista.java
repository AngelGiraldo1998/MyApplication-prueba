package com.example.myapplication_prueba.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication_prueba.Modelo.Revista;
import com.example.myapplication_prueba.R;

import java.util.ArrayList;

public class AdaptadorRevista extends ArrayAdapter<Revista>
{
    //context es el nombre de la variable
    public AdaptadorRevista(Context context, ArrayList<Revista> datos)
    {
        super(context, R.layout.lyitem_revista_vist,datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = LayoutInflater.from(getContext());
    View item = inflater.inflate(R.layout.lyitem_revista_vist, null);

    TextView txtNombreRevista = (TextView) item.findViewById(R.id.id_title);
        txtNombreRevista.setText(getItem(position).getName());

        ImageView imageView = (ImageView)item.findViewById(R.id.imgPortada_RevistaEdi);
        // el glide es la "implementation 'com.github.bumptech.glide:glide:4.15.0'"
        Glide.with(this.getContext()).load(getItem(position).getPortada()).into(imageView);
        return(item);
    }
}
