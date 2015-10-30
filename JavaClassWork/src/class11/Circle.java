
package class11;

public class Circle extends GeometricObject {
    
    private double radius;
    
    private static int numberOfObjects;
    
    
/////////////Constructors
    
    
    public Circle(){
        radius = 1;
    }
    
    public Circle(double newRadius){
        radius = newRadius;
    }
    
    public Circle(double radius, String color, boolean filled){
        this.radius = radius;
        this.color = color;
    }
    
/////////////Methods
    
    public double getRadius(){
        return radius;
    }
    
    public void setRadius(double newRadius){
        radius = newRadius;
    }
    
    public static int getNumberOfObject(){
        return numberOfObjects;
    }
    
    public double getArea(){
        return Math.pow(radius, 2) * Math.PI;
    }
}
