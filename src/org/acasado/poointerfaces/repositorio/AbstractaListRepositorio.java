// src/org/acasado/poointerfaces/repositorio/AbstractaListRepositorio.java
package org.acasado.poointerfaces.repositorio;

import org.acasado.poointerfaces.modelo.BaseEntidad;

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
    public T porId(Integer id) {
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
    public void crear(T t) {
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) {
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