package structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTest {
	Queue<String> toTest;
	public void scenario1() {
		toTest=new Queue<>();
	}
	public void scenario2() {
		toTest=new Queue<>();
		toTest.push("1");
		
	}
	public void scenario3() {
		toTest=new Queue<>();
		for(int i=1;i<=10000;i++) {
			toTest.push(""+i);
		}
	}
	
	@Test
	void testPeek() {
		scenario3();
		assertEquals("1",toTest.peek());
	}

	@Test
	void testPoll() {
		scenario2();
		assertEquals("1",toTest.poll());
	}

	@Test
	void testSize() {
		scenario3();
		assertEquals(10000,toTest.size());
	}

	@Test
	void testIsEmpty() {
		scenario1();
		assertTrue(toTest.isEmpty());
		scenario2();
		assertFalse(toTest.isEmpty());
	}

}
