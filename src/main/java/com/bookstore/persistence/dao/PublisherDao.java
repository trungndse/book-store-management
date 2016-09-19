package com.bookstore.persistence.dao;


import com.bookstore.persistence.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherDao extends JpaRepository<Publisher, Long> {
}
