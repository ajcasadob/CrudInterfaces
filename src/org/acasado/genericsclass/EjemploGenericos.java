package org.acasado.genericsclass;

import java.util.Objects;

public class EjemploGenericos {
public static<T> void immprimirCamion(Camion<T> camion){
    for (T a: camion){
        if (a instanceof Animal){
            System.out.println(((Animal) a).getNombre() + " Tipo: " + ((Animal) a).getTipo());
        }
        else if (a instanceof Automovil){
            System.out.println(((Automovil) a).getMarca());
        } else if (a instanceof Maquinaria) {
            System.out.println(((Maquinaria) a).getTipo());

        }

    }
}

    public static void main(String[] args) {

        Camion<Animal> transporteCaballos = new Camion<>(5);
        transporteCaballos.add(new Animal("Peregrino", "Caballo"));
        transporteCaballos.add(new Animal("Grillo", "Caballo"));
        transporteCaballos.add(new Animal("Tunquen", "Caballo"));
        transporteCaballos.add(new Animal("Tunquen", "Caballo"));
        transporteCaballos.add(new Animal("Longotoman", "Caballo"));

        immprimirCamion(transporteCaballos);

        Camion<Maquinaria> transMaquinas = new Camion<>(3);
        transMaquinas.add(new Maquinaria("Bulldozer"));
        transMaquinas.add(new Maquinaria("Grúa Horquilla"));
        transMaquinas.add(new Maquinaria("Perforadora"));

        immprimirCamion(transMaquinas);
        Camion<Automovil> transautos = new Camion<>(3);
        transautos.add(new Automovil("Toyota"));
        transautos.add(new Automovil("Mitsubishi"));
        transautos.add(new Automovil("Chevrolet"));

        immprimirCamion(transautos);
    }
}