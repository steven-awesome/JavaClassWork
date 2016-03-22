/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
  /** Construct a ComparableRectangle with specified properties */
  public ComparableCircle(double radius) {
    super(radius);
  }

  @Override
  public int compareTo(ComparableCircle o) {
    if (getRadius() > o.getRadius())
      return 1;
    else if (getRadius() < o.getRadius())
      return -1;
    else
      return 0;
  }
}

//Max.java: Find a maximum object
class Max {
  /** Return the maximum of two objects */
  public static ComparableCircle max(ComparableCircle o1, ComparableCircle o2) {
    if (o1.compareTo(o2) > 0)
      return o1;
    else
      return o2;
  }
}
