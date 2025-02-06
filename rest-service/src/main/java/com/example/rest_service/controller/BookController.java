package com.example.rest_service.controller;
import com.example.rest_service.models.Book;
import com.example.rest_service.service.book.IBookService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public List<Book> getAllbook() {
        return bookService.findAllBook();
    }

    @PostMapping("/addbook")
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Long bookId,
                                           @RequestBody Book bookDetails) throws ResourceNotFoundException {

        //extrair le book par son id de la base et lancer une exeption dans le cas ou l'id n'exite pas dans la base de books

        Book book = bookService.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("book not found for this id :: " + bookId));


        //verifier que le prix n'est pas negatif
        if (bookDetails.getPrice() < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
            // update all book informations
            book.setTitle(bookDetails.getTitle());
            book.setPrice(bookDetails.getPrice());
            book.setAuthor(bookDetails.getAuthor());
            book.setCoverImage(bookDetails.getCoverImage());
            book.setDescription(bookDetails.getDescription());

        // insérer les modifications
        final Book updatedBook = bookService.saveBook(book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/unpublish/{id}")
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
