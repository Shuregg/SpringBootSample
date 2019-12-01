package com.cko.sampleSpringProject.dao;
import com.cko.sampleSpringProject.model.Authority;
import com.cko.sampleSpringProject.model.Film;
import com.cko.sampleSpringProject.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmDAO extends CrudRepository<Film,Long> {
    Film findFilmById(Long id);
    Film findFilmByTitle(String title);
    Film findFilmByAge(int age);
    Film findFilmByRating(int rating);
    List<Film> findAll();
}
