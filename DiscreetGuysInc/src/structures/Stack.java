package structures;
public class Stack<E>{
	private LinkedList<E> stack;
	
	public Stack() {
		stack=new LinkedList<>();
	}
	
	public void push(E toPush) {
		stack.add(toPush);
	}
	
	public E peek() {
		return stack.getLast().getFirst();
	}
	
	public E pop() {
		return stack.removeE(stack.getLast().getFirst());
	}
	
}
