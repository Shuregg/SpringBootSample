package com.cko.sampleSpringProject.dao;
import com.cko.sampleSpringProject.model.Authority;
import com.cko.sampleSpringProject.model.Film;
import com.cko.sampleSpringProject.model.User;
import org.springframework.data.repository.CrudRepository;

public interface FilmDAO extends CrudRepository<Film,Long> {

}
