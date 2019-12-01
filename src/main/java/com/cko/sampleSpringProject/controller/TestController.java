package com.cko.sampleSpringProject.controller;

import com.cko.sampleSpringProject.dao.FilmDAO;
import com.cko.sampleSpringProject.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {


    @Autowired
    FilmDAO filmDAO;

    @GetMapping("/testT")
    public ModelAndView showTestTPage() {
        ModelAndView modelAndView = new ModelAndView();
        Film film = filmDAO.findFilmById((long) 1);
        modelAndView.addObject("filmName", film);
        modelAndView.setViewName("testT");
        return modelAndView;
    }


}
