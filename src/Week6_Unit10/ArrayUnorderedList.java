package Week6_Unit10;
/**
 * ArrayUnorderedList represents an array implementation of an unordered list.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T>
{
    /**
     * Creates an empty list using the default capacity.
     */
    public ArrayUnorderedList()
    {
        super();
    }

    /**
     * Creates an empty list using the specified capacity.
     *
     * @param initialCapacity the intial size of the list
     */
    public ArrayUnorderedList(int initialCapacity)
    {
        super(initialCapacity);
    }

    /**
     * Adds the specified element to the front of this list.
     * 
     * @param element the element to be added to the front of the list
     */
    @Override
    public void addToFront(T element)
    {
    	//SHIFT ALL ELEMENTS UP IN THE ARRAY
        for (int i = list.length ; i > 0; i--) {
        	list[i] = list[i-1];
        }
        //SET NEW ELEMENT AT THE FRONT OF THE LIST AND MAINTAIN COUNTERS
        list[0] = element;
        rear += 1;
        modCount += 1;
    }

    /**
     * Adds the specified element to the rear of this list.
     *
     * @param element the element to be added to the list
     */
    @Override
    public void addToRear(T element)
    {
    	//SET NEW ELEMENT AT THE END OF THE LIST AND MAINTAIN COUNTERS
        list[rear] = element;
        rear += 1;
        modCount += 1;
    }

    /**
     * Adds the specified element after the specified target element.
     * Throws an ElementNotFoundException if the target is not found.
     *
     * @param element the element to be added after the target element
     * @param target  the target that the element is to be added after
     */
    @Override
    public void addAfter(T element, T target)
    {
        if (size() == list.length)
            expandCapacity();

        int scan = 0;
		
		// find the insertion point
        while (scan < rear && !target.equals(list[scan])) 
            scan++;
      
        if (scan == rear)
            throw new ElementNotFoundException("UnorderedList");
    
        scan++;
		
		// shift elements up one
        for (int shift=rear; shift > scan; shift--)
            list[shift] = list[shift-1];

		// insert element
		list[scan] = element;
        rear++;
		modCount++;
    }
}
