package com.kcode.library.controller;


import com.kcode.library.model.Book;
import com.kcode.library.model.Bookcase;
import com.kcode.library.service.BookService;
import com.kcode.library.service.BookcaseService;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/v2")
public class BookcaseController {

    @Autowired
    private BookcaseService bookcaseService;


    @PostMapping("/bookcases")
    public ResponseEntity<Bookcase> newBookcase(@RequestBody Bookcase bookcase) {
        Bookcase newBookcase = bookcaseService.saveBookcase(bookcase);
        return new ResponseEntity<>(newBookcase, HttpStatus.CREATED);
    }

    @GetMapping("/bookcases/{id}")
    public ResponseEntity<Bookcase> findBookcase(@PathVariable Long id) {
        Bookcase bookcaseById = bookcaseService.findBookcaseById(id);
        return new ResponseEntity<>(bookcaseById, HttpStatus.FOUND);
    }

    @GetMapping("/bookcases")
    public ResponseEntity<Page<Bookcase>> findBookcases(@SearchSpec Specification<Bookcase> bookcaseSpecs) {
        Page<Bookcase> bookcaseList = bookcaseService.findBookcases(bookcaseSpecs);
        return new ResponseEntity<>(bookcaseList, HttpStatus.FOUND);
    }



    @PutMapping("/bookcases/{id}")
    public ResponseEntity<Bookcase> replaceBookcase(@PathVariable Long id , @RequestBody Bookcase newBookcase) {
        Bookcase updatedBookcase = bookcaseService.updateBookcase(id, newBookcase);
        return new ResponseEntity<>(updatedBookcase, HttpStatus.CREATED);
    }

    @DeleteMapping("/bookcases/{id}")
    public ResponseEntity<Bookcase> deleteBookcase(@PathVariable Long id) {
        bookcaseService.deleteBookcase(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
