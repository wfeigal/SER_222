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
        String[] c = {"B", "O", "R", "A", "T", "A", "L", "L", "R", "I", "T"};
        quicksortmid(c);
        assert isSorted(c); //requires assertions enabled.
        show(c);
        
        //Q3
        String[] b = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        //Sorting.mergeSort(b);
        mergesort(b);
        assert isSorted(b);
        show(b);
        
        //Q4
        String[] e = {"S"};
        mergesort(e);
        assert isSorted(e);
        show(e);
        
        //Q3
        String[] f = {"S"};
        quicksortmid(f);
        assert isSorted(f);
        show(f);
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

   
	public static void mergesort(Comparable[] a) {
   	
    	//HANDLE BASE CASE OF SINGLE ELEMENT 
    	if (a.length < 2)
    		return;
    	
		//SET MID VALUE, AND END VALUE
    	int en = a.length-1;
    	int mid = en / 2;
		
		//CREATE NEW PARTITION ARRAYS
		Comparable[] left = new Comparable[mid];
		Comparable[] right = new Comparable[en-mid+1];

    	//HANLDES ARRAYS OF JUST TWO ELEMENTS
    	if (a.length == 2) {
    		//GENERATE THE LEFT SIDE DECOMP FROM THE VALUE IN THE [0] INDEX
			left = new Comparable[1];
			left[0] = a[0];
			
			//GENERATE THE RIGHT SIDE DECOMP FROM THE VALUE IN THE [1] INDEX
			right = new Comparable[1];
			right[0] = a[1];
    	}
    	
    	//HANDLE ARRAYS LARGER THAN TWO ELEMENTS
    	if (a.length > 2)
		{	
			//GENERATE LEFT SIDE DECOMP
			for (int i = 0; i < mid; i++)
				left[i] = a[i];
			
			//GENERATE RIGHT SIDE DECOMP
			for (int i = mid; i <= en; i++)
				right[i-mid] = a[i];
		}
    	mergesort(left);
    	mergesort(right);
    	merge(left,right, a);

    }


	public static Comparable[] merge(Comparable[] a, Comparable[] b, Comparable[] data) {
		
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
				data[index] = a[stA];
				stA++;
			}
			else
			{
				data[index] = b[stB];
				stB++;
			}
			index++;
		}
		
		//  Copy remaining elements from first subarray, if any
		while (stA <= enA)
		{
			data[index] = a[stA];
			stA++;
			index++;
		}
		
		//  Copy remaining elements from second subarray, if any
		while (stB <= enB)
		{
			data[index] = b[stB];
			stB++;
			index++;
		}
		
		//RETURN NEW MERGED ARRAY	
		
		return data;
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
