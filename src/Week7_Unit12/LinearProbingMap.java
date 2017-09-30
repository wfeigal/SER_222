package Week7_Unit12;

import java.util.LinkedList;
import java.util.Queue;

import Week7_Unit12.ChainMap.Entry;

public class LinearProbingMap<Key,Value> implements Map{
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
    public LinearProbingMap() {
    	this(997);
    }
    
    public LinearProbingMap(int M) {
        this.N = 0;
        this.M = M;
        entries = new LinkedList[M];
        for (int i = 0; i < M; i++)
            entries[i] = new LinkedList<>();
    }
    
    private Value hash(Key k) {
    	int i;
    	Value outVal = ((k.hashCode() & 0x7fffffff) + i) % M;
    }
    
	@Override
	public void put(Object key, Object val) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Object key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object key) {
		// TODO Auto-generated method stub
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
        
        for (int i = 0; i < M; i++)
            for(Entry e : entries[i])
                    queue.add(e.key);
        
        return queue;
    }

}
