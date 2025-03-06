package org.acasado.poointerfaces.repositorio;

import org.acasado.poointerfaces.modelo.Cliente;
import org.acasado.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.acasado.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;


import java.util.List;

public interface CrudRepositorio <T> {

    List<T> listar ();
    T porId(Integer id) throws AccesoDatoException;
    void crear(T t) throws AccesoDatoException;
    void editar (T t) throws LecturaAccesoDatoException;
    void eliminar(Integer id) throws AccesoDatoException;


}
