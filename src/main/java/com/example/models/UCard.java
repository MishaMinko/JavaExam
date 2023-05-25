package com.example.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "u_cards")
public class UCard implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_out")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOut;

    @Column(name = "date_in")
    private Date dateIn;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "lib_id", nullable = false)
    private Librarian librarian;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    public UCard(Date dateOut, Date dateIn, Optional<AppUser> user, Optional<Librarian> librarian, Optional<Book> book)
    {
        this.dateOut = dateOut;
        this.dateIn = dateIn;
        this.user = user.get();
        this.librarian = librarian.get();
        this.book = book.get();
    }
}