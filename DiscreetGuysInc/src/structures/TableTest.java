package structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableTest {
	Table<String,String> toTest;
	
	public void scenario1() {
		toTest=new Table<>();
		toTest.put("key","value");
	}
	public void scenario2() {
		toTest=new Table<>();
		for(int i=0;i<1000000;i++) {
			toTest.put(""+i, ""+i);
		}
	}
	
	@Test
	void testGet() {
		scenario2();
		for(int i=0;i<1000000;i++) {
			assertEquals(toTest.get(""+i),""+i);
		}
	}


	@Test
	void testContains() {
		scenario1();
		assertTrue(toTest.contains("key"));
		assertFalse(toTest.contains("key2"));
	}

	


}
