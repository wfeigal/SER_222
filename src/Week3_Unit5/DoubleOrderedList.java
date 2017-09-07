package Week3_Unit5;

public class DoubleOrderedList<T> extends DoubleList<T> implements OrderedListADT<T>{

	@Override
	public void add(T element) throws NonComparableElementException {
        if (!(element instanceof Comparable))
            throw new NonComparableElementException("LinkedOrderedList");
		
		Comparable<T> comparableElement = (Comparable<T>) element;

        DoubleNode<T> current = head;
		DoubleNode<T> previous = null;
        DoubleNode<T> newNode  = new DoubleNode<T>(element);
      
        if (isEmpty())  // list is empty
        {
            head = newNode;
        }
		else if (comparableElement.compareTo(head.getElement()) <= 0)  
			// element goes in front
		{
            newNode.setNext(head);
            head = newNode;
		}
        else  // element goes in the middle
        {
            while ((current != null) && (comparableElement.compareTo(current.getElement()) > 0))
			{
				previous = current;
                current = current.getNext();
			}
         
            newNode.setNext(current);
            previous.setNext(newNode);
        }
      
        count++;
		
	}



}
