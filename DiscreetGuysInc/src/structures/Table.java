

import java.util.HashSet;
import java.util.Set;
import java.util.Collection;
import java.util.Iterator;


public class Table<K,V>  {
	
	private Set<K> keys;
    private LinkedList<Pair<K,V>>[] table;
    @SuppressWarnings("unchecked")
    public Table() {
        table=new LinkedList[618033];
        keys=new HashSet<>();
    }
	public Set<K> getKeys() {
		return keys;
	}
	
	public V get(K key) {
        int index=hash(key);
        if(contains(key)) {
        	LinkedList<Pair<K,V>> getted=table[index];
        	getted.reset();
        	int i=0;
    
        	while(getted.size()>i) {
        		i++;
        		Pair<K,V> keyValue=getted.run();
        		
            	if(keyValue.getKey().equals(key)) {
            		return keyValue.getValue();
            	}
        	}
        	
        }
        return  null;
    }
	public Pair<K,V> getPair(K key) {
        int index=hash(key);
        if(contains(key)) {
        	LinkedList<Pair<K,V>> getted=table[index];
        	getted.reset();
        	int i=0;
    
        	while(getted.size()>i) {
        		i++;
        		Pair<K,V> keyValue=getted.run();
        		
            	if(keyValue.getKey().equals(key)) {
            		return keyValue;
            	}
        	}
        	
        }
        return  null;
    }
	public void put(K key,V value) { 
		int index=hash(key);
	     if(table[index]!=null) {
	    	Pair<K,V> o=getPair(key);
	    	if(o!=null) {
	    		o.setValue(value);
	    	}else
	    	table[index].add(new Pair<K,V>(key,value));
	    	keys.add(key);
	     }else {table[index]=new LinkedList<Pair<K,V>>(new Pair<K,V>(key,value));
	     	keys.add(key);
	     }
	}
	
	public boolean contains(K key) {
		return table[hash(key)]!=null;
	}
	
	public int hash(K key) {
         return  (key.hashCode()&0x7fffffff)%table.length;
    }
	
	public Set<K> keySet(){
		return keys;
	}
	

public class LinkedList<E> implements Set<E> {
	private Node<E> first;
	private Node<E> next;
	private Node<E> thisNext;
	private int size;
	
	public LinkedList(E firstE) {
		size=1;
		this.first=new Node<E>(firstE);
		thisNext=null;
		next=thisNext;
	}
	
	public LinkedList() {
		size=0;
		next=thisNext;
	}
	
	public E get(E toSearch) {
		Node<E> search=new Node<>(toSearch);
		next=thisNext;
		while(!search.equals(next)&&next!=null) {
			next=next.getNext();
		}
		return next.getFirst();
	}
	
	
	public boolean removeE(E toSearch) {
		Node<E> search=new Node<>(toSearch);
		next=thisNext;
		while(!search.equals(next)&&next!=null) {
			next=next.getNext();
		}
		if(search.equals(next)) {
			Node<E> lastNode=next.getPrevious();
			while(next!=null) {
				lastNode.setNext(next.getNext());
				next=next.getNext();
			}
		}else return false;
		return true;
	}
	public void setThisNext(E toAdd) {
		thisNext=new Node<>(toAdd);
	}
	public boolean add(E toAddE) {
		if(size==0||first.getFirst().equals(toAddE)) {
			first=new Node<E>(toAddE);
			size++;
			return true;
		}
		if(size==1||thisNext.getFirst().equals(toAddE)) {
			setThisNext(toAddE);
			first.setNext(thisNext);
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
				actual.setPrevious(previous);
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
		out+=first+",";
		next=thisNext;
		while(next!=null) {
			out+=next+",";
			next=next.getNext();
		}
		out=out.substring(0,out.length()-1);
		out+="}";
		return out;
	}
	
	public E run() {
		if(next==null) {
			next=first;
		}else {
			next.getNext();
		}
		return next.getFirst();
	}
	
	public void reset() {
		next=null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		
		return size==0;
	}

	@Override
	public boolean contains(Object paramObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] paramArrayOfT) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean containsAll(Collection<?> paramCollection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> paramCollection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> paramCollection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> paramCollection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remove(Object paramObject) {
		// TODO Auto-generated method stub
		return false;
	}
	

	@SuppressWarnings("hiding")
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

	
	
	
}

	@SuppressWarnings("hiding")
	public class Pair<K,V>{
		K key;
		V value;
		public Pair(K key,V value) {
			this.key=key;
			this.value=value;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
		
		public void setValue(V value) {
			this.value=value;
		}

		
	}
	
	
}
