package org.example.dao.data;

import org.example.domain.model.Empleado;
import org.example.domain.model.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class StaticLists {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static final List<Usuario> listaUsuarios = new ArrayList<>(List.of(
            new Usuario(1, encoder.encode("root"),"root",  "admin")));


    public Usuario getUsuario(int id){
        return listaUsuarios.get(id);
    }

    public Usuario getUsuarioByUsername(String username){
        return listaUsuarios.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElse(null);
    }

    /**
     * Esto moverlo de sitio, está un poco feo tenerlo todo aquí
     * **/

}
