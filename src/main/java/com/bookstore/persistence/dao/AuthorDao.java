package com.bookstore.persistence.dao;


import com.bookstore.persistence.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDao extends JpaRepository<Author, Long>{
}
