package ui;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import services.ServiceEjemplos;

public class Ejemplo1 {

    public static void main(String[] args) {
        SeContainerInitializer seContainerInitializer = SeContainerInitializer.newInstance();
        final SeContainer container = seContainerInitializer.initialize();
        ServiceEjemplos serviceEjemplos = container.select(ServiceEjemplos.class).get();
        System.out.println("Ejemplo 1. Dame el nombre de la primera ciudad de la lista");
        System.out.println("");
        System.out.println(serviceEjemplos.ejemplo1());
    }

}
