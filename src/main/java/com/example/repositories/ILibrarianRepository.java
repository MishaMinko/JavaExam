package com.example.repositories;

import com.example.models.Librarian;
import org.springframework.data.repository.CrudRepository;

public interface ILibrarianRepository extends CrudRepository<Librarian, Long> {

}
