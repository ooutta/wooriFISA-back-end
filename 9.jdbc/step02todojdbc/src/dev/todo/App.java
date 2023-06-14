package dev.todo;

import dev.todo.controller.TodoController;
import dev.todo.model.Todo;

public class App {

	public static void main(String[] args) {
		TodoController todoController = new TodoController();
//		todoController.findAll();

//		System.out.println(todoController.findById(1));
		
		new Todo.Builder(5).title("¹ä ¸Ô±â")
		.description("¹äÀ» ¸Ô´Â´Ù").build();
	}

}
