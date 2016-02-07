/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

public class TestPassObject {

    public void perform() {
        // Create a Circle object with radius 1
        Circle myCircle = new Circle(1);

        // Print areas for radius 1, 2, 3, 4, and 5.
        int n = 5;
        printAreas(myCircle, n);

        // See myCircle.radius and times
        System.out.println("\n" + "Radius is " + myCircle.getRadius());
        System.out.println("n is " + n);
    }

    /**
     * Print a table of areas for radius
     */
    public static void printAreas(Circle c, int times) {
        System.out.println("Radius \t\tArea");
        while (times >= 1) {
            System.out.println(c.getRadius() + "\t\t" + c.getArea());
            c.setRadius(c.getRadius() + 1);
            times--;
        }
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        TestPassObject tpo = new TestPassObject();
        tpo.perform();
    }
}
