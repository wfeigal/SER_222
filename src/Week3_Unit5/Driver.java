package Week3_Unit5;

/**
 * DoubleOrderedList testing area.
 * 
 * @author (your name), Acuna
 * @version (version)
 */
public class Driver {
    public static void main(String [] args) {
        DoubleOrderedList<Integer> list = new DoubleOrderedList<>();
        DoubleOrderedList<Integer> emptyList = new DoubleOrderedList<>();
        
        //TEST FOR EXCEPTIONAL CASES ON AN EMPTY LIST
        try {
        	emptyList.first();
        }
        catch (EmptyCollectionException e){
        	System.out.println("first() exception caught");
        }
        try {
        	emptyList.last();
        }
        catch (EmptyCollectionException e){
        	System.out.println("last() exception caught");
        }
        try {
        	emptyList.removeFirst();
        }
        catch (EmptyCollectionException e){
        	System.out.println("removeFirst() exception caught");
        }
        try {
        	emptyList.removeLast();
        }
        catch (EmptyCollectionException e){
        	System.out.println("removeLast() exception caught");
        }
        try {
        	emptyList.remove(2);
        }
        catch (EmptyCollectionException e){
        	System.out.println("remove(T elem) exception caught");
        }
        try {
        	emptyList.contains(2);
        }
        catch (EmptyCollectionException e){
        	System.out.println("contains() exception caught");
        }
        //TEST FOR EXPECTED RESULTS ON EMPTY LIST
        System.out.println(emptyList.isEmpty());//true
        System.out.println(emptyList.size());// 0
        System.out.println(emptyList.toString());// ""
        
        //FILL UP THE LIST WITH SOME DATA
        list.add(23);
        list.add(24);	
        list.add(16);
        list.add(3);	
        list.add(7);
        list.add(17);	
        list.add(9);	
        list.add(13);	
        list.add(14);	
        list.add(1);

        //TEST FOR EXPECTED RESULTS
        System.out.println(list.isEmpty());//false
        System.out.println(list.size());// 10
        System.out.println(list.toString()); // 1 3 7 9 13 14 16 17 23 24 
        System.out.println(list.first()); // 1
        System.out.println(list.last()); // 24
        System.out.println(list.contains(99)); // false
        System.out.println(list.contains(3)); // true
        
        list.remove(3);
        System.out.println(list.toString()); // 1 7 9 13 14 16 17 23 24
        list.removeFirst();
        System.out.println(list.toString()); // 7 9 13 14 16 17 23 24
        list.removeLast();
        System.out.println(list.toString()); // 7 9 13 14 16 17 23
        
        //TEST FOR EXCEPTIONAL CASES
        try {
        	list.remove(99);
        }
        catch (ElementNotFoundException e){
        	System.out.println("remove(element not in list) exception caught");
        }
        try {
	        for (int i = 0; i < 100 ; i++) {
	        	list.removeFirst();
	        }
        }
        catch (EmptyCollectionException e){
        	System.out.println("removing all down to empty list exception caught");
        }
        
        //FINAL INSTANCES TO COMPLETE CODE COVERAGE TESTING
        list.add(32);
        list.remove(32);
        System.out.println(list.isEmpty()); // true
        
        DoubleOrderedList<Object> bearList = new DoubleOrderedList<>();

        Object b2 = new Object();

        try {
            bearList.add(b2);
        }
        catch (NonComparableElementException e){
        	System.out.println("Non Comparable Exception caught");
        }
    }
    

}

