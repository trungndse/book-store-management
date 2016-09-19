package com.bookstore.persistence.model;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class Publisher {
    private long id;
    private boolean active;
    private String address;
    private String contactPerson;
    private String name;
    private String phone;
    private Collection<Book> booksById;

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
    @Column(name = "active")
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "contactPerson")
    public String getContactPerson() {
        return contactPerson;
    }
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @OneToMany(mappedBy = "publisherByPublisherId")
    public Collection<Book> getBooksById() {
        return booksById;
    }

    public void setBooksById(Collection<Book> booksById) {
        this.booksById = booksById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        if (id != publisher.id) return false;
        if (active != publisher.active) return false;
        if (address != null ? !address.equals(publisher.address) : publisher.address != null) return false;
        if (contactPerson != null ? !contactPerson.equals(publisher.contactPerson) : publisher.contactPerson != null)
            return false;
        if (name != null ? !name.equals(publisher.name) : publisher.name != null) return false;
        if (phone != null ? !phone.equals(publisher.phone) : publisher.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (contactPerson != null ? contactPerson.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
