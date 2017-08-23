package Week1;

public class test {

	public static void main( String args[])  {
		int n = 20;
		int count = 0;
		int i=0, j=0;
		do {
		    do {
		          System.out.println("...looping..." + count);
		          count += 1;//growth should be measured in calls to println. 
		          j=j+5;
		     } while (j < n);
		     i++;
		     j = 0;
		} while (i < n);
	}
	
	
}
