package org.example.domain.model;

import java.util.List;


public class Cancion {
    private int id;
    private String nombre;
    private List<Album> albumCancion; //Albumes que contienen esta canción

    public Cancion() {
    }

    public Cancion(int id, List<Album> albumCancion, String nombre) {
        this.id = id;
        this.albumCancion = albumCancion;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Album> getAlbumCancion() {
        return albumCancion;
    }

    public void setAlbumCancion(List<Album> albumCancion) {
        this.albumCancion = albumCancion;
    }
}
