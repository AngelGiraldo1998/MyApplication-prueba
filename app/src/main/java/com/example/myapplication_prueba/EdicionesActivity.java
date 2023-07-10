package com.example.myapplication_prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication_prueba.Adaptadores.AdaptadorEdiciones;
import com.example.myapplication_prueba.Adaptadores.AdaptadorRevista;
import com.example.myapplication_prueba.Modelo.Libro;
import com.example.myapplication_prueba.Modelo.Revista;
import com.example.myapplication_prueba.WebService.Asynchtask;
import com.example.myapplication_prueba.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EdicionesActivity extends AppCompatActivity implements Asynchtask {
    private ListView lstOp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ediciones);

        Bundle bunble =this.getIntent().getExtras();

        String url="https://revistas.uteq.edu.ec/ws/issues.php?j_id="+ bunble.getString("id");
// se usa para crea una variable para la url del web service y se le concatena el parametro id requirdo

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService(url,datos,EdicionesActivity.this,EdicionesActivity.this);
        ws.execute("GET");

        lstOp=(ListView)findViewById(R.id.lwEdiciones);

    }

    @Override
    public void processFinish(String result) throws JSONException
    {
        JSONArray JSONlistalibro= new JSONArray(result);
        //MOEDELO
        ArrayList<Libro> lstlibro =Libro.JsonObjectsBuild(JSONlistalibro);

        //ADAPTADOR
        AdaptadorEdiciones adaptadorLibro=new AdaptadorEdiciones(EdicionesActivity.this,lstlibro);
        lstOp.setAdapter(adaptadorLibro);

    }
}