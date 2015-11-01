package GeometricObjectsTeacher;

 
public class TestCircleRectangle {
  public static void main(String[] args) {
    Circle circle = new Circle(1);
    Circle circle1 = new Circle(1);
    System.out.println(circle == circle1);
    System.out.println(circle.equals(circle1));
    
    
    Rectangle rectangle = new Rectangle(2, 4);
    Rectangle rectangle1 = new Rectangle(3, 4);
    System.out.println(rectangle == rectangle1);
        System.out.println(rectangle.equals(rectangle1));

  }
}

