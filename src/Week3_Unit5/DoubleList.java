package Week3_Unit5;

public class DoubleList<T> implements ListADT<T>{
	protected int count;
	protected DoubleNode<T> head;
	
	DoubleList(){
		this.count = 0;
		this.head = null;
	}
	
	@Override
	public T removeFirst() throws EmptyCollectionException {
		if (isEmpty()) {
			throw new EmptyCollectionException("DoubleList");
		}
		T tmp = this.head.getElement();
		this.head = head.getNext();
		count --;
		return tmp;
	}


	@Override
	public T removeLast() throws EmptyCollectionException {
		
		if (isEmpty()) {
			throw new EmptyCollectionException("DoubleList");
		}
		
       DoubleNode<T> previous = null;
       DoubleNode<T> current = head;

       while (current.getNext() != null)
       {
          previous = current; 
          current = current.getNext();
       }
       
       previous.setNext(null);
       
       count --;
       
       return current.getElement();
	}

	@Override
	public T remove(Object element) throws EmptyCollectionException, ElementNotFoundException{
		if (isEmpty()) {
			throw new EmptyCollectionException("DoubleList");
		}
		
	      boolean found = false;
	      DoubleNode<T> previous = null;
	      DoubleNode<T> current = head;
	      
	      while (current != null && !found)
	         if (element.equals (current.getElement()))
	            found = true;
	         else {
	            previous = current;
	            current = current.getNext();
	         }
	            
	      if (!found)
	         throw new ElementNotFoundException ("DoubleList");
	      
	      if (size() == 1)
	         head =  null;
	      else
	         previous.setNext(current.getNext());
	      
	      count--;
	      return current.getElement();
	}

	@Override
	public T first() throws EmptyCollectionException{
		if (isEmpty()) {
			throw new EmptyCollectionException("DoubleList");
		}
		
		return head.getElement();
	}

	@Override
	public T last() throws EmptyCollectionException{
		
		if (isEmpty()) {
			throw new EmptyCollectionException("DoubleList");
		}
		
		DoubleNode<T> tmp = this.head;
		
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
		}
		
		return tmp.getElement();
	}

	@Override
	public boolean contains(Object target) {
		if (isEmpty()) {
			throw new EmptyCollectionException("DoubleList");
		}
		
		DoubleNode<T> tmp = this.head;

		while (tmp.getNext() != null) {
			if (tmp.getElement() == target)
				return true;
			tmp = tmp.getNext();
		}
		
		return false;
	}

	@Override
	public boolean isEmpty() {
		return (count == 0);
	}

	@Override
	public int size() {
		return this.count;
	}
	
	@Override
	public String toString() {
		String result = "";
		DoubleNode<T> tmp = this.head;
		
		for (int i = 0 ; i < this.count ; i++) {
			result += tmp.getElement() + " ";
			tmp = tmp.getNext();
		}
		return result;
	}

}
