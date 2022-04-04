package structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {
	public Stack<String> stack;
	public void scenario1() {
		stack=new Stack<>();
	}
	
	public void scenario2() {
		stack=new Stack<>();
		stack.push("1");
	}
	
	public void scenario3() {
		stack=new Stack<>();
		for(int i=1;i<=10000;i++) {
			stack.push(""+i);
		}
		
	}
	
	@Test
	void testPushAndPop() {
		scenario1();
		stack.push("1");
		assertEquals("1",stack.pop());
	}

	@Test
	void testPeek() {
		scenario3();
		assertEquals("10000",stack.peek());
	}

	

	@Test
	void testSize() {
		scenario3();
		assertEquals(10000,stack.size());
	}

	@Test
	void testIsEmpty() {
		scenario1();
		assertTrue(stack.isEmpty());
		scenario3();
		assertFalse(stack.isEmpty());
	}



}
