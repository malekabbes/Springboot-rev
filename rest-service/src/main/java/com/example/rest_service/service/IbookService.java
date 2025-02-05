package com.example.rest_service.service;

import java.util.List;
import java.util.Optional;

import com.example.rest_service.models.Book;


public interface IbookService {
    //création de book equivalent a insert
    Book saveBook(Book prod);

    //select add
    List<Book> findAllBook();

    // trouver un book par son Id ->Select where
    Optional<Book> findById(Long id);

    //supprimer un livre
    void deleteBook(Book product);


}
