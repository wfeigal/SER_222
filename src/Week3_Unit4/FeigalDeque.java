package Week3_Unit4;

/**
 * This program provides an implementation of the Deque interface
 * and demonstrates it.
 * 
 * @author Bill Feigal, Acuna
 * @version 1
 */
import java.util.NoSuchElementException;
    

public class FeigalDeque<Item> implements Deque<Item> {
	
	//VARIABLES AND DECLARATIONS
	private int count;
	private LinearNode<Item> head, tail;

	//CONSTRUCTOR
	public FeigalDeque() {
		head = null;
		tail = null;
		count = 0;
	}
	//METHODS
	
	public void enqueueFront(Item element) {
		//Create new node with element passed in
		LinearNode<Item> newEl = new LinearNode<Item>(element);
		//INSERT IN FRONT OF CURRENT HEAD
		if(head != null)
			head.prev = newEl;
		newEl.setNext(head);
		if (tail == null)
			tail = newEl;
		//REASSIGN HEAD POINTER
		this.head = newEl;

		//INCREMENT COUNT
		count++;
	}

	public void enqueueBack(Item element) {
		//Create new node with element passed in
		LinearNode<Item> newEl = new LinearNode<Item>(element);
		//INSERT IN FRONT OF CURRENT TAIL
		if (tail!= null)
			tail.setNext(newEl);
		newEl.setPrev(tail);
		if (head == null)
			head = newEl;
		//REASSIGN HEAD POINTER
		this.tail = newEl;

		//INCREMENT COUNT
		count++;
	}

	public Item dequeueFront() throws NoSuchElementException {
		//CHECK FOR EMPTY COLLECTIONS
		if (count == 0) {
			throw new NoSuchElementException();
		}
		//RETRIEVE CONTENTS OF THE HEAD NODE
		Item temp = this.head.getElement();
		//RE-SET THE HEAD POINTER
		head = head.getNext();
		head.setPrev(null);
		//DECREMENT THE COUNT
		this.count--;
		
		return temp;
	}


	public Item dequeueBack() throws NoSuchElementException {
		//CHECK FOR EMPTY COLLECTIONS
		if (count == 0) {
			throw new NoSuchElementException();
		}
		//RETRIEVE CONTENTS OF TAIL NODE
		Item temp = tail.getElement();
		//RE-SET THE TAIL POINTER
		tail = tail.getPrev();
		tail.setNext(null);
		//DECREMENT THE COUNT
		this.count--;
		
		return temp;
	}


	public Item first() throws NoSuchElementException {
		//CHECK FOR EMPTY COLLECTIONS
		if (count == 0) {
			throw new NoSuchElementException();
		}
		//RETRIEVE THE CONTENTS OF THE HEAD NODE
		Item temp = head.getElement();
		
		return temp;
	}


	public Item last() throws NoSuchElementException {
		//CHECK FOR EMPTY COLLECTIONS
		if (count == 0) {
			throw new NoSuchElementException();
		}
		//RETRIEVE THE CONTENTS OF THE HEAD NODE
		Item temp = tail.getElement();
		
		return temp;
	}


	public boolean isEmpty() {
		return (count == 0);
	}


	public int size() {
		return count;
	}
	public String toString() {
		String str = ""; 
		
		LinearNode<Item> tmp = new LinearNode<Item>();
		
		tmp = tail;
		//CONCATENATE EACH ELEMENT OF THE LIST TOGETHER
		while (tmp != null) {
			str += tmp.getElement() + " ";
			tmp = tmp.getPrev();
		}
		return str;
	}
	/**
	 * 
	 * @author Lewis and Chase, Bill Feigal
	 * 
	 * Represents a node in a linked list
	 * 
	 * @param <T>
	 */
	public class LinearNode<T>
	{
	/** reference to next node in list */
	private LinearNode<T> next;
	private LinearNode<T> prev;
	/** element stored at this node */
	private T element;
	/**
	* Creates an empty node.
	*/
	public LinearNode()
	{
	next = null;
	prev = null;
	element = null;
	}
	/**
	* Creates a node storing the specified element.
	* @param elem element to be stored
	*/
	public LinearNode (T elem)
	{
	next = null;
	prev = null;
	element = elem;
	}
	/**
	* Returns the node that follows this one.
	* @return LinearNode<T> reference to next node
	*/
	public LinearNode<T> getNext()
	{
	return next;
	}
	/**
	* Sets the node that follows this one.
	* @param node node to follow this one
	*/
	public void setNext (LinearNode<T> node)
	{
	next = node;
	}
	/**
	* Sets the node that Precedes this one.
	* @param node node to Precede this one
	*/
	public void setPrev (LinearNode<T> node)
	{
	prev = node;
	}
	/**
	* Returns the node that precedes this one.
	* @return LinearNode<T> reference to previous node
	*/
	public LinearNode<T> getPrev()
	{
	return prev;
	}

	/**
	* Returns the element stored in this node.
	* @return T element stored at this node
	*/
	public T getElement()
	{
	return element;
	}
	/**
	* Sets the element stored in this node.
	* @param elem element to be stored at this node
	*/
	public void setElement (T elem)
	{
	element = elem;
	}
	}
	
    /**
     * Program entry point for deque. 
     * @param args command line arguments
     */    
    public static void main(String[] args) {
        FeigalDeque<Integer> deque = new FeigalDeque<>();
        FeigalDeque<Integer> emptyDeque = new FeigalDeque<>();
        
        //standard queue behavior
        deque.enqueueBack(3);
        deque.enqueueBack(7);
        deque.enqueueBack(4);
        deque.dequeueFront();        
        deque.enqueueBack(9);
        deque.enqueueBack(8);
        deque.dequeueFront();
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());   

        //deque features
        System.out.println(deque.dequeueFront());        
        deque.enqueueFront(1);
        deque.enqueueFront(11);                         
        deque.enqueueFront(3);                 
        deque.enqueueFront(5);         
        System.out.println(deque.dequeueBack());
        System.out.println(deque.dequeueBack());        
        System.out.println(deque.last());                
        deque.dequeueFront();
        deque.dequeueFront();        
        System.out.println(deque.first());        
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());   
        
        //Exceptional cases
        try {
        	emptyDeque.dequeueBack();
        }
        catch (NoSuchElementException e) {
        	System.out.println("dequeBack successfully caught");
        }
        try {
        	emptyDeque.dequeueFront();
        }
        catch (NoSuchElementException e) {
        	System.out.println("dequeFront successfully caught");
        }
        try {
        	emptyDeque.first();
        }
        catch (NoSuchElementException e) {
        	System.out.println("first successfully caught");
        }
        try {
        	emptyDeque.last();
        }
        catch (NoSuchElementException e) {
        	System.out.println("last successfully caught");
        }
        System.out.println(deque.isEmpty());
        System.out.println(emptyDeque.isEmpty());
    }
} 
