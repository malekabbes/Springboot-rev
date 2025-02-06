package com.example.rest_service.service.book;

import com.example.rest_service.models.Book;

import java.util.List;
import java.util.Optional;


public interface IBookService{
    //création de book equivalent a insert
    Book saveBook(Book prod);

    //select add
    List<Book> findAllBook();

    // trouver un book par son Id ->Select where
    Optional<Book> findById(Long id);

    //supprimer un livre
    void deleteBook(Book book);
}
