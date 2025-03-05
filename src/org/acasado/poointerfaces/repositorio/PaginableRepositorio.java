package org.acasado.poointerfaces.repositorio;

import org.acasado.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio<T> {

    List<Cliente> listar (int desde, int hasta);

}
