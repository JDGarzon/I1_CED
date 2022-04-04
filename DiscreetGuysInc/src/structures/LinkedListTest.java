package structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {
	
	LinkedList<String> toTest;
	
	public void scenario1() {
		toTest=new LinkedList<>();
	}
	
	public void scenario2() {
		toTest=new LinkedList<>();
		toTest.add("1");
	}
	
	public void scenario3() {
		toTest=new LinkedList<>();
		for(int i=0;i<10000;i++) {
			toTest.add(""+(i+1));
		}
		
	}
	
	@Test
	void testLinkedListE() {
		scenario1();
		if(toTest.getFirst()!=null) {
			fail("No hay elementos");
		}
		scenario2();
		if(toTest.getFirst()!=null) {
			if(toTest.getLast()!=null) {
				assertEquals(toTest.getFirst(),toTest.getLast());
			}else fail();
		}else fail();
		scenario3();
		if(toTest.getFirst()!=null) {
			if(toTest.getLast()!=null) {
				assertFalse(toTest.getFirst().equals(toTest.getLast()));
			}else fail();
		}else fail();
	}

	@Test
	void testLinkedList() {
		scenario1();
		assertNotNull(toTest);
	}

	@Test
	void testGet() {
		scenario3();
		String test=toTest.get("1");
		
		assertEquals("1",test);
	}

	@Test
	void testRemoveE() {
		scenario2();
		toTest.removeE("1");
		try{
			toTest.get("1");
			fail();
		}catch(NullPointerException e) {
			
		}
	}


	@Test
	void testAdd() {
		scenario1();
		assertEquals(toTest.size(),0);
		toTest.add("1");
		assertEquals(toTest.size(),1);
		assertEquals(toTest.get("1"),"1");
	}

	@Test
	void testGetFirst() {
		scenario2();
		assertEquals("1",toTest.getFirst().getFirst());
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
