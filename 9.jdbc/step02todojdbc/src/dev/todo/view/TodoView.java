package dev.todo.view;

import java.time.format.DateTimeFormatter;
import java.util.List;

import dev.todo.model.Todo;

public class TodoView {
	
	// 1. 전체 조회 결과를 포매팅
	public void findAll(List<Todo> todos) {
		for (Todo todo : todos) {
            System.out.println(String.format("%d 번째로 해야 할 일은 %s 입니다.", todo.getId(), todo.getTitle()));
            System.out.println(todo.getDueDate().format(DateTimeFormatter.ofPattern("기한은 yyyy년 MM월 dd일 까지입니다.")));
            System.out.println();
        }
	}
	
	// 2.
	public void findById(Todo todo) {
		System.out.println(String.format("%d 번이 해야 할 일은 %s 입니다.", todo.getId(), todo.getTitle()));
        System.out.println(todo.getDueDate().format(DateTimeFormatter.ofPattern("기한은 yyyy년 MM월 dd일 까지입니다.")));
        System.out.println();
	}
	
	// 3. 등록 처리 여부 결과 출력
    public void save() {
        System.out.println("정상 등록 되었습니다.");
    }

    // 4. 에러 결과 출력
    public void errorPage(Exception error) {
        System.out.println("문제가 발생하였습니다." + error.getMessage());
    }
	
    public void update(int affectedRows) {
        System.out.println(affectedRows + "개의 행(row)이 수정되었습니다. ");
    }

    public void delete(int affectedRows) {
        System.out.println(affectedRows + "개의 행(row)이 삭제되었습니다. ");
    }
}
