package org.example.ui;


import jakarta.annotation.security.RolesAllowed;
import org.example.domain.EmpleadoService;
import org.example.domain.model.Empleado;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestEmpleados {

    private final EmpleadoService service;

    public RestEmpleados(EmpleadoService service) {
        this.service = service;
    }

    @RolesAllowed({"ADMIN"})
    @GetMapping("/empleados")
    public List<Empleado> getEmpleados(){
        return service.getEmpleados();
    }

}
