package com.bookstore.persistence.service;


import com.bookstore.persistence.model.User;

public interface UserService {
    User findByEmail(String email);
}
