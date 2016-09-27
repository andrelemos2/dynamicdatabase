package br.com.gustavorodrig.dynamicdatabase.service;

import java.util.List;

/**
 * Created by gustavo
 */
public interface DefaultService<E, I> {
    E save(E entity);
    E findOne(I id);
    List<E> findAll();
    void delete(I id);
}
