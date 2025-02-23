package org.example.dao.repositories;

import org.example.dao.data.StaticLists;
import org.example.domain.model.Empleado;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpleadoRepository {

    private final StaticLists staticLists;

    public EmpleadoRepository(StaticLists staticLists) {
        this.staticLists = staticLists;
    }

    public List<Empleado> getEmpleados(){
        return staticLists.getAllEmpleados();
    }
}
