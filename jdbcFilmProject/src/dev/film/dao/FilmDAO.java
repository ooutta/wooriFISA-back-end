package dev.film.dao;

import dev.film.dto.DeleteFilmDTO;
import dev.film.dto.InsertFilmDTO;
import dev.film.dto.SelectFilmDTO;
import dev.film.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public List<SelectFilmDTO> selectFilms() {
        List<SelectFilmDTO> films = new ArrayList<>();

        final String selectQuery = "SELECT film_id, title, description, release_year FROM film LIMIT 5";

        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()) {
                int id = resultSet.getInt("film_id");

                String title = resultSet.getString("title");

                String description = resultSet.getString("description");

                String releaseYear = resultSet.getString("release_year");

                films.add(new SelectFilmDTO(id, title, description, releaseYear));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 자원 반납, 해제(순서 -> 역순)
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return films;
    }

    public int insertFilm(InsertFilmDTO insertFilmDTO) {
        int result = 0;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO film (title, description, language_id) VALUES (?, ?, ?)");) {

                 statement.setString(1, insertFilmDTO.getTitle());
            statement.setString(2, insertFilmDTO.getDescription());
            statement.setInt(3, insertFilmDTO.getLanguageId());

//            statement.execute();

            result = statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    public int deleteFilm(DeleteFilmDTO deleteFilmDTO) {
        int result = 0;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM film WHERE title = (?)");) {

            statement.setString(1, deleteFilmDTO.getTitle());

            result = statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }
}
