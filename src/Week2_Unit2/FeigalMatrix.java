package Week2_Unit2;


public class FeigalMatrix implements Matrix{

	//VARIABLES AND DECLARATIONS

	private final int[][] matrix;

	
	//CONSTRUCTOR
    public FeigalMatrix(int[][] matrix) {
    	int col = matrix.length;
    	int row;
    	try {
    		row = matrix[0].length;
    	}
    	catch (ArrayIndexOutOfBoundsException e) {
    		row = 0;
    	}
    	
    	int[][] temp = new int[col][row];
    	
    	for (int i = 0; i < matrix.length; i++) {
    		for (int j = 0; j < matrix[0].length; j++) {	 
    			temp[i][j] =  matrix[i][j];
    		}
    	}
    	this.matrix = temp;
    }
    public int getElement(int y, int x) {
    	try {
    		return matrix[x][y];
    	}
    	catch(ArrayIndexOutOfBoundsException e)	{
    		System.out.println("Invalid index.");
    		return -1;
    	}
    }
    public int getRows() {
    	int r= matrix.length;
    	return r;
    }
    public int getColumns() {
    	try {
	    	int c = matrix[0].length;
	    	return c;
    	}
    	catch(ArrayIndexOutOfBoundsException e)	{
    			return 0;
    	}
    }
    public FeigalMatrix scale(int scalar) {
    	//VARIABLES AND DECLARATIONS
    	int row, col;
    	//GET THE SIZE OF THE MATRIX TO BE SCALED SO THE NEW MATRIX CAN BE SIZED CORRECTLY
    	row = this.getRows();
    	col = this.getColumns();
    	//SET UP OUR NEW OUTPUT MATRIX
    	int[][] newData = new int[row][col];
    	FeigalMatrix newMatrix = new FeigalMatrix(newData);
    	//ITERATE THROUGH EACH ARRAY ELEMENT, SCALE THAT VALUE, AND PUT IT INTO THE SAME SPOT IN THE NEW ARRAY
    	for (int i = 0; i < matrix.length; i++) {
    		for (int j = 0; j < matrix[0].length; j++) {	 
    			newMatrix.matrix[i][j] = matrix[i][j]*scalar;
    		}
    	}
    	//RETURN THE NEW SCALED ARRAY
    	return newMatrix;	
    }
    public FeigalMatrix plus(Matrix other) {
    	//CHECK TO SEE IF THE MATRICES ARE THE SAME DIMENSIONS
    	if ((this.getRows() != other.getRows()) || (this.getColumns() !=other.getColumns())){
    		throw new RuntimeException();
    	}
    	//VARIABLES AND DECLARATIONS
    	int row, col;
    	//GET THE SIZE OF THE MATRIX TO BE SCALED SO THE NEW MATRIX CAN BE SIZED CORRECTLY
    	row = this.getRows();
    	col = this.getColumns();
    	//SET UP OUR NEW OUTPUT MATRIX
    	int[][] newData = new int[row][col];
    	
    	//ITERATE THROUGH EACH ELEMENT OF THE ARRAY AND ADD THE CORRESPONDING ELEMENTS TOGETHER, STORING THEM IN THE NEW MATRIX
    	for (int i = 0; i < matrix.length; i++) {
    		for (int j = 0; j < matrix[0].length; j++) {	 
    			newData[i][j] = matrix[i][j] + other.getElement(j, i);
    		}
    	}		
    	FeigalMatrix newMatrix = new FeigalMatrix(newData);
    	return newMatrix;
    }
    public FeigalMatrix minus(Matrix other) {
    	//CHECK TO SEE IF THE MATRICES ARE THE SAME DIMENSIONS
    	if ((this.getRows() != other.getRows()) || (this.getColumns() !=other.getColumns())){
    		throw new RuntimeException();
    	}
    	//VARIABLES AND DECLARATIONS
    	int row, col;
    	//GET THE SIZE OF THE MATRIX TO BE SCALED SO THE NEW MATRIX CAN BE SIZED CORRECTLY
    	row = this.getRows();
    	col = this.getColumns();
    	//SET UP OUR NEW OUTPUT MATRIX
    	int[][] newData = new int[row][col];
    	
    	//ITERATE THROUGH EACH ELEMENT OF THE ARRAY AND SUBTRACT THE CORRESPONDING ELEMENTS TOGETHER, STORING THEM IN THE NEW MATRIX
    	for (int i = 0; i < matrix.length; i++) {
    		for (int j = 0; j < matrix[0].length; j++) {	 
    			newData[i][j] = matrix[i][j] - other.getElement(j,i);
    		}
    	}	
    	
    	FeigalMatrix newMatrix = new FeigalMatrix(newData);
    	return newMatrix;
    }
    
    public boolean equals(FeigalMatrix other) {
    	//CHECK TO SEE IF THE MATRICES ARE THE SAME DIMENSIONS
    	if ((this.getRows() != other.getRows()) || (this.getColumns() !=other.getColumns())){
    		throw new RuntimeException();
    	}
    	for (int i = 0; i < matrix.length; i++) {
    		for (int j = 0; j < matrix[0].length; j++) {	 
    			if (matrix[i][j] != other.matrix[i][j]) {
    				return false;
    			}
    		}
    	}
    	//IF THE MATRICES HAVE BEEN ITERATED THROUGH WITHOUT RETURNING FALSE, THEN RETURN TRUE
    	return true;
    }
    
    
    public String toString() {
    	String str;
    	str = "";
    	for (int i = 0; i < this.getRows(); i++) {
    		for (int j = 0; j < this.getColumns(); j++) {	 
    				str = str + this.matrix[i][j] + " ";
    		}
    		str = str + "\n";
    	}   	
    	return str;
    }
    
    
    /**
     * Entry point for matrix testing.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[][] data1 = new int[0][0];
        int[][] data2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] data3 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        
        Matrix m1 = new FeigalMatrix(data1);
        Matrix m2 = new FeigalMatrix(data2);
        Matrix m3 = new FeigalMatrix(data3);
        
        System.out.println("m1 --> Rows: " + m1.getRows() + " Columns: " + m1.getColumns());
        System.out.println("m2 --> Rows: " + m2.getRows() + " Columns: " + m2.getColumns());
        System.out.println("m3 --> Rows: " + m3.getRows() + " Columns: " + m3.getColumns());
        
        //check for reference issues
        System.out.println("m2 -->\n" + m2);
        data2[1][1] = 101;
        System.out.println("m2 -->\n" + m2);

        //test equals
        System.out.println("m2==null: " + m2.equals(null));             //false
        System.out.println("m3==\"MATRIX\": " + m2.equals("MATRIX"));   //false
        System.out.println("m2==m1: " + m2.equals(m1));                 //false
        System.out.println("m2==m2: " + m2.equals(m2));                 //true
        System.out.println("m2==m3: " + m2.equals(m3));                 //false
        
        //test operations (valid)
        System.out.println("2 * m2:\n" + m2.scale(2));
        System.out.println("m2 + m3:\n" + m2.plus(m3));
        System.out.println("m2 - m3:\n" + m2.minus(m3));
        
        //test operations (invalid)
        //System.out.println("m1 + m2" + m1.plus(m2));
        //System.out.println("m1 - m2" + m1.minus(m2));
    }

}
