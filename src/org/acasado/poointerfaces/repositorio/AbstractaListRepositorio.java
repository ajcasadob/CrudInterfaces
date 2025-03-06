// src/org/acasado/poointerfaces/repositorio/AbstractaListRepositorio.java
package org.acasado.poointerfaces.repositorio;

import org.acasado.poointerfaces.modelo.BaseEntidad;
import org.acasado.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import org.acasado.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio<T extends BaseEntidad> implements OrdenablePaginableCrudRepositorio<T> {

    protected List<T> dataSource;

    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public T porId(Integer id) throws LecturaAccesoDatoException {

        if (id== null|| id < 0) {
            throw new LecturaAccesoDatoException("Id inválido debe ser < 0");
        }
        T resultado = null;
        for (T item : dataSource) {
            if (item.getId() != null && item.getId().equals(id)) {
                resultado = item;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatoException {
        if (t ==null) {
            throw new EscrituraAccesoDatoException("Error al crear el objeto");
        }
        if (this.dataSource.contains(t)){
        throw new EscrituraAccesoDatoException("Error el objeto ya existe"+t.getId()+"El objeto ya existe en la base de datos");

        }

        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException {
        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return new ArrayList<>(dataSource.subList(desde, hasta));
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}