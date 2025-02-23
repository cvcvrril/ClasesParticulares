package org.example.dao.repositories;

import org.example.dao.data.StaticLists;
import org.example.domain.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final StaticLists staticLists;

    @Autowired
    public UserRepository(StaticLists staticLists) {
        this.staticLists = staticLists;
    }

    public Usuario getUsuarioByUsername(String username){
        return staticLists.getUsuarioByUsername(username);
    }


}
