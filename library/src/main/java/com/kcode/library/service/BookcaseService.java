package com.kcode.library.service;

import com.kcode.library.model.Bookcase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface BookcaseService {

    Bookcase saveBookcase(Bookcase bookcase);

    Bookcase findBookcaseById(Long bookcaseId);

    Page<Bookcase> findBookcases(Specification<Bookcase> bookcaseSpecs);

    void deleteBookcase(Long id);

    Bookcase updateBookcase(Long bookcaseId, Bookcase bookcase);
}
