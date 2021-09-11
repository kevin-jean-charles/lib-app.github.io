package com.kcode.library.controller;


import com.kcode.library.model.Book;

import com.kcode.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping
//    @PreAuthorize("hasRole('VOLUNTEER') or hasRole('ADMIN')")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book newBook = bookService.createBook(book);
            return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }




//    @GetMapping("/{bookId}")
//    public ResponseEntity<Book> getBookById(@PathVariable Long bookId) {
//        Book bookById = bookService.findBookById(bookId);
//        return new ResponseEntity<>(bookById, HttpStatus.OK);
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<Page<Book>> findAllBooks() {
//        Page<Book> books = bookService.findBooks();
//        return new ResponseEntity<>(books, HttpStatus.OK);
//    }
//
//    @PreAuthorize("hasRole('VOLUNTEER') or hasRole('ADMIN')")
//    @PutMapping("/{bookId}")
//    public ResponseEntity<Book> updateBook(@PathVariable Long bookId, @RequestBody Book book) {
//        bookService.updateBook(bookId, book);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//
//    @PreAuthorize("hasRole('VOLUNTEER') or hasRole('ADMIN')")
//    @DeleteMapping("/{bookId}")
//    public ResponseEntity<Book> deleteBook(@PathVariable Long bookId) {
//        bookService.deleteBook(bookId);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @GetMapping
//    public ResponseEntity<Page<Book>> searchForBooks(@SearchSpec Specification<Book> specs) {
//        try {
//            Page<Book> bookPage = bookService.searchForBooks(specs);
//            return new ResponseEntity<>(bookPage, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}


