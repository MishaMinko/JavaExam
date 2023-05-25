package com.example.repositories;

import com.example.models.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<AppUser, Long> {

    @Query("SELECT u FROM AppUser u WHERE u.username = :name")
    AppUser findByName(String name);
}