package org.example.domain;

import org.example.dao.repositories.EmpleadoRepository;
import org.example.domain.model.Empleado;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository repository;

    public EmpleadoService(EmpleadoRepository repository) {
        this.repository = repository;
    }

    public List<Empleado> getEmpleados(){
        try {
            return repository.getEmpleados();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
