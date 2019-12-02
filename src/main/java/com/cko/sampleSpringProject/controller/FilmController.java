package com.cko.sampleSpringProject.controller;

import com.cko.sampleSpringProject.dao.FilmDAO;
import com.cko.sampleSpringProject.model.Film;
import com.cko.sampleSpringProject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
    public RedirectView addNewFilm(Film film) {
        System.out.println(film.getTitle());

        return new RedirectView("/films/all");
    }

    @GetMapping("/editFilm")
    public ModelAndView showEditFilmPage(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Film film = filmDAO.findFilmById(id);
        modelAndView.addObject("film", film);
        modelAndView.setViewName("editFilm");
        return modelAndView;
    }

    @PostMapping("/editProduct")
    public RedirectView editProduct(Film film) {
        filmDAO.save(film);
        return new RedirectView("/films/all");
    }

    @GetMapping("/deleteFilm")
    public RedirectView deleteFilm(@RequestParam Long id) {
        RedirectView redirectView = new RedirectView();
        filmDAO.deleteById(id);
        return new RedirectView("/films/all");

    }

}

