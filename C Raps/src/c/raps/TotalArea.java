/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passingobject;

public class TotalArea {

    /**
     * Main method
     */
    public static void main(String[] args) {
        // Declare circleArray
        Circle[] circleArray;

        // Create circleArray
        circleArray = createCircleArray();

        // Print circleArray and total areas of the circles
        printCircleArray(circleArray);
    }

    /**
     * Create an array of Circle objects
     */
    public static Circle[] createCircleArray() {
        Circle[] circleArray = new Circle[5];

        for (int i = 0; i < circleArray.length; i++) {
            circleArray[i] = new Circle(Math.random() * 100);
        }

        // Return Circle array
        return circleArray;
    }

    /**
     * Print an array of circles and their total area
     */
    public static void printCircleArray(Circle[] circleArray) {
        System.out.printf("%-30s%-15s\n", "Radius", "Area");
        for (int i = 0; i < circleArray.length; i++) {
            System.out.printf("%-30f%-15f\n", circleArray[i].getRadius(),
                    circleArray[i].getArea());
        }

        System.out.println("-----------------------------------------");

        // Compute and display the result
        System.out.printf("%-30s%-15f\n","The total areas of circles is", sum(circleArray));
    }

    /**
     * Add circle areas
     */
    public static double sum(Circle[] circleArray) {
        // Initialize sum
        double sum = 0;

        // Add areas to sum
        for (int i = 0; i < circleArray.length; i++) {
            sum += circleArray[i].getArea();
        }

        return sum;
    }
}
