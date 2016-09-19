package com.bookstore.persistence.service.implement;

import com.bookstore.persistence.dao.AuthorDao;
import com.bookstore.persistence.model.Author;
import com.bookstore.persistence.service.AuthorService;
import com.bookstore.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthorServiceImpl extends AbstractService<Author, Long> implements AuthorService{

    @Autowired
    private AuthorDao dao;

    @Override
    protected PagingAndSortingRepository<Author, Long> getDao() {
        return dao;
    }
}
