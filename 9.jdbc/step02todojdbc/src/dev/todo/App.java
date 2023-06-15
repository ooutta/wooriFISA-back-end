package dev.todo;

import dev.todo.controller.TodoController;
import dev.todo.model.Todo;

public class App {

	public static void main(String[] args) {
		TodoController todoController = new TodoController();
//		todoController.findAll();
		
//		todoController.findById(5);
//		todoController.insert();
		todoController.update();
		
//		new Todo.Builder(5).title("¹ä ¸Ô±â")
//		.description("¹äÀ» ¸Ô´Â´Ù").build();
	}

}
