package step08abstract.step02;

public class SingTest {

	public static void main(String[] args) {
		Animal[] animals = new Animal[3];
		animals[0] = new Cat();
		animals[1] = new Dog();
		animals[2] = new Mouse();
//		animals[3] = new Animal();
		
		for(Animal a: animals) {
			a.sing();
		}
	}

}
