package com.cko.sampleSpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/loginPage")
    public String showLoginPage(){
        return "login";
    }

    @GetMapping("/")
    public String showMainPage() {
        return "mainPage";
    }

    @GetMapping("/game/tiktaktoe")
    public String showGamePage() {
        return "jshtml";
    }

    @GetMapping("/films")
    public String showFilmsPage() { return "filmsPage";}
    @GetMapping("/films/all")
    public String showAllFilmsPage() { return "filmsPage";}

    @GetMapping("/films/new")
    public String showCreateFilmPage() { return "newFilm";}


}
