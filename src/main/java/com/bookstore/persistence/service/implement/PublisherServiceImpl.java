package com.bookstore.persistence.service.implement;

import com.bookstore.persistence.dao.PublisherDao;
import com.bookstore.persistence.model.Publisher;
import com.bookstore.persistence.service.PublisherService;
import com.bookstore.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PublisherServiceImpl extends AbstractService<Publisher, Long> implements PublisherService {

    @Autowired
    private PublisherDao dao;

    @Override
    protected PagingAndSortingRepository<Publisher, Long> getDao() {
        return dao;
    }
}
