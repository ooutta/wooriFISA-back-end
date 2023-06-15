package dev.film.dto;

public class InsertFilmDTO {
    private String title;
    private String description;
    private int language_id;

    public InsertFilmDTO(String title, String description) {
        this.title = title;
        this.description = description;
        this.language_id = 1;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLanguageId() {
        return language_id;
    }

    public void setLanguageId(int language_id) {
        this.language_id = language_id;
    }
}
