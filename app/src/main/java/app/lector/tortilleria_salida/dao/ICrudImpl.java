package app.lector.tortilleria_salida.dao;

import java.io.Serializable;

import app.lector.tortilleria_salida.base.Base;


// <T extends Base, ID extends Serializable> implements ICrud< T, ID>
public abstract class ICrudImpl <T extends Base, ID extends Serializable> implements ICrud< T, ID>
{


//    @Override
//    public T findById(ID id) throws Exception {
//
//        try {
//            T entities = this.iCrudImpl.findById(id);
//            return entities;
//
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//    }
//
//    @Override
//    public T save(T entity) throws Exception {
//        try {
//            T entities = this.iCrudImpl.save(entity);
//            return entities;
//
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//    }
//
//    @Override
//    public T update(ID id, T entity) throws Exception {
//        try {
//
//
//            Optional<T> entityOptional1 = Optional.ofNullable(this.iCrudImpl.findById(id));
//            T entityUpdate = entityOptional1.get();
//            entityUpdate = this.iCrudImpl.save(entity);
//            return entityUpdate;
//
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//    }
//
//    @Override
//    public boolean delete(ID id) throws Exception {
//        return false;
//    }
}
