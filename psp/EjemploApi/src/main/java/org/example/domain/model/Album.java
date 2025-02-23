package org.example.domain.model;



import java.util.List;

public class Album {
    private int id;
    private String nombre;
    private List<Cancion> cancionList;
    private int artistaId;

    public Album() {
    }

    public Album(int id, int artistaId, List<Cancion> cancionList, String nombre) {
        this.id = id;
        this.artistaId = artistaId;
        this.cancionList = cancionList;
        this.nombre = nombre;
    }

    public int getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(int artistaId) {
        this.artistaId = artistaId;
    }

    public List<Cancion> getCancionList() {
        return cancionList;
    }

    public void setCancionList(List<Cancion> cancionList) {
        this.cancionList = cancionList;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
