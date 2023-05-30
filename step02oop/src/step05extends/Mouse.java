package step05extends;

public class Mouse extends Animal {
	
	private String address;

	public Mouse() {
		super();
		System.out.println("Mouse() called");
	}
	
	public Mouse(int age) {
		super(age);
		System.out.println("Mouse(age) called");
	}

	public Mouse(int age, String color) {
		super(age, color);
		System.out.println("Mouse(age, color) called");
	}

	public Mouse(int age, String color, String address) {
		super(age, color);
		this.address = address;
		System.out.println("Mouse(age, color, address) called");
	}
	
	@Override
	public void sing() {
		System.out.println("찍찍!");
	}

	@Override
	public String toString() {
		return super.toString() + " Mouse [address=" + address + "]";
	}
	
	
	
}

