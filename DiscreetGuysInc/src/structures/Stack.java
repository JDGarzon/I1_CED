package structures;
public class Stack<E>{
	private LinkedList<E> stack;
	private int size;
	public Stack() {
		stack=new LinkedList<>();
		size=0;
	}
	
	public void push(E toPush) {
		stack.add(toPush);
		if(size==0) {
			stack.setLast(stack.getFirst());
		}
		size++;
		}
	
	public E peek() {
		return stack.getLast().getFirst();
	}
	
	public E pop() {
		size--;
		return stack.removeE(stack.getLast().getFirst());
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public String toString() {
		return stack.toString();
	}
	
}
