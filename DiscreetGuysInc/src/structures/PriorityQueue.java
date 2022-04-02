package structures;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriorityQueue <E extends Comparable<E>> {
	private ArrayList<E> priorityQueue;
	
	public PriorityQueue() {
		priorityQueue=new ArrayList<>();
		
	}
	
	public void push(E toPush) {
		
		if(!priorityQueue.contains(toPush)) {
			priorityQueue.add(toPush);
		}
	}
	
	public void maxHeap() {
		Collections.sort((List<E >) priorityQueue);
	}
	
	public E peek() {
		return priorityQueue.get(priorityQueue.size()-1);
	}
	
	public E pop() {
		return priorityQueue.remove(priorityQueue.size()-1);
	}
	
}
