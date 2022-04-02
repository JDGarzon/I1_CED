package structures;
public class Queue<E> {
	private LinkedList<E> queue;
	
	public Queue() {
		queue=new LinkedList<>();
	}
	public void push(E toPush) {
		queue.add(toPush);
	}
	
	public E peek() {
		return queue.getFirst().getFirst();
	}
	
	public E poll() {
		return queue.removeE(queue.getFirst().getFirst());
	}
}
