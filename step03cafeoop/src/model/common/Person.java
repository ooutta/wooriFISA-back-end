package model.common;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Setter
@Getter
@RequiredArgsConstructor
//@NoArgsConstructor
public class Person {
	private String name;
	private int age;
	private Gender gender; // 'Person' has A 'Gender'
	
	public void getIn(Person person) {
        System.out.println(person + "가 매장으로 들어왔다.");
    }

    public void getOut(Person person) {
        System.out.println(String.format("%s가 매장에서 나갔다.", person.getName()));
    }
}
