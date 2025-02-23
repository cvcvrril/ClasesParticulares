package org.example.domain.model;

public class Usuario {

    private int id;
    private String username;
    private String password;
    private String rol;

    public Usuario() {
    }

    public Usuario(int id, String password, String username, String rol) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }


}




