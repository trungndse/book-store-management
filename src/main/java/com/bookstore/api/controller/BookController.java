package com.bookstore.api.controller;

import com.bookstore.api.dto.BookDTO;
import com.bookstore.persistence.Operation;
import com.bookstore.persistence.model.Book;
import com.bookstore.persistence.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController extends CRUDController<BookDTO> {

    @Autowired
    private BookService service;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BookDTO convertToDto(Object resource) {
        BookDTO dto = modelMapper.map(resource, BookDTO.class);
        return dto;
    }

    @Override
    public Object convertToEntity(BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO, Book.class);
        return book;
    }

    @Override
    public Operation getService() {
        return (Operation) service;
    }
}
