package org.example.dao.data;

import org.example.domain.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    StaticLists sl = new StaticLists();

    public Usuario getUsuario(int id){
        return sl.getUsuario(id);
    }

    public Usuario getUsuarioByUsername(String username){
        return sl.getUsuarioByUsername(username);
    }


}
