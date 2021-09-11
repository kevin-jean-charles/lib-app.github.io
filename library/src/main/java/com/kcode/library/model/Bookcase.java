package com.kcode.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "bookcases")
@NoArgsConstructor
public class Bookcase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookcase_id", nullable = false)
    private Long bookcaseId;

    @Column(name = "name", unique = true, length = 20)
    private String name;

    @Lob
    @Column(name = "bookcase_desc")
    private String bookcaseDesc;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Book> bookSet;

    @Column(name = "total_book_number", unique = true)
    private Integer totalBookNumber;

    @Column(name = "max_bookcase_capacity", unique = true)
    private Integer maxBookcaseCapacity;

}
