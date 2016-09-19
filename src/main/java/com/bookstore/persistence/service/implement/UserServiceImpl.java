package com.bookstore.persistence.service.implement;

import com.bookstore.persistence.dao.UserDao;
import com.bookstore.persistence.model.User;
import com.bookstore.persistence.service.OrdersService;
import com.bookstore.persistence.service.UserService;
import com.bookstore.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User, Long> implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    protected PagingAndSortingRepository<User, Long> getDao() {
        return dao;
    }

    @Override
    public User findByEmail(String email) {
        return dao.findByEmail(email);
    }
}
