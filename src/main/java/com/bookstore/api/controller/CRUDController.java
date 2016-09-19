package com.bookstore.api.controller;

import com.bookstore.api.exception.ResourceNotFoundException;
import com.bookstore.api.util.RestPreconditions;
import com.bookstore.persistence.Operation;
import jersey.repackaged.com.google.common.base.Preconditions;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
public abstract class CRUDController<DTO> {


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public DTO findById(@PathVariable("id") final Long id, final HttpServletResponse response) {
        return convertToDto(RestPreconditions.checkFound(getService().findOne(id)));
    }

    @RequestMapping(params = {"page", "size"}, method = RequestMethod.GET)
    @ResponseBody
    public List<DTO> findPaginated(@RequestParam("page") final int page, @RequestParam("size") final int size) {
        final Page<DTO> resultPage = getService().findPaginated(page, size);
        if (page > resultPage.getTotalPages()) {
            throw new ResourceNotFoundException();
        }

        return resultPage.getContent().stream()
                .map(entity -> convertToDto(entity)).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final DTO resource) {
        Object entity = convertToEntity(resource);
        Preconditions.checkNotNull(entity);
        getService().create(entity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") final Long id, @RequestBody final DTO resource) {
        Preconditions.checkNotNull(resource);
        RestPreconditions.checkFound(getService().findOne(id));
        getService().update(convertToEntity(resource));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") final Long id) {
        getService().deleteById(id);
    }


    public abstract DTO convertToDto(Object resource);
    public abstract Object convertToEntity(DTO dto);
    public abstract Operation getService();
}
