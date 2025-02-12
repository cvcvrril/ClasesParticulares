package services;

import dao.DaoEjemplos;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import model.errors.ErrorObject;

public class ServiceEjemplos {

    private final DaoEjemplos daoEjemplos;

    @Inject
    public ServiceEjemplos(DaoEjemplos daoEjemplos){
        this.daoEjemplos = daoEjemplos;
    }

    public Either<ErrorObject, String> ejemplo1(){
        return daoEjemplos.ejemplo1();
    }

}
