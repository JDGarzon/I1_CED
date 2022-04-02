

public class Node<E> implements Comparable<Node<E>> {
		private E first;
		private Node<E> next;
		private Node<E> previous;
		
		public Node() {
			first=null;
			next=null;
			previous=null;
		}
		
		public Node(E element) {
			setFirst(element);
			next=null;
			previous=null;
		}
		
		public Node(E first,E next) {
			this.first=first;
			this.next=new Node<>(next);
			this.next.setPrevious(this);
		}
		
		public Node<E> setNext(Node<E> next) {
			return this.next=next;
		}
		
		public Node<E> setPrevious(Node<E> previous){
			return this.previous=previous;
		}
		
		public Node<E> getNext() {
			return next;
		}

		public Node<E> getPrevious() {
			return previous;
		}
		public E getFirst() {
			return first;
		}

		public void setFirst(E first) {
			this.first = first;
		}
		
		
		public String toString() {
			return first.toString();
		}

		@SuppressWarnings("unchecked")
		@Override
		public int compareTo(Node<E > o ) {
			
			return  ((Comparable<Node<E>>) first).compareTo((Node<E>) o.getFirst());
		}
		
		public boolean equals(Node<E > o) {
			return first.equals(o.getFirst());
		}
		
		
		
	}
