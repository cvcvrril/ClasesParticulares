package org.example.dao.data;

import org.example.domain.model.Empleado;
import org.example.domain.model.Movil;
import org.example.domain.model.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StaticLists {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static final List<Usuario> listaUsuarios = new ArrayList<>(List.of(
            new Usuario(1, encoder.encode("root"),"root",  "ADMIN")));

    public static final List<Empleado> listaEmpleados = new ArrayList<>(List.of(
            new Empleado(1, "Pepe", encoder.encode("pepe"), "2000-01-01", new ArrayList<>()),

            new Empleado(2, "Ana", encoder.encode("ana123"), "1995-05-20", List.of(
                    new Movil("Samsung Galaxy S21", 2021, 128),
                    new Movil("iPhone 13", 2022, 256)
            )),

            new Empleado(3, "Carlos", encoder.encode("carlitos"), "1990-08-15", List.of(
                    new Movil("OnePlus 9", 2021, 128)
            )),

            new Empleado(4, "María", encoder.encode("mariapass"), "1988-12-10", List.of(
                    new Movil("Google Pixel 6", 2022, 128),
                    new Movil("iPhone 12", 2021, 256)
            )),

            new Empleado(5, "Javier", encoder.encode("javipas"), "1992-07-30", new ArrayList<>())
    ));

    public Usuario getUsuario(int id) {
        return listaUsuarios.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Usuario getUsuarioByUsername(String username) {
        return listaUsuarios.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElse(null);
    }

    public Empleado getEmpleado(int id) {
        return listaEmpleados.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Empleado> getAllEmpleados() {
        return listaEmpleados;
    }
}


