package step08abstract.step01;

public class SingTest {

	public static void main(String[] args) {
//		Animal a = new Cat();
//		Animal b = new Dog();
//		Animal c = new Mouse();
//		Animal d = new Animal();
		
		Animal[] animals = new Animal[4];
		animals[0] = new Cat();
		animals[1] = new Dog();
		animals[2] = new Mouse();
		animals[3] = new Animal();
		
		for(Animal a: animals) {
			a.sing();
		}
	}

}
