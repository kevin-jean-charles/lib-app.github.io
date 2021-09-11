package com.kcode.library.service.impl;

import com.kcode.library.exception.BookNotFoundException;
import com.kcode.library.model.Book;
import com.kcode.library.repository.BookRepository;
import com.kcode.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private static final String BOOK_NOT_FOUND_MSG = "book with id %s not found";

    @Override
    public Book createBook(Book book) {

         return bookRepository.save(book);
    }


    @Override
    public Book findBookById(Long bookId) {
        return bookRepository
                .findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(
                        String.format(BOOK_NOT_FOUND_MSG, bookId)
                ));
    }

    @Override
    public Page<Book> findBooks() {
        Pageable pageable = PageRequest.of(0, 12);
        Page<Book> bookPage = bookRepository.findAll(pageable);
        return bookPage;
    }

    @Override
    public Page<Book> searchForBooks(Specification<Book> specs) {
        Pageable pageable = PageRequest.of(0, 12);
        Page<Book> bookPage = bookRepository.findAll(Specification.where(specs), pageable);
        return bookPage;
    }


    @Override
    public Book updateBook(Long bookId, Book book) {
        Book _book = findBookById(bookId);
//        Bookshelf _bookshelf = bookShelfService;
//                .findBookshelfById(book.getBookshelf().getId());
//
//        _book.setAuthor(book.getAuthor());
//        _book.setDescription(book.getDescription());
//        _book.setTitle(book.getTitle());
//        _book.setBookshelf(_bookshelf);
//        _book.setHeightNumber(book.getHeightNumber());
//        bookRepository.save(_book);
        return book;
    }

    @Override
    public void deleteBook(Long bookId) {
            bookRepository.deleteById(bookId);
    }

}
