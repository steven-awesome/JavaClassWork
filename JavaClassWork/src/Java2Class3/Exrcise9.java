/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java2Class3;

/**
 *
 * @author smorrissey
 */
public class Exrcise9 {
    //--------------------
    private int speed;
    private boolean on = false;
    private double radius = 5;
    String color;
    //--------------------
    
    public Exrcise9(){
        super();
    }
    //---------------------
    
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    public int getSpeed(){
        return speed;
    }
    
    public void setOn(boolean on){
        this.on = on;
    }
    
    public boolean getOn(){
        return on;
    }
    
    public void setRadius(double radius){
        this.radius = radius;
    }
    
    public double getRadius(){
        return radius;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public String getColor(){
        return color;
    }
    
    
    @Override
    public String toString(){
        
    }
    
    
    
    
    
    
    
    
}
