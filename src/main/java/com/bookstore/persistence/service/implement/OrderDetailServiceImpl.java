package com.bookstore.persistence.service.implement;



import com.bookstore.persistence.dao.OrderDetailDao;
import com.bookstore.persistence.model.OrderDetail;
import com.bookstore.persistence.service.OrderDetailService;
import com.bookstore.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderDetailServiceImpl extends AbstractService<OrderDetail, Long> implements OrderDetailService {

    @Autowired
    private OrderDetailDao dao;

    @Override
    protected PagingAndSortingRepository<OrderDetail, Long> getDao() {
        return dao;
    }
}
