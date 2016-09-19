package com.bookstore.persistence.dao;


import com.bookstore.persistence.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Long> {
}
