package dev.film.view;

import dev.film.dto.SelectFilmDTO;

import java.util.List;

public class FilmView {
    public void selectFilms(List<SelectFilmDTO> films) {
        for(SelectFilmDTO film : films) {
            System.out.printf("필름 아이디는 %d, 제목은 %s, 설명은 %s, 개봉 연도는 %s입니다.\n", film.getFilmId(), film.getTitle(), film.getDescription(), film.getReleaseYear());
        }
    }

    public void saveFilm() {
        System.out.println("Film 정보를 저장했습니다.");
    }

    public void deleteFilm() {
        System.out.println("Film 정보를 삭제했습니다.");
    }
}
