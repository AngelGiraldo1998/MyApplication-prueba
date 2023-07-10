package com.example.myapplication_prueba.Modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Libro
{
    private String title;
    private  String volumen;
    private  String year;
    private String cover;

    public Libro (JSONObject jsondato)throws JSONException
    {
        title=jsondato.getString("title");
        volumen=jsondato.getString("volumen");
        year =jsondato.getString("year");
        cover =jsondato.getString("cover");
    }
    public static ArrayList<Libro> JsonObjectsBuild(JSONArray jsondato) throws JSONException
    {
        ArrayList<Libro> libros = new ArrayList<>();
        for (int i = 0; i < jsondato.length() && i<20; i++) {
            libros.add(new Libro(jsondato.getJSONObject(i)));
        }
        return libros;
    }
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


}
