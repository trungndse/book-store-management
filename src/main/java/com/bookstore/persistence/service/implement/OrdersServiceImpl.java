package com.bookstore.persistence.service.implement;


import com.bookstore.persistence.dao.OrdersDao;
import com.bookstore.persistence.model.Orders;
import com.bookstore.persistence.service.OrdersService;
import com.bookstore.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrdersServiceImpl extends AbstractService<Orders, Long> implements OrdersService {

    @Autowired
    private OrdersDao dao;

    @Override
    protected PagingAndSortingRepository<Orders, Long> getDao() {
        return dao;
    }
}
