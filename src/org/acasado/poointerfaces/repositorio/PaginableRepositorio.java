package org.acasado.poointerfaces.repositorio;

import org.acasado.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio<T> {

    List<T> listar (int desde, int hasta);

}
