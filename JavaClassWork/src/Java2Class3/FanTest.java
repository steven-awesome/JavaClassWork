/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java2Class3;

/**
 *
 * @author fista
 */
public class FanTest {
    Fan fan1 = new Fan();
    Fan fan2 = new Fan();
    
    public void perform(){
        fan1.setSpeed(FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        fan2.setSpeed(2);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false);
        
        System.out.println(fan1.toString() + "\n\n" + fan2.toString());
    }
    
    
    public static void main (String[] args){
        FanTest ft = new FanTest();
        ft.perform();
        System.exit(0);
    }
}
