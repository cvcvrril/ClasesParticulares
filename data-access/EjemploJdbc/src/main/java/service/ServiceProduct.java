package service;

import dao.DaoProducto;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import model.Producto;
import model.error.ExamError;

import java.util.List;

public class ServiceProduct {

    private final DaoProducto daoProducto;

    @Inject
    public ServiceProduct(DaoProducto daoProducto) {
        this.daoProducto = daoProducto;
    }

    public Either<ExamError, List<Producto>> getAll(){
        return daoProducto.getAll();
    }
}
