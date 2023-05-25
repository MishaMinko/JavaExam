package com.example.repositories;

import com.example.models.Theme;
import org.springframework.data.repository.CrudRepository;

public interface IThemeRepository extends CrudRepository<Theme, Long> {

}
