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
public class Fan {
    //--------------------
    public final int SLOW = 1, MEDIUM = 2, FAST = 3;
    int speed;
    private boolean on = false;
    private double radius = 5;
    String color;
    //--------------------
    
    public Fan(){
       speed = SLOW;
       on = false;
       radius  =4;
       color = "blue";
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
    
    public boolean isOn(){
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
        return "Speed: " + getSpeed() + "\nRadius: " + getRadius() + "\nColor: " + getColor() + "\nOn?: " + isOn();
    }
    
    
    
    
    
    
    
    
}
