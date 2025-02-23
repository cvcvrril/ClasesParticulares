package org.example.domain.model;

public class Usuario {

    private int id;
    private String username;
    private String password;

    public Usuario() {
    }

    public Usuario(int id, String password, String username) {
        this.id = id;
        this.password = password;
        this.username = username;
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




