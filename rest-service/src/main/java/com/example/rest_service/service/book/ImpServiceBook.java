package com.example.rest_service.service.book;


import com.example.rest_service.generic.ImplementationGeneric;
import com.example.rest_service.models.Book;
import com.example.rest_service.service.book.IBookService;
import org.springframework.stereotype.Service;


@Service
public class ImpServiceBook extends ImplementationGeneric<Book, Long> implements IBookService {

}

