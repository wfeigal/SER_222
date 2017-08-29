package Week2_Unit3;

/**
 *  @author Lewis and Chase
 *
 *  Solution to Programming Project 4.6.
 */
public class Position
{
  private int x; 
  private int y;

  /**
   * Constructs a position and sets the x & y coordinates to 0,0.
   */
  Position ()
  {
    x = 0;
    y = 0;
  }
  
  /**
   * Constructs a position and sets the x & y coordinates to user defined values.
   */
  Position (int xc, int yc)
  {
    x = xc;
    y = yc;
  }

  /**
   * Returns the x-coordinate value of this position.
   * @return int the x-coordinate of this position
   */
  public int getx()
  {
    return x;
  }

  /**
   * Returns the y-coordinate value of this position.
   * @return int the y-coordinate of this position
   */
  public int gety()
  {
    return y;
  }

  /**
   * Sets the value of the current position's x-coordinate.
   * @param a value of x-coordinate
   */
  public void setx(int a)
  {
    x = a;
  }

   /**
   * Sets the value of the current position's x-coordinate.
   * @param a value of y-coordinate
   */ 
  public void sety(int a)
  {
    y = a;
  }
}
