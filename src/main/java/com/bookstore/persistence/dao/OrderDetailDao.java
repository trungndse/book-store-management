package com.bookstore.persistence.dao;


import com.bookstore.persistence.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDao extends JpaRepository<OrderDetail, Long> {
}
