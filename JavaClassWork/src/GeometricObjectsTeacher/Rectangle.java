package GeometricObjectsTeacher;

public class Rectangle extends GeometricObject {
  private double width;
  private double height;

  public Rectangle() {
  }

  public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  public Rectangle(double width, double height, String color, boolean filled) {
    this.width = width;
    this.height = height;
    setColor(color);
    setFilled(filled);
  }

  /** Return width */
  public double getWidth() {
    return width;
  }

  /** Set a new width */
  public void setWidth(double width) {
    this.width = width;
  }

  /** Return height */
  public double getHeight() {
    return height;
  }

  /** Set a new height */
  public void setHeight(double height) {
    this.height = height;
  }

  /** Return area */
  public double getArea() {
    return width * height;
  }

  /** Return perimeter */
  public double getPerimeter() {
    return 2 * (width + height);
  }
  
   public String toString() {
    return super.toString() + "with width of " + getWidth() + " and the height of " + getHeight();
  }
   
   public boolean equals(Object object)
{
    if (object instanceof Rectangle)
    {
        Rectangle r = (Rectangle) object;
        if
        (getArea() == r.getArea())
            return true;
    }
    return false;
}
}
