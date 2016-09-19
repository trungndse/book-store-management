package com.bookstore.persistence.dao;

import com.bookstore.persistence.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreDao extends JpaRepository<Genre,Long> {
}
