package Week7_Unit12;

import java.util.LinkedList;
import java.util.Queue;


public class LinearProbingMap<Key,Value> implements Map<Key,Value>{
	
    private class Entry<Key,Value>{
        public Key key;
        public Value value;
        
        public Entry (Key k, Value v) {
            key = k;
            value = v;
        }
    }
    
    private int N; // number of key-value pairs
    private int M; // hash table size
    
    private Entry<Key,Value>[] entries;
    
    //CONSTRUCTORS
    public LinearProbingMap() {
    	this(997);
    }
    
    public LinearProbingMap(int M) {
        this.N = 0;
        this.M = M;
        entries = new Entry[M];
    }
    //METHODS
    private int hash(Key k, int i) {
    	return ((k.hashCode() & 0x7fffffff) + i) % M;
    }
    
	@Override
	public void put(Key key, Value val) {
        boolean added = false;
        int ind = hash(key, 0);
        int i = 1;
        
        Entry current = entries[ind];
        //CHECK FOR THE KEY IN THE COLLECTION
        while (current != null) {
        	//
        	if (current.key.hashCode() == key.hashCode()) {
        		current.value = val;
        		added = true;
        	}
        	i++;
        	ind = hash(key,i);
        	current = entries[ind];
        }
        //UPDATE LIST IF KEY DOES NOT ALREADY EXIST
        if(!added) {
             entries[ind] = new Entry(key, val);
             N++;
        }
		
	}

	@Override
	public Value get(Key key) {
		int ind = 0;
		Entry<Key,Value> result = entries[hash(key,ind)];
		
		if (result != null) {
			//CHECK FOR KEY AT HASHED INDEX
			if (result.key.hashCode() == key.hashCode())
				return result.value;
			//CHECK SUBSEQUENT INDEXES TO ACCOUNT FOR LINEAR PROBE
			while (result.key.hashCode() != key.hashCode()) {
				int temp = hash(key,ind);
				result = entries[temp];
				
				if ((result != null) && (result.key.hashCode() == key.hashCode()))
					return result.value;	
				ind++;
			}
		}
		return null;

	}

	@Override
	public void remove(Key key) {
        int ind = 0;
		
		if (contains(key)) {
            int temp = hash(key, ind);
            while (entries[temp].key.hashCode() != key.hashCode()){
                temp = hash(key, ind);
                ind++;
            }
            entries[temp] = null;
            N--;
        }
		
	}

	@Override
	public boolean contains(Key key) {
        Entry result = entries[hash(key, 0)];
        int ind = 0;
        
        if (result != null) {
        	//CHECK FOR ELEMENT AT ORIGINAL HASH VALUE
            if (result.key.hashCode() == key.hashCode()) {
                return true;
            }
            //CHECK FOR KEY AT SUBSEQUENT INDEXES TO ACCOUNT FOR LINEAR PROBE
            while (result.key.hashCode() != key.hashCode()){
                int temp = hash(key, ind);
                result = entries[temp];
                if(result != null)
                {
                    if(result.key.hashCode() == key.hashCode())
                    {
                        return true;
                    }
                }
                ind++;
            }
        }

        return false;
	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public int size() {
		return N;
	}

    @Override
    public Iterable<Key> keys() {        
        Queue<Key> queue = new LinkedList<>();
        
        for (int i = 0; i < M; i++) {
            if(entries[i] != null)
                queue.add(entries[i].key);
        }

        return queue;
    }

}
