package com.bookstore.api.controller;

import com.bookstore.api.dto.GenreDTO;
import com.bookstore.persistence.Operation;
import com.bookstore.persistence.model.Genre;
import com.bookstore.persistence.service.GenreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genre")
public class GenreController extends CRUDController<GenreDTO> {

    @Autowired
    private GenreService service;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public GenreDTO convertToDto(Object resource) {
        return modelMapper.map(resource, GenreDTO.class);
    }

    @Override
    public Object convertToEntity(GenreDTO genreDTO) {
        return modelMapper.map(genreDTO, Genre.class);
    }

    @Override
    public Operation getService() {
        return (Operation) service;
    }


}
