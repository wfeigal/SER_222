package Week2_Unit3;

import java.util.*;

/**
 * MazeSolver attempts to recursively traverse a Maze. The goal is to get from the
 * given starting position to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent locations in the maze that have been TRIED
 * and that are part of the solution PATH.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public class MazeSolver
{
    private Maze maze;
    
    /**
     * Constructor for the MazeSolver class.
     */
    public MazeSolver(Maze maze)
    {
        this.maze = maze;
    }
    
    /**
     * Attempts to recursively traverse the maze. Inserts special
     * characters indicating locations that have been TRIED and that
     * eventually become part of the solution PATH.
     *
     * @param row row index of current location
     * @param column column index of current location
     * @return true if the maze has been solved
     */
    public boolean traverse()
    {
        boolean done = false;
        int row, column;
        String start, end; 
        String[] st, en;
        Scanner scan = new Scanner(System.in);
        
        //GET STARTING POSITION FROM THE USER
        System.out.println("Enter the starting position (two integers seperated by a comma):");
        start = scan.nextLine();
        st = start.split(",");
        int startx = Integer.parseInt(st[0]);
        int starty = Integer.parseInt(st[1]);
        Position startPos = new Position();
        try {
        	if(maze.validPosition(startx, starty)) {
            	startPos.setx(startx);
            	startPos.sety(starty);
        	}
        	else {
        		throw new NumberFormatException();
        	}
        }
        catch (NumberFormatException e) {
    		System.out.println("Invalid Input! \nDefault start point used...");
        	startPos.setx(0);
        	startPos.sety(0);
        }
        
        //GET ENDING POSITION FROM THE USER
        System.out.println("Enter the ending position (two integers seperated by a comma):");
        end = scan.nextLine();
        en = start.split(",");
        int endx = Integer.parseInt(st[0]);
        int endy = Integer.parseInt(st[1]);
        Position endPos = new Position();
        try {
        	if(maze.validPosition(endx, endy)) {
            	endPos.setx(endx);
            	endPos.sety(endy);
            	
        	}
        	else {
        		throw new NumberFormatException();
        	}
        }
        catch (NumberFormatException e) {
    		System.out.println("Invalid Input! \nDefault end point used...");
        	endPos.setx(0);
        	endPos.sety(0);
        }
        
        
        System.out.println("Start position is: x:" + startx + " y:" + starty);
        System.out.println("End position is: x:" + endx + " y:" + endy);
        
        
        
        Deque<Position> stack = new LinkedList<Position>();
		stack.push(startPos);
        
        Position pos = new Position();
        while (!(done) && !stack.isEmpty())
        {
            pos = stack.pop();
            maze.tryPosition(pos.getx(),pos.gety());  // this cell has been tried
            if (pos.getx() == maze.getRows()-1 && pos.gety() == maze.getColumns()-1)
                done = true;  // the maze is solved
            else
            {
                push_new_pos(pos.getx() - 1,pos.gety(), stack); 
                push_new_pos(pos.getx() + 1,pos.gety(), stack);
                push_new_pos(pos.getx(),pos.gety() - 1, stack);
                push_new_pos(pos.getx(),pos.gety() + 1, stack); 
            }
        }
        
        return done;
    }
    
    /**
     * Push a new attempted move onto the stack
     * @param x represents x coordinate
     * @param y represents y coordinate
     * @param stack the working stack of moves within the grid
     * @return stack of moves within the grid
     */
    private void push_new_pos(int x, int y, 
                                         Deque<Position> stack)
    {
        Position npos = new Position();
        npos.setx(x);
        npos.sety(y);
        if (maze.validPosition(x,y))
            stack.push(npos);
    }
    
}
