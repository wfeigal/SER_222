package Week7_Unit12;

import java.util.LinkedList;
import java.util.Queue;


public class TwoProbeChainMap<Key,Value> implements Map<Key,Value>{
    
	private class Entry {
        public Key key;
        public Value value;
        public Entry (Key k, Value v) {
            key = k;
            value = v;
        }
    }
    
    private int N; // number of key-value pairs
    private int M; // hash table size
    
    private LinkedList<Entry>[] entries;
    
    //CONSTRUCTORS
    public TwoProbeChainMap() {
    	this(997);
    }
    
    public TwoProbeChainMap(int M) {
        this.N = 0;
        this.M = M;
        entries = new LinkedList[M];
        for (int i = 0; i < M; i++)
            entries[i] = new LinkedList<>();
    }
    
    private int hash(Key key) {
    	return (key.hashCode() & 0x7fffffff) % M;
    }
    
    private int hash2(Key key) {
    	return (((key.hashCode() & 0x7fffffff) % M) * 31) % M;
    }
    
	@Override
	public void put(Key key, Value val) {
		//VARIABLES AND DECLARATIONS
		boolean added = false;
        int h1 = hash(key);
        int h2 = hash2(key);
        //CHECK FIRST HASH 
        for(Entry entry : entries[h1])
            if(key.hashCode() == entry.key.hashCode()) {
                entry.value = val;
                added = true;
            }
        //CHECK SECOND HASH
        for(Entry entry : entries[h2])
            if(key.hashCode() == entry.key.hashCode()) {
                entry.value = val;
                added = true;
            }
        
        if(!added) {
        	int ind = 0;
        	//CHECK FOR SMALLEST LIST
        	if (entries[h1].size() <= entries[h2].size())
        		ind = h1;
        	if (entries[h2].size() <= entries[h1].size())
    			ind = h2;
        	//ADD VALUES INTO SMALLER OF LISTS
            entries[ind].add(new Entry(key, val));
            N++;
        }
		
	}

	@Override
	public Value get(Key key) {
        //VARIABLES AND DECLARATIONS
		int h1 = hash(key);
        int h2 = hash2(key);
		//CHECK FIRST HASH
        for(Entry entry : entries[h1])
            if(key.hashCode() == entry.key.hashCode())
                return entry.value;
        //CHECK SECOND HASH
        for(Entry entry : entries[h2])
            if(key.hashCode() == entry.key.hashCode())
                return entry.value;
        //RETURN NULL IF NOT FOUND    
        return null;
	}

	@Override
    public int size() {
        return N;
    }
    
    @Override
    public boolean isEmpty() {
        return N == 0;
    }
    
    
    @Override
    public void remove(Key key) {
        //VARIABLES AND DECLARATIONS 
    	boolean found = false;
    	int h1 = hash(key);
        int h2 = hash2(key);
    	int ind = 0;
        
    	if(contains(key)) {
            Entry target = null;
            //CHECK FIRST HASH
            for(Entry e : entries[h1])
                if(e.key == key) {
                	 target = e;
                	 ind = h1;
                	 found = true;
                }
            if (!found) {
            	//CHECK SECOND HASH 
                for(Entry e : entries[h2])
                    if(e.key == key) {
                    	 target = e;
                    	 ind = h2;
                    }
            }
            //REMOVE VALUE FROM LOCATION FOUND
            entries[ind].remove(target);
            N--;
        }
    }
    
    @Override
    public Iterable<Key> keys() {        
        Queue<Key> queue = new LinkedList<>();
        
        for (int i = 0; i < M; i++)
            for(Entry e : entries[i])
                    queue.add(e.key);
        
        return queue;
    }

	@Override
	public boolean contains(Key key) {
        //VARIABLES AND DECLARATIONS
		boolean contains = false;
		int h1 = hash(key);
        int h2 = hash2(key);
        
		//CHECK FIRST HASH
        for(Entry entry : entries[h1])
            if(key.hashCode() == entry.key.hashCode())
                contains = true;
        
        //CHECK SECOND HASH
        for(Entry entry : entries[h2])
            if(key.hashCode() == entry.key.hashCode())
                contains = true;
    
        return contains;
	}
}
