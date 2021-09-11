package com.kcode.library.service;

import com.kcode.library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

public interface BookService {

    Book createBook(Book book);

    Book findBookById(Long bookId);

    Page<Book> findBooks();

    Page<Book> searchForBooks(Specification<Book> specs);

    Book updateBook(Long bookId, Book book);

    void deleteBook(Long bookId);

}
