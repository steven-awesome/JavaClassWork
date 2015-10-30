/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class11;

/**
 *
 * @author st_morr
 */
public class TestTriangle {
    
    public void perform(){
        Triangle tri1 = new Triangle( 2.3, 3.3, 4.3);
        Triangle tri2 = new Triangle (2.4, 3.3, 4.3);
        
        System.out.println("tri1 = tri2 ?: " + tri1.equals(tri2));
    }
    
    
    public static void main(String[] args){
        TestTriangle myClass = new TestTriangle();
        myClass.perform();
    }
    
}
