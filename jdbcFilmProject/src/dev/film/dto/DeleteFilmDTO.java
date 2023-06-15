package dev.film.dto;

public class DeleteFilmDTO {
    private String title;

    public DeleteFilmDTO(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
