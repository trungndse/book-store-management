package com.bookstore.persistence.service.implement;


import com.bookstore.persistence.dao.RoleDAO;
import com.bookstore.persistence.model.Role;
import com.bookstore.persistence.service.RoleService;
import com.bookstore.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl  extends AbstractService<Role, Long> implements RoleService{

    @Autowired
    private RoleDAO dao;

    @Override
    protected PagingAndSortingRepository<Role, Long> getDao() {
        return dao;
    }
}
