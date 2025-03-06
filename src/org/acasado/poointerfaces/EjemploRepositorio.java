package org.acasado.poointerfaces;

import org.acasado.poointerfaces.modelo.Cliente;
import org.acasado.poointerfaces.repositorio.*;
import org.acasado.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.acasado.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.acasado.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {

    public static void main(String[] args) {

        try {
            OrdenablePaginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio();

            repo.crear(new Cliente("Jano", "Pérez"));
            repo.crear(new Cliente("Bea", "González"));
            repo.crear(new Cliente("Luci", "Martínez"));
            repo.crear(new Cliente("Andres", "Guzmán"));


            List<Cliente> clientes = repo.listar();
            clientes.forEach(System.out::println);
            System.out.println("========Paginable=========");
            List<Cliente> paginable = repo.listar("apellido", Direccion.ASC);

            paginable.forEach(System.out::println);

            System.out.println("=======Ordenar========");

            List<Cliente> clientesOrdenAsc = repo.listar("Bea", Direccion.ASC);


            for (Cliente c : clientesOrdenAsc) {
                System.out.println(c);
            }

            System.out.println("======= editar =======");
            Cliente beaActualizar = new Cliente("Bea", "Mena");

            beaActualizar.setId(2);

            repo.editar(beaActualizar);
            Cliente bea = repo.porId(2);
            System.out.println(bea);
            System.out.println("====Listar========");
            List<Cliente> clientesOrdenAsc2 = repo.listar("mena", Direccion.ASC);

            for (Cliente c : clientesOrdenAsc2) {
                System.out.println(c);
            }

            System.out.println("=====eliminar=======");
            repo.eliminar(2);

            repo.listar().forEach(System.out::println);

        }catch (LecturaAccesoDatoException e){
            System.out.println("Error Lectura: "+ e.getMessage());
            e.printStackTrace();
        }catch (AccesoDatoException e){
            System.out.println("Error general: "+ e.getMessage());
            e.printStackTrace();
        }
    }


}
