package dev.film.controller;

import dev.film.console.Console;
import dev.film.dao.FilmDAO;
import dev.film.dto.DeleteFilmDTO;
import dev.film.dto.InsertFilmDTO;
import dev.film.dto.SelectFilmDTO;
import dev.film.view.FilmView;

import java.io.IOException;
import java.util.List;

public class FilmController {
    private FilmDAO filmDAO;
    private FilmView filmView;

    public FilmController() {
        filmDAO = new FilmDAO();
        filmView = new FilmView();
    }

    public void selectFilms() {
        List<SelectFilmDTO> films = filmDAO.selectFilms();
        filmView.selectFilms(films);
    }

    public void insertFilm() throws IOException {
        InsertFilmDTO insertFilmDTO = Console.insert();
        int result = filmDAO.insertFilm(insertFilmDTO);
        if(result == 1) {
            filmView.saveFilm();
        }
    }

    public void deleteFilm() throws IOException {
        DeleteFilmDTO deletFilmDTO = Console.delete();
        int result = filmDAO.deleteFilm(deletFilmDTO);
        if(result == 1) {
            filmView.deleteFilm();
        }
    }
}
