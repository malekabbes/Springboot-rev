package com.example.rest_service.controller;

import com.example.rest_service.generic.ControllerGeneric;
import com.example.rest_service.models.Book;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController extends ControllerGeneric<Book,Long> {

}
