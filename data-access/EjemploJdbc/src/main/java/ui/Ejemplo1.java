package ui;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import model.Producto;
import service.ServiceProducto;

import java.util.List;

public class Ejemplo1 {

    public static void main(String[] args) {

        /**
         * Ejemplo 1. Sacar todos los productos disponibles
         * **/

        SeContainerInitializer seContainerInitializer = SeContainerInitializer.newInstance();
        final SeContainer container = seContainerInitializer.initialize();
        ServiceProducto service = container.select(ServiceProducto.class).get();
        List<Producto> productos = service.getAll().getOrElseThrow(() -> new RuntimeException());

        System.out.println(productos);


    }

}
