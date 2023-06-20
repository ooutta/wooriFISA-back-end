package dev.syntax;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Step01CreatingEntityManager {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");

		EntityManager manager = factory.createEntityManager();
		
		System.out.println(manager); // 매니저 생성, 영속성 컨텍스트도 생성됨
		
//		// 구현체의 타입으로 직접 사용
//		ArrayList<String> list = new ArrayList<>();
//		
//		// 인터페이스로 사용
//		List<String> list2 = new ArrayList<>();
    
	}

}
