package com.example.myapplication_prueba.Modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revista
{
   private String journal_id;
   private String portada;
   private String name;

   public Revista(JSONObject jsonDato) throws JSONException {
       journal_id=jsonDato.getString("journal_id");
       portada=jsonDato.getString("portada");
       name=jsonDato.getString("name");

   }
    public static ArrayList<Revista> JsonObjectsBuild(JSONArray jsondato) throws JSONException
    {
        ArrayList<Revista> revistas = new ArrayList<>();
        for (int i = 0; i < jsondato.length() && i<20; i++) {
            revistas.add(new Revista(jsondato.getJSONObject(i)));
        }
        return revistas;
    }

// son metodo que nos permite llamar en cualquier lugar
    public String getJournal_id()
    {
        return journal_id;
    }

    public void setJournal_id(String journal_id)
    {
        this.journal_id = journal_id;
    }

    public String getPortada()
    {
        return portada;
    }

    public void setPortada(String portada)
    {
        this.portada = portada;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
