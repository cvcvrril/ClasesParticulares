package ui;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import model.Categoria;
import model.Producto;
import service.ServiceCategoria;
import service.ServiceProducto;

import java.util.List;

public class Ejemplo2 {

    public static void main(String[] args) {

        /**
         * Ejemplo 2. Sacar todas las categorías
         * **/

        SeContainerInitializer seContainerInitializer = SeContainerInitializer.newInstance();
        final SeContainer container = seContainerInitializer.initialize();
        ServiceCategoria service = container.select(ServiceCategoria.class).get();
        List<Categoria> productos = service.getAll().get();

        System.out.println(productos);


    }

}
