package com.cko.sampleSpringProject.controller;

import com.cko.sampleSpringProject.dao.FilmDAO;
import com.cko.sampleSpringProject.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/films")
public class FilmController {

    @Autowired
    FilmDAO filmDAO;
    @GetMapping("/all")
    public String showAllFilmsPage() { return "filmsPage";}

    @GetMapping("/new")
    public String showCreateFilmPage() { return "newFilm";}


    @PostMapping("/new")
    public String addNewFilm(Film film) {
        System.out.println(film.getTitle());
        return "filmsPage";
    }



}

