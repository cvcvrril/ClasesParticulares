package org.example.dao;

import org.example.dao.data.StaticLists;
import org.example.domain.model.Usuario;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositorio extends ListCrudRepository<Usuario, Integer> {


}
