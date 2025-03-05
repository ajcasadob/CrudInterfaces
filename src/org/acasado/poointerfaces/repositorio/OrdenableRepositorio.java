package org.acasado.poointerfaces.repositorio;

import org.acasado.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio<T> {

    List<Cliente> listar(String campo, Direccion dir);


}
