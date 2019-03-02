package sdi.training.dao;


import sdi.training.model.CatPassport;

import java.io.Serializable;
import java.util.List;

public interface CatPassportDao<T, Id extends Serializable>  {
    void persist(T entity);
    List<T> findAll();
}
