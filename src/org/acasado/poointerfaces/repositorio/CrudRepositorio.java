package org.acasado.poointerfaces.repositorio;

import org.acasado.poointerfaces.modelo.Cliente;

import java.util.List;

public interface CrudRepositorio <T> {

    List<T> listar ();
    Cliente porId(Integer id);
    void crear(T cliente);
    void editar (T cliente);
    void eliminar(Integer id);


}
