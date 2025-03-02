package service;

import dao.DaoProducto;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import model.Producto;
import model.error.ExamError;

import java.util.List;

public class ServiceProducto {

    private final DaoProducto daoProducto;

    @Inject
    public ServiceProducto(DaoProducto daoProducto) {
        this.daoProducto = daoProducto;
    }

    public Either<ExamError, List<Producto>> getAll(){
        return daoProducto.getAll();
    }
}
