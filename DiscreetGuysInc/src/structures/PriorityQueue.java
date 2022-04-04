package structures;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriorityQueue <E extends Comparable<E>> {
	private ArrayList<E> priorityQueue;
	private int size;
	
	public PriorityQueue() {
		priorityQueue=new ArrayList<>();
		size=0;
	}
	
	public void push(E toPush) {
		
		if(!priorityQueue.contains(toPush)) {
			priorityQueue.add(toPush);
		}
		size++;
	}
	
	public void maxHeap() {
		Collections.sort((List<E >) priorityQueue);
	}
	
	public E peek() {
		return priorityQueue.get(priorityQueue.size()-1);
	}
	
	public E pop() {
		size--;
		return priorityQueue.remove(priorityQueue.size()-1);
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
}
