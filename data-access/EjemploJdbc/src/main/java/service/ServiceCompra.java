package service;

import dao.DaoCompra;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import model.Categoria;
import model.Compra;
import model.error.ExamError;

import java.util.List;

public class ServiceCompra {

    private final DaoCompra daoCompra;

    @Inject
    public ServiceCompra(DaoCompra daoCompra) {
        this.daoCompra = daoCompra;
    }

    public Either<ExamError, Integer> addCompraComplex(){
        return null;
    }

    public Either<ExamError, Integer> addCompra(Compra newCompra){
        return daoCompra.addCompra(newCompra);
    }
}
