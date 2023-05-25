package com.example.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "books", indexes = {
        @Index(name = "name_index", columnList = "name", unique = true)
})
public class Book implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 64, nullable = false)
    private String name;
    @Column(name = "description", length = 512, nullable = true)
    private String description;
    @Column(name = "year", nullable = true)
    private  int year;
    @Column(name = "pages", nullable = true)
    private  int pages;
    @ManyToOne
    @JoinColumn(name = "theme_id", nullable = true)
    private Theme theme;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;
    @ManyToOne
    @JoinColumn(name = "press_id", nullable = true)
    private Press press;

    @OneToMany(mappedBy = "book")
    private Set<UCard> uCards;

    @ManyToMany
    @JoinTable(
            name="authors_books",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="author_id"))
    private Set<Author> authors;
}
