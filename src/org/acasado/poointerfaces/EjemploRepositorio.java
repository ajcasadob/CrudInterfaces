package org.acasado.poointerfaces;

import org.acasado.poointerfaces.modelo.Cliente;
import org.acasado.poointerfaces.repositorio.*;

import java.util.List;

public class EjemploRepositorio {

    public static void main(String[] args) {

        CrudRepositorio repo = new ClienteListRepositorio();

        repo.crear(new Cliente("Jano","Pérez"));
        repo.crear(new Cliente("Bea","González"));
        repo.crear(new Cliente("Luci","Martínez"));
        repo.crear(new Cliente("Andres","Guzmán"));


        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);
        System.out.println("========Paginable=========");
        List<Cliente> paginable = ((PaginableRepositorio)repo).listar(0,3);

        paginable.forEach(System.out::println);

        System.out.println("=======Ordenar========");

        List<Cliente> clientesOrdenAsc = ((OrdenableRepositorio)repo)
                .listar("nombre", Direccion.ASC);

        for (Cliente c : clientesOrdenAsc){
            System.out.println(c);
        }

        System.out.println("======= editar =======");
        Cliente beaActualizar = new Cliente("Bea","Mena");

        beaActualizar.setId(2);

        repo.editar(beaActualizar);
        Cliente bea = repo.porId(2);
        System.out.println(bea);
        System.out.println("====Listar========");
        List<Cliente> clientesOrdenAsc2 = ((OrdenableRepositorio)repo)
                .listar("nombre", Direccion.ASC);

        for (Cliente c : clientesOrdenAsc2){
            System.out.println(c);
        }

        System.out.println("=====eliminar=======");
        repo.eliminar(2);

        repo.listar().forEach(System.out::println);
    }
}
