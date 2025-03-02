package service;

import dao.DaoCategoria;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import model.Categoria;
import model.Producto;
import model.error.ExamError;

import java.util.List;

public class ServiceCategoria {

    private final DaoCategoria daoCategoria;

    @Inject
    public ServiceCategoria(DaoCategoria daoCategoria) {
        this.daoCategoria = daoCategoria;
    }

    public Either<ExamError, List<Categoria>> getAll(){
        return daoCategoria.getAll();
    }
}
