package com.bookstore.persistence.dao;


import com.bookstore.persistence.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Long> {
}
