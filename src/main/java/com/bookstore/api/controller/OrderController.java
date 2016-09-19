package com.bookstore.api.controller;


import com.bookstore.api.dto.OrdersDTO;
import com.bookstore.persistence.Operation;
import com.bookstore.persistence.model.Orders;
import com.bookstore.persistence.model.User;
import com.bookstore.persistence.service.OrdersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController extends CRUDController<OrdersDTO> {

    @Autowired
    private OrdersService service;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrdersDTO convertToDto(Object resource) {
        return modelMapper.map(resource, OrdersDTO.class);
    }

    @Override
    public Object convertToEntity(OrdersDTO ordersDTO) {
        Orders orders = modelMapper.map(ordersDTO, Orders.class);
        User user = new User();
        user.setId(ordersDTO.getUserId());
        orders.setUserByUserId(user);
        return orders;
    }

    @Override
    public Operation getService() {
        return (Operation) service;
    }
}
