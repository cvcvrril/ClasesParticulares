package ui;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import model.Categoria;
import model.Compra;
import service.ServiceCategoria;
import service.ServiceCompra;

import java.util.List;

public class Ejemplo3 {

    public static void main(String[] args) {

        /**
         * Ejemplo 3. Añadir una compra realizada por un cliente que está en la base de datos
         * **/

        SeContainerInitializer seContainerInitializer = SeContainerInitializer.newInstance();
        final SeContainer container = seContainerInitializer.initialize();
        ServiceCompra service = container.select(ServiceCompra.class).get();
        System.out.println("Compra añadida " + service.addCompra(new Compra(6, "12345678A", 3, "tarjeta")));


    }

}
