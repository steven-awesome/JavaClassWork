/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java2Class3;

public class TestMyPoint {

    public void perform() {
        MyPoint p1 = new MyPoint();
        MyPoint p2 = new MyPoint(10, 30.5);
        System.out.println(p1.distance(p2));
        System.out.println(MyPoint.distance(p1, p2));
    }

    public static void main(String[] args) {
        TestMyPoint tmp = new TestMyPoint();
        tmp.perform();
    }

}
