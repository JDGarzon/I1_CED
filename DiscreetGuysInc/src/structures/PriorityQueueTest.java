package structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PriorityQueueTest {
	PriorityQueue<Integer> toTest;
	public void scenario1() {
		toTest=new PriorityQueue<>();
	}
	public void scenario2() {
		toTest=new PriorityQueue<>();
		
		toTest.push(15);
		toTest.push(5);
		toTest.push(10);
		toTest.push(1);
		toTest.maxHeap();
		
	}
	public void scenario3() {
		toTest=new PriorityQueue<>();
		for(int i=1;i<=10000;i++) {
			toTest.push(i);
		}
		toTest.maxHeap();
	}
	

	@Test
	void testPop() {
		scenario2();
		
		assertTrue(15==toTest.pop());
		assertTrue(10==toTest.pop());
		assertTrue(5==toTest.pop());
		assertTrue(1==toTest.pop());
			
		
	}

	@Test
	void testPeek() {
		scenario2();
		assertEquals(15,toTest.peek());
	}

	@Test
	void testSize() {
		scenario3();
		assertTrue(10000==toTest.size());
	}

	@Test
	void testIsEmpty() {
		scenario1();
		assertTrue(toTest.isEmpty());
		scenario2();
		assertFalse(toTest.isEmpty());
	}

}
