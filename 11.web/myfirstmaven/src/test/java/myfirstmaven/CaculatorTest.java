package myfirstmaven;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CaculatorTest {

	@Test
	public void test() {
		Caculator cal = new Caculator();
		int result = cal.add(1, 2);
		assertEquals(3, result);
	}

}
