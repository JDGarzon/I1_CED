package structures;

public class LinkedList<E> {
	private Node<E> first;
	private Node<E> last;
	private Node<E> next;
	private Node<E> previous;
	private Node<E> thisNext;
	private Node<E> localNode;
	private int localPosition;
	private int size;
	
	public LinkedList(E firstE) {
		size=1;
		this.first=new Node<E>(firstE);
		thisNext=null;
		next=null;
	}
	
	public LinkedList() {
		size=0;
		next=thisNext;
	}
	
	public E get(E toSearch) {
		reset();
		Node<E> localNode=first;
		while(!toSearch.equals(localNode.getFirst())&&localNode!=null) {
			localNode=localNode.getNext();
		}
		return localNode.getFirst();
	}
	
	
	public E removeE(E toSearch) {
		Node<E> search=new Node<>(toSearch);
		Node<E> localNode=first;
		while(!search.equals(localNode)&&localNode!=null) {
			localNode=localNode.getNext();
		}
		if(search.equals(first)) {
			first=first.getNext();
			size--;
			return search.getFirst();
		}else if(search.equals(last)){
			last=last.getPrevious();
			last.setNext(null);
			size--;
			return search.getFirst();
		}else if(search.equals(localNode)) {
			Node<E> localNext=localNode.getNext();
			Node<E> localPrev=localNode.getPrevious();
			localPrev.setNext(localNext);
			localNext.setPrevious(localPrev);
			size--;
			return localNode.getFirst();
		}
		return null;
	}
	
	public void setThisNext(E toAdd) {
		thisNext=new Node<>(toAdd);
	}
	public boolean add(E toAddE) {
		if(size==0||first.getFirst().equals(toAddE)) {
			first=new Node<E>(toAddE);
			previous=first;
			last=first;
			size++;
			return true;
		}
		if(size==1||thisNext.getFirst().equals(toAddE)) {
			setThisNext(toAddE);
			first.setNext(thisNext);
			first.getNext().setPrevious(first);
			previous=first;
			last=thisNext;
			size++;
			thisNext.setNext(null);
			thisNext.setPrevious(first);
			
			return true;
		}
		Node<E> toAdd=new Node<E>(toAddE);
		next=thisNext;
		Node<E> actual=thisNext;
		Node<E> previous=first;
		while(next!=null) {
			next=next.getNext();
			
			if(actual.equals(toAdd)) {
				actual.setFirst(toAddE);
				break;
			}
			if(next==null) {
				actual.setNext(toAdd);
				actual.getNext().setPrevious(actual);
				this.previous.setPrevious(actual);
				last=actual.getNext();
				size++;
				return true;
			}
			actual=actual.getNext();
			previous=previous.getNext();
			
		}
		
		return false;
	}
	
	public Node<E> getFirst() {
		return first;
	}
	
	@Override
	public String toString() {
		String out="{";
		Node<E> localNode=first;
		while(localNode!=null) {
			out+=localNode+",";
			localNode=localNode.getNext();
		}
		out=out.substring(0,out.length()-1);
		out+="}";
		return out;
	}
	
	public E up() {
		localNode=first;
		
		for(int i=0;i<localPosition;i++) {
			localNode=localNode.getNext();
		}
		localPosition++;
		return localNode.getFirst();
	}
	public E down() {
		
		localNode=localNode.getPrevious();
		
		localPosition--;
		return localNode.getFirst();
	}
		
	
	public void reset() {
		localNode=null;
		localPosition=0;
	}

	public int size() {
		return size;
	}

	
	public boolean isEmpty() {
		return size==0;
	}


	

	public Node<E> getPrevious() {
		return previous;
	}

	public void setPrevious(Node<E> previous) {
		this.previous = previous;
	}
	

	public Node<E> getLast() {
		return last;
	}

	public void setLast(Node<E> last) {
		this.last = last;
	}
	


	

	
	
	
}
