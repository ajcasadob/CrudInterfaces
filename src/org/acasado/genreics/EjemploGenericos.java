package org.acasado.genreics;

import org.acasado.poointerfaces.modelo.Cliente;
import org.acasado.poointerfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {

    public static void main(String[] args) {

        List <Cliente>clientes= new ArrayList<>();

        clientes.add(new Cliente("Antonio","Casado"));

        Cliente antonio =  clientes.iterator().next();

        Cliente [] clientesArreglos = {new Cliente("Antonio","Casado"),new Cliente("Luci","Martinez")};
        Integer [] enterosArreglos ={1,2,3};

        List<Cliente> clientesLista  = fromArrayToList(clientesArreglos);

        List<Integer> enterosLista = fromArrayToList(enterosArreglos);

        clientesLista.forEach(System.out::println);
        enterosLista.forEach(System.out::println);

        List<String > nombres = fromArrayToList(new String[]{"Antonio","Pepe","Bea","Luci"},enterosArreglos);
        nombres.forEach(System.out::println);

        List<ClientePremium> clientePremiumList = fromArrayToList(new ClientePremium[]{new ClientePremium("Paco","Fernandez")});
        imprimirClientes(clientes);
        imprimirClientes(clientesLista);
        imprimirClientes(clientePremiumList);

        System.out.println("Maximo de 1,9 y 4 es: "+maximo(1,9,4));
        System.out.println("Máximo de 3.9, 11.6 , 7.78 es :"+maximo(3.9,11.6,7.78));
        System.out.println("Máximo de zanahoria, arándanos, manzana es :"+maximo("zanahoria","arándanos","manzana"));

    }
    public static <T >List<T> fromArrayToList(T[]c){
        return Arrays.asList(c);
    }

    public static <T extends Cliente & Comparable<T>>List<T> fromArrayToList(T[]c){
        return Arrays.asList(c);
    }

    public static <T extends Number>List<T> fromArrayToList(T[]c){
        return Arrays.asList(c);
    }
    public static <T,G>List<T> fromArrayToList(T[]c,G[] x){
        for (G elemento: x ){
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }

    public static  void imprimirClientes(List<? extends Cliente> clientes){

        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo(T a, T b, T c){

        T max = a;
        if (b.compareTo(max)>0){
            max = b;
        }
        if (c.compareTo(max)>0){
            max = c;
        }
        return max;
    }

}
