package com.bookstore.api.dto;


public class OrderDetailDTO {
    private Long id;
    private Long OrdersId;
    private Long BookId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdersId() {
        return OrdersId;
    }

    public void setOrdersId(Long ordersId) {
        OrdersId = ordersId;
    }

    public Long getBookId() {
        return BookId;
    }

    public void setBookId(Long bookId) {
        BookId = bookId;
    }
}
