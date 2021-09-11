package com.kcode.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Long id;


    @Column(name = "title", length = 120)
    private String title;

    private String[] authors;

    @Lob
    @Column(name = "book_desc")
    private String bookDesc;


    @Column(name = "isbn", length = 13)
    private Long isbn;

    @Lob
    @Column(name = "cover_page")
    private String coverPage;


    @OneToOne(optional = false, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "position_id", referencedColumnName = "position_id", nullable = false)
    private Position position;

}
