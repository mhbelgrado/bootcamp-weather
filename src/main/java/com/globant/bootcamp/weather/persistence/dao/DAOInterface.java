package com.globant.bootcamp.weather.persistence.dao;

import java.util.List;

/**
 * Created by maxib on 27/09/2016.
 */
interface DAOInterface<T> {

    T findById(int id);

    boolean deleteById(String id); //throws Exception;

    boolean insert(T entity);

    List<T> findAll();
}
