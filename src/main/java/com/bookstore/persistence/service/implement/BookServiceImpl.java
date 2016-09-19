package com.bookstore.persistence.service.implement;


import com.bookstore.persistence.dao.BookDao;
import com.bookstore.persistence.model.Book;
import com.bookstore.persistence.service.BookService;
import com.bookstore.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookServiceImpl extends AbstractService<Book, Long> implements BookService {

    @Autowired
    private BookDao dao;


    @Override
    protected PagingAndSortingRepository<Book, Long> getDao() {
        return dao;
    }
}
