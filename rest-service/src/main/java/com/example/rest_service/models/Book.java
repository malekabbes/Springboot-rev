package com.example.rest_service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    // l'id doit etre auto_incrementé
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title", nullable = false, length = 255)
    private String title;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="coverImage",columnDefinition = "TEXT")
    private String coverImage;

    @Column(name="price",nullable = false)
    private float price;

    @ManyToOne()
    @JoinColumn(name="author_id")
    private User author;

    // in constructeur sans paramétres pour respecter la tructure de bin
    public Book() {
    }

    public Book(String title, String description, User author, String coverImage, float price) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.coverImage = coverImage;
        this.price = price;
    }

    //generation de getters et setters


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}