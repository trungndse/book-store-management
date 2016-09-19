package com.bookstore.persistence;


import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

public interface Operation<T, K extends Serializable> {
    T findOne(final K id);

    List<T> findAll();

    Page<T> findPaginated(int page, int size);

    T create(final T entity);
    T update(final T entity);

    void delete(final T entity);
    void deleteById(final K id);
}
