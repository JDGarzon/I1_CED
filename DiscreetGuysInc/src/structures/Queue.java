package structures;
public class Queue<E> {
	private LinkedList<E> queue;
	private int size;
	public Queue() {
		queue=new LinkedList<>();
		size=0;
	}
	public void push(E toPush) {
		queue.add(toPush);
		size++;
	}
	
	public E peek() {
		return queue.getFirst().getFirst();
	}
	
	public E poll() {
		size--;
		return queue.removeE(queue.getFirst().getFirst());
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
}
