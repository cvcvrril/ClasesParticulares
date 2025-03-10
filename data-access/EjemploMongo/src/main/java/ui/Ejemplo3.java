package ui;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import services.ServiceEjemplos;

public class Ejemplo3 {

    public static void main(String[] args) {
        SeContainerInitializer seContainerInitializer = SeContainerInitializer.newInstance();
        final SeContainer container = seContainerInitializer.initialize();
        ServiceEjemplos serviceEjemplos = container.select(ServiceEjemplos.class).get();
        System.out.println("Ejemplo 3. Dame el nombre de una ciudad pasando el id");
        System.out.println("");
        System.out.println(serviceEjemplos.ejemplo3("01034"));
    }

}
