package com.cko.sampleSpringProject.controller;

import com.cko.sampleSpringProject.dao.FilmDAO;
import com.cko.sampleSpringProject.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/films")
public class FilmController {

    @Autowired
    FilmDAO filmDAO;
    @GetMapping("/all")
    public ModelAndView showAllFilmsPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("filmsPage");
        List<Film> filmsList = filmDAO.findAll();
        modelAndView.addObject("films", filmsList);

        return modelAndView;
    }

    @GetMapping("/new")
    public String showCreateFilmPage() { return "newFilm";}

    @PostMapping("/new")
    public String addNewFilm(Film film) {
        System.out.println(film.getTitle());
        return "filmsPage";
    }

    @GetMapping("/editFilm")
    public ModelAndView showEditFilmPage(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Film film = filmDAO.findFilmById(id);
        modelAndView.addObject("film", film);
        modelAndView.setViewName("editFilm");
        return modelAndView;
    }

    @PostMapping("/editFilm")
    public String editFilm(Film film) {
        filmDAO.save(film);
        return  "filmsPage";
    }


}

