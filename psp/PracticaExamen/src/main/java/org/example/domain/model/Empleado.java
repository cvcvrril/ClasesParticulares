package org.example.domain.model;

import java.util.Date;
import java.util.List;

public class Empleado {

    private int id;
    private String nombre;
    private String password;
    private String fechaNacimiento;
    private List<Movil> moviles;



    public Empleado(int id, String nombre, String password, String fechaNacimiento, List<Movil> moviles) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.moviles = moviles;
    }
}
