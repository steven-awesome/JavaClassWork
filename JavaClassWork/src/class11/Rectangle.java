/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class11;


public class Rectangle extends GeometricObject {

    private double width;
    private double height;
    GeometricObject Geo = new GeometricObject();
    
    
    public Rectangle(){
        width = 1.0;
        height = 1.0;       
    }
    
    public Rectangle(double height, double width){
        this.height = height;
        this.width = width;
    }
    
    public Rectangle(double height, double width, String color, boolean filled){
        this.height = height;
        this.width = width;
        this.color = color;
        this.filled = filled;
        
    }
    
    public void setWidth(double width){
        this.width = width;
    }
    
    public void setHeight(double height){
        this.height = height;
    }
    
    public double getWidth(){
        return width;
    }
    
    public double getHeight(){
        return height;
    }
    
    public double getArea(){
        return width * height;
    }
    
    public double getPerimeter(){
        return 2 * (width + height);
    }
    
    public String getInfo(){
        return "Width: " + width + " Height: " + height;
    }

}
