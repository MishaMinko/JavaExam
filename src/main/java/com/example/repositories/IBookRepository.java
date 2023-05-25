package com.example.repositories;

import com.example.models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends CrudRepository<Book, Long> {

    //@Query(value = "SELECT b FROM books b JOIN u_cards u ON b.id = u.book_id", nativeQuery = true)
    @Query(value = "SELECT b.id, b.description, b.name, b.pages, b.year, b.category_id, b.press_id, b.theme_id FROM books b JOIN u_cards u ON b.id = u.book_id;", nativeQuery = true)
    Iterable<Book> findOnHandBooks();

    @Query(value = "SELECT b.id, b.description, b.name, b.pages, b.year, b.category_id, b.press_id, b.theme_id FROM books b LEFT JOIN u_cards u ON b.id = u.book_id WHERE u.id IS NULL", nativeQuery = true)
    Iterable<Book> findInStockBooks();

    @Query(value = "SELECT b.id, b.description, b.name, b.pages, b.year, b.category_id, b.press_id, b.theme_id FROM books b JOIN u_cards u ON b.id = u.book_id WHERE u.date_out < CURRENT_DATE()", nativeQuery = true)
    Iterable<Book> findOverdueBooks();
}