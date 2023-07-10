package com.example.myapplication_prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication_prueba.Adaptadores.AdaptadorRevista;
import com.example.myapplication_prueba.Modelo.Revista;
import com.example.myapplication_prueba.WebService.Asynchtask;
import com.example.myapplication_prueba.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask, AdapterView.OnItemClickListener {
ListView lstOp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url="https://revistas.uteq.edu.ec/ws/journals.php";

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService(url,datos,MainActivity.this,MainActivity.this);
        ws.execute("GET");

        // la llamada de la vista
        lstOp=(ListView)findViewById(R.id.lyListaRevista);
        //lstOp=findViewById(R.id.lyListaRevista);

        //inicializacion del evento onclick
        lstOp.setOnItemClickListener(this);

    }

    @Override
    public void processFinish(String result) throws JSONException
    {
        JSONArray JSONlistarevista= new JSONArray(result);
       //MOEDELO
        ArrayList<Revista> lstrevista =Revista.JsonObjectsBuild(JSONlistarevista);
        //ADAPTADOR
        AdaptadorRevista adaptadorRevista=new AdaptadorRevista(MainActivity.this,lstrevista);
        lstOp.setAdapter(adaptadorRevista);


    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        //crea objecto revista y guarda las posicion seleccionada
        Revista revista=(Revista)parent.getItemAtPosition(position);

        //Se declara un avariable para almcacenar el journal_id de la revista
        String identificador =revista .getJournal_id().toString();

        // crea objecto intent para redirigir a la nueva actividada
        Intent intent =new Intent(MainActivity.this,EdicionesActivity.class);

        //crea onjecto bundle para enviar el parametro id a la nueva actividad
        Bundle bundle=new Bundle();
        bundle.putString("id",identificador);

        //enviar al bundle a la nueva actividad y la inicializa
        intent.putExtras(bundle);
        startActivity(intent);

        String indetificador;
        Toast.makeText(this,"ID SELLECIONADO"+identificador,Toast.LENGTH_SHORT).show();
        
    }
}