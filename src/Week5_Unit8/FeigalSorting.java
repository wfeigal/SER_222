package Week5_Unit8;

import java.util.Arrays;

/**
 * Implements various sorting algorithms.
 * 
 * @author (your name), Acuna, Sedgewick
 * @verison (version)
 */

public class FeigalSorting {
     
    /**
     * Entry point for sample output.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Q1
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        quicksortmid(a);
        assert isSorted(a); //requires assertions enabled.
        show(a);
        
        //Q2
        String[] b = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        Sorting.mergeSort(b);
        mergesort(b);
        assert isSorted(b);
        show(b);
    }
    
    public static<T extends Comparable<T>> void quicksortmid(Comparable[] a) {
    	//VARIABLES AND DECLARATIONS
    	int st = 0;
    	int en = a.length-1;
    	int mid = (st+en)/2;
    	//GET VALUES TO USE FOR COMPARISONS
    	T start = (T) a[st];
    	T middle =(T) a[mid];
    	T end = (T) a[en];
    	T tmp = null;
    	
    	//CHECK TO SEE IF END ELEMENTS ARE IN RELATIVE ORDER
    	if (start.compareTo(end) > 0) {
    	    tmp = start;
    		start = end;
    		end = tmp;
    	} 
    	
    	//CHECK TO SEE THAT THE MIDDLE ELEMENT IS IN THE CORRECT RELATIVE ORDER
    	if (start.compareTo(middle) > 0) {
    	    tmp = start;
    		start = middle;
    		middle = tmp;
    	}
    	if (middle.compareTo(end) > 0) {
       		tmp = middle;
    		middle = end;
    		end = tmp;	
    	}
    	
    	//PLACE THE ELEMENTS BACK INTO THE ORIGINAL COLLECTION IN THE CORRECT ORDER
		a[st] = start;
		a[mid] = middle;
		a[en] = end;
		
    	//CALL THE ORIGINAL QUICKSORT ALGORITHM TO PROCESS THE COLLECTION
    	Sorting.quickSort(a);

    }
    @SuppressWarnings("rawtypes")
	public static Comparable[] mergesort(Comparable[] a) {
		//VARIABLES AND DECLARATIONS
    	int st = 0;
    	int en = a.length-1;
    	    
    	//HANDLE ARRAYS LARGER THAN TWO ELEMENTS
    	if (a.length > 2)
		{
    		//SET MID VALUE
			int mid = (st + en) / 2;
			
			//GENERATE LEFT SIDE DECOMP
			Comparable[] left = Arrays.copyOfRange(a,st,mid);
			mergesort(left);
			
			//GENERATE RIGHT SIDE DECOMP
			Comparable[] right = Arrays.copyOfRange(a,mid+1,en);
			mergesort(right);

			//MERGE THE LEFT AND RIGHT SIDES
			merge(left, right);
		}
    	//HANLDES ARRAYS OF JUST TWO ELEMENTS
    	if (a.length == 2) {
    		//GENERATE THE LEFT SIDE DECOMP FROM THE VALUE IN THE [0] INDEX
			Comparable[] left = new Comparable[1];
			left[0] = a[0];
			mergesort(left);
			
			//GENERATE THE RIGHT SIDE DECOMP FROM THE VALUE IN THE [1] INDEX
			Comparable[] right = new Comparable[1];
			right[0] = a[1];
			mergesort(right);
			
			//MERGE THE TWO VALUES BACK TOGETHER
			merge(left, right);
    	}
    	return a;
    }
    @SuppressWarnings("rawtypes")
	public static Comparable[] merge(Comparable[] a, Comparable[] b) {
		
    	Comparable[] temp = new Comparable[a.length + b.length];
		
    	//INITIALIZE INDEX VARIABLES
    	int stA = 0;
    	int enA = a.length-1;
    	int stB = 0;
    	int enB = b.length-1;
		int index = stA;
		
		//  Copy smaller item from each subarray into temp until one
		//  of the subarrays is exhausted
		while (stA <= enA && stB <= enB)
		{
			if (a[stA].compareTo(b[stB]) < 0)
			{
				temp[index] = a[stA];
				stA++;
			}
			else
			{
				temp[index] = b[stB];
				stB++;
			}
			index++;
		}
		
		//  Copy remaining elements from first subarray, if any
		while (stA <= enA)
		{
			temp[index] = a[stA];
			stA++;
			index++;
		}
		
		//  Copy remaining elements from second subarray, if any
		while (stB <= enB)
		{
			temp[index] = b[stB];
			stB++;
			index++;
		}
		
		//RETURN NEW MERGED ARRAY
		return temp;
    }

    
    /**
     * Displays contents of array, space separated.
     * @author Sedgewick
     * @param a Array to display.
     */
    private static void show(Comparable[] a) {
        for (Comparable a1 : a)
            System.out.print(a1 + " ");

        System.out.println();
    }
    
    /**
     * Checks if array is in sorted order.
     * @author Sedgewick
     * @param a Array to be checked.
     * @return Returns true if array is sorted.
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1]))
                return false;
        
        return true;
    }
    
    //See previous method.
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
