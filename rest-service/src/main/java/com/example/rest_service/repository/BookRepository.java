package com.example.rest_service.repository;

import com.example.rest_service.generic.GenericRepo;
import com.example.rest_service.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends GenericRepo<Book, Long> {
}
