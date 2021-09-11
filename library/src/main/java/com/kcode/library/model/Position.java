package com.kcode.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "positions")
@AllArgsConstructor
@NoArgsConstructor
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookcase_id",  referencedColumnName = "bookcase_id")
    private Bookcase bookcase;

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private Level level;

    @Lob
    @Column(name = "position_picture")
    private String positionPicture;
}
