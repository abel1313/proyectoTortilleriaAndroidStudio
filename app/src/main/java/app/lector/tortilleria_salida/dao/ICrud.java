package app.lector.tortilleria_salida.dao;

import java.io.Serializable;
import java.util.List;

import app.lector.tortilleria_salida.base.Base;

public interface ICrud <T extends Base, ID extends Serializable>
{
    List<T> findAll() throws Exception;
//    public T findById(ID id) throws Exception;
//    public T save(T entity) throws Exception;
//    public T update(ID id, T entity) throws Exception;
//    public boolean delete(ID id) throws Exception;
}
