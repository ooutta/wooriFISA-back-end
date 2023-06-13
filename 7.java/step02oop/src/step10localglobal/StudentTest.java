package step10localglobal;

public class StudentTest {

	public static void main(String[] args) {
		Student yoon = new Student();
		yoon.name = "윤영인";
		Student.centerName = "우리FISA";
		
		Student lee = new Student();
		lee.name = "이준희";
		System.out.println(lee.centerName);
	}

}
