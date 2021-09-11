package com.kcode.library.repository;

import com.kcode.library.model.Bookcase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookcaseRepository extends JpaRepository<Bookcase, Long>, JpaSpecificationExecutor<Bookcase> {
}
