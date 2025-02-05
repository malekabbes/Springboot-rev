package com.example.rest_service.controller;

import com.example.rest_service.models.Book;
import com.example.rest_service.repository.BookRepository;
import com.example.rest_service.service.IbookService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.velocity.exception.ResourceNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IbookService bookService;

    @GetMapping
    public List<Book> getAllbook() {
        return bookService.findAllBook();
    }

    @PostMapping("/addbook")
    public Book createProduct(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/updateproduct/{id}")
    public ResponseEntity<Book> updateProduct(@PathVariable(value = "id") Long bookId,
                                                  @RequestBody Book bookDetails) throws ResourceNotFoundException {

        //extrair le book par son id de la base et lancer une exeption dans le cas ou l'id n'exite pas dans la base de books

        Book book = bookService.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("book not found for this id :: " + bookId));

        book.setTitle(bookDetails.getTitle());
        book.setPrice(bookDetails.getPrice());
        final Book updatedBook = bookService.saveBook(book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/deleteproduct/{id}")
    public Map<String, Boolean> deleteBook(@PathVariable(value = "id") Long bookId)
            throws ResourceNotFoundException {
        Book book = bookService.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bookId));

        bookService.deleteBook(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
