package com.bookstore.persistence.service.implement;


import com.bookstore.persistence.dao.GenreDao;
import com.bookstore.persistence.model.Genre;
import com.bookstore.persistence.service.GenreService;
import com.bookstore.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GenreServiceImpl extends AbstractService<Genre, Long> implements GenreService {

    @Autowired
    private GenreDao dao;

    @Override
    protected PagingAndSortingRepository<Genre, Long> getDao() {
        return  dao;
    }
}
