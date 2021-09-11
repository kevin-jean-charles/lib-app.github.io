package com.kcode.library;

import com.kcode.library.model.Book;
import com.kcode.library.model.Bookcase;
import com.kcode.library.model.User;
import com.kcode.library.repository.UserRepository;
import com.kcode.library.service.BookcaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

}
