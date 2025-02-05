package com.example.rest_service.service;

import com.example.rest_service.models.Book;
import com.example.rest_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IbookServiceImpl implements IbookService {
    //Implementation de crud
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book product) {
        return bookRepository.save(product);
    }

    @Override
    public List<Book> findAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void deleteBook(Book product) {
        bookRepository.delete(product);
    }

}

