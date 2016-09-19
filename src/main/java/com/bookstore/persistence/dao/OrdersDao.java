package com.bookstore.persistence.dao;


import com.bookstore.persistence.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersDao extends JpaRepository<Orders, Long> {
}
