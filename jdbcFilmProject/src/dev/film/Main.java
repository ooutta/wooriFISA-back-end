package dev.film;

import dev.film.controller.FilmController;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		FilmController filmController = new FilmController();
//		filmController.selectFilms();

		filmController.insertFilm();

		filmController.deleteFilm();

	}

}
