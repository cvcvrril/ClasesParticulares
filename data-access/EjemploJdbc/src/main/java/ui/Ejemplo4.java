package ui;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import model.Compra;
import service.ServiceCompra;

public class Ejemplo4 {

    public static void main(String[] args) {

        /**
         * Ejemplo 4. Añadir una compra realizada por un cliente que NO está en la base de datos
         * **/

        SeContainerInitializer seContainerInitializer = SeContainerInitializer.newInstance();
        final SeContainer container = seContainerInitializer.initialize();
        ServiceCompra service = container.select(ServiceCompra.class).get();



    }

}
