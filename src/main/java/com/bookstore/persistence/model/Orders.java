package com.bookstore.persistence.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Entity
public class Orders {
    private long id;
    private String note;
    private Date orderTime;
    private String status;
    private int total;
    private Collection<OrderDetail> orderDetailsById;
    private User userByUserId;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "orderTime")
    public Date getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "total")
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }

    @OneToMany(mappedBy = "ordersByOrderId")
    public Collection<OrderDetail> getOrderDetailsById() {
        return orderDetailsById;
    }
    public void setOrderDetailsById(Collection<OrderDetail> orderDetailsById) {
        this.orderDetailsById = orderDetailsById;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUserByUserId() {
        return userByUserId;
    }
    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (id != orders.id) return false;
        if (total != orders.total) return false;
        if (note != null ? !note.equals(orders.note) : orders.note != null) return false;
        if (orderTime != null ? !orderTime.equals(orders.orderTime) : orders.orderTime != null) return false;
        if (status != null ? !status.equals(orders.status) : orders.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (orderTime != null ? orderTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + total;
        return result;
    }
}
