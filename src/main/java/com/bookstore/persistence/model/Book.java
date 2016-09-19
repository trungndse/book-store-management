package com.bookstore.persistence.model;

import javax.persistence.*;


@Entity
public class Book {
    private long id;
    private boolean active;
    private String description;
    private String image;
    private String name;
    private double price;
    private int quantity;
    private Genre genreByGenreId;
    private Author authorByAuthorId;
    private Publisher publisherByPublisherId;

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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
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
    @Column(name = "price")
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    public Genre getGenreByGenreId() {
        return genreByGenreId;
    }
    public void setGenreByGenreId(Genre genreByGenreId) {
        this.genreByGenreId = genreByGenreId;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    public Author getAuthorByAuthorId() {
        return authorByAuthorId;
    }
    public void setAuthorByAuthorId(Author authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }

    @ManyToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    public Publisher getPublisherByPublisherId() {
        return publisherByPublisherId;
    }
    public void setPublisherByPublisherId(Publisher publisherByPublisherId) {
        this.publisherByPublisherId = publisherByPublisherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (active != book.active) return false;
        if (Double.compare(book.price, price) != 0) return false;
        if (quantity != book.quantity) return false;
        if (description != null ? !description.equals(book.description) : book.description != null) return false;
        if (image != null ? !image.equals(book.image) : book.image != null) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantity;
        return result;
    }
}
