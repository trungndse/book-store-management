package com.bookstore.api.controller;

import com.bookstore.api.controller.CRUDController;
import com.bookstore.api.dto.AuthorDTO;
import com.bookstore.persistence.Operation;
import com.bookstore.persistence.model.Author;
import com.bookstore.persistence.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController extends CRUDController<AuthorDTO> {

    @Autowired
    private AuthorService service;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AuthorDTO convertToDto(Object resource) {
        return modelMapper.map(resource, AuthorDTO.class);
    }

    @Override
    public Object convertToEntity(AuthorDTO authorDTO) {
        return modelMapper.map(authorDTO, Author.class);
    }

    @Override
    public Operation getService() {
        return (Operation) service;
    }
}
