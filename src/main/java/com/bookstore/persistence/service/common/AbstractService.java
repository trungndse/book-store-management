package com.bookstore.persistence.service.common;


import com.bookstore.persistence.Operation;
import jersey.repackaged.com.google.common.collect.Lists;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class AbstractService<T, K extends Serializable> implements Operation<T,K> {

    @Transactional(readOnly = true)
    public T findOne(final K id) {
        return getDao().findOne(id) ;
    }

    @Transactional(readOnly = true)
    public List<T> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

    public Page<T> findPaginated(final int page, final int size) {
        return getDao().findAll(new PageRequest(page, size));
    }

    public T create(final T entity) {
        return getDao().save(entity);
    }

    public T update(T entity) {
        return getDao().save(entity);
    }

    public void delete(T entity) {
        getDao().delete(entity);
    }

    public void deleteById(K id) {
        getDao().delete(id);
    }

    protected abstract PagingAndSortingRepository<T, K> getDao();
}
