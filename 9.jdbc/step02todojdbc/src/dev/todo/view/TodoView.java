package dev.todo.view;

import java.time.format.DateTimeFormatter;
import java.util.List;

import dev.todo.model.Todo;

public class TodoView {
	
	// 1. ��ü ��ȸ ����� ������
	public void findAll(List<Todo> todos) {
		for (Todo todo : todos) {
            System.out.println(String.format("%d ��°�� �ؾ� �� ���� %s �Դϴ�.", todo.getId(), todo.getTitle()));
            System.out.println(todo.getDueDate().format(DateTimeFormatter.ofPattern("������ yyyy�� MM�� dd�� �����Դϴ�.")));
            System.out.println();
        }
	}
	
	// 2.
	public void findById(Todo todo) {
		System.out.println(String.format("%d ���� �ؾ� �� ���� %s �Դϴ�.", todo.getId(), todo.getTitle()));
        System.out.println(todo.getDueDate().format(DateTimeFormatter.ofPattern("������ yyyy�� MM�� dd�� �����Դϴ�.")));
        System.out.println();
	}
	
	// 3. ��� ó�� ���� ��� ���
    public void save() {
        System.out.println("���� ��� �Ǿ����ϴ�.");
    }

    // 4. ���� ��� ���
    public void errorPage(Exception error) {
        System.out.println("������ �߻��Ͽ����ϴ�." + error.getMessage());
    }
	
    public void update(int affectedRows) {
        System.out.println(affectedRows + "���� ��(row)�� �����Ǿ����ϴ�. ");
    }

    public void delete(int affectedRows) {
        System.out.println(affectedRows + "���� ��(row)�� �����Ǿ����ϴ�. ");
    }
}
