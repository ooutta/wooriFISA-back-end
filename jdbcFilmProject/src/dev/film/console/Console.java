package dev.film.console;

import dev.film.dto.DeleteFilmDTO;
import dev.film.dto.InsertFilmDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
    public static InsertFilmDTO insert() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.printf("제목을 입력하세요 > ");
        String title = br.readLine();

        System.out.printf("설명을 입력하세요 > ");
        String description = br.readLine();

        return new InsertFilmDTO(title, description);
    }

    public static DeleteFilmDTO delete() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.printf("삭제할 제목을 입력하세요 > ");
        String title = br.readLine();

        return new DeleteFilmDTO(title);
    }
}
