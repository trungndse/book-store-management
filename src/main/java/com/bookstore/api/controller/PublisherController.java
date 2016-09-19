package com.bookstore.api.controller;


import com.bookstore.api.dto.PublisherDTO;
import com.bookstore.persistence.Operation;
import com.bookstore.persistence.model.Publisher;
import com.bookstore.persistence.service.PublisherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publisher")
public class PublisherController extends CRUDController<PublisherDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PublisherService service;

    @Override
    public PublisherDTO convertToDto(Object resource) {
        return modelMapper.map(resource, PublisherDTO.class);
    }

    @Override
    public Object convertToEntity(PublisherDTO publisherDTO) {
        return modelMapper.map(publisherDTO, Publisher.class);
    }

    @Override
    public Operation getService() {
        return (Operation) service;
    }
}
