package com.bookstore.persistence.dao;


import com.bookstore.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
