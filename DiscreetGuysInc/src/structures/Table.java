package structures;


import java.util.HashSet;
import java.util.Set;


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
        		Pair<K,V> keyValue=getted.up();
        		
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
        		Pair<K,V> keyValue=getted.up();
        		
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
