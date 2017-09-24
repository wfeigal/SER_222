package Week6_Unit10;



public class FeigalBST {

	public static void main(String[] args) {
		LinkedBinarySearchTree<Integer> bst1 = new LinkedBinarySearchTree<Integer>();
		LinkedBinarySearchTree<Integer> bst2 = new LinkedBinarySearchTree<Integer>();
		LinkedBinarySearchTree<String> bst3 = new LinkedBinarySearchTree<String>("Screwby");//testing other types
		LinkedBinarySearchTree<Integer> bst4 = new LinkedBinarySearchTree<Integer>();
		LinkedBinarySearchTree<Integer> bst5 = new LinkedBinarySearchTree<Integer>();
		
		//CHECK THAT EMPTY TREES DONT CAUSE ISSUES WITH ITERATOR, OR TOSTRING
		System.out.println(bst1.toString());
		
		//FILL UP THE LEFT TREE BY ADDING ELMENTS IN DESCENDING ORDER
		bst1.addElement(4);
		bst1.addElement(3);
		bst1.addElement(2);
		bst1.addElement(1);
		bst1.addElement(0);
		
		//FILL UP THE RIGHT TREE BY ADDING ELMENTS IN DESCENDING ORDER
		bst2.addElement(0);
		bst2.addElement(1);
		bst2.addElement(2);
		bst2.addElement(3);
		bst2.addElement(4);
		
		//FILL TREE WITH LEFT AND RIGHT BRANCHES
		bst4.addElement(3);
		bst4.addElement(1);
		bst4.addElement(2);
		bst4.addElement(5);
		bst4.addElement(4);
		
		//CHECK TO SEE CONTENTS OF THE TREE WERE ADDED AND DISPLAY CORRECTLY
		System.out.println(bst1.toString());
		System.out.println(bst2.toString());
		System.out.println(bst3.toString());
		System.out.println(bst4.toString());
		
		//CHECK FOR ELEMENTS PRESENT AND NOT PRESENT
		System.out.println(bst1.find(3));
		try {
			System.out.println(bst1.find(10));
		}
		catch (ElementNotFoundException e){
			System.out.println("Element not present caught correctly");
		}
	
		//CHECK REMOVAL OF ELEMENTS SINGLY AND ALL OCCURANCES
		bst1.addElement(4);
		bst1.removeAllOccurrences(4);
		bst2.removeElement(3);
		System.out.println(bst1.toString());
		System.out.println(bst2.toString());
		
		//CHECK OTHER REMOVAL METHODS
		bst2.removeMin();
		bst1.removeMin();
		System.out.println(bst2.toString());
		System.out.println(bst1.toString());
		
		//TEST METHODS ON EMPTY COLLECTION TO SEE THAT EXCEPTION IS THROWN
		try {
			bst5.removeElement(10);
		}
		catch (ElementNotFoundException e){
			System.out.println("Empty removeElement Caught");
		}
		try {
			bst5.removeAllOccurrences(10);
		}
		catch (ElementNotFoundException e){
			System.out.println("Empty removeAllOccurrences Caught");
		}
		try {
			bst5.removeMin();
		}
		catch (EmptyCollectionException e){
			System.out.println("Empty removeMin Caught");
		}
	}
		
		
}
