package dev.film.dto;

// select, insert, delete 기능마다 사용할 DB 컬럼들이 다르다.
// 사용자한테 받는 객체에 대한 정의가 필요했는데 찾아보니까 DTO가 필요하다고 생각했다.
// DTO(Data Transfer Object)
// View, Controller, Service, DAO 등 계층 간 데이터 전송을 위해 사용되는 객체
// 로직을 가지지 않는 순수한 데이터 객체로 getter, setter만 가진다.

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
