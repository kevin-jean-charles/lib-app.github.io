package com.kcode.library.service.impl;

import com.kcode.library.exception.BookNotFoundException;
import com.kcode.library.exception.BookcaseNotFoundException;
import com.kcode.library.model.Bookcase;
import com.kcode.library.repository.BookcaseRepository;
import com.kcode.library.service.BookcaseService;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookcaseServiceImpl implements BookcaseService {

    @Autowired
    private BookcaseRepository bookcaseRepository;

    @Override
    public Bookcase saveBookcase(Bookcase bookcase) {
        Bookcase savedBookcase = bookcaseRepository.save(bookcase);
        return savedBookcase;
    }

    @Override
    public Bookcase findBookcaseById(Long id) {
        Bookcase bookcaseById = bookcaseRepository.findById(id)
                .orElseThrow(() -> new BookcaseNotFoundException(id));
        return bookcaseById;
    }

    @Override
    public Page<Bookcase> findBookcases(Specification<Bookcase> bookcaseSpecs) {
        Sort sort = Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(0, 12, sort);
        Page<Bookcase> bookcasePage = bookcaseRepository.findAll( Specification.where(bookcaseSpecs), pageable);
        return bookcasePage;
    }

    @Override
    public Bookcase updateBookcase(Long id, Bookcase newBookcase) {
        return bookcaseRepository.findById(id)
                .map(bookcase -> {
                    bookcase.setName(newBookcase.getName());
                    bookcase.setBookcaseDesc(newBookcase.getBookcaseDesc());
                    return bookcaseRepository.save(bookcase);
                })
                .orElseGet(() -> {
                    newBookcase.setBookcaseId(id);
                    return bookcaseRepository.save(newBookcase);
                });
    }

    @Override
    public void deleteBookcase(Long id) {
        bookcaseRepository.deleteById(id);
    }
}
