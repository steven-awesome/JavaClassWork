/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reading;

import java.util.Scanner;

/**
 *
 * @author IT
 */
public class ReadData {

    public void perform() throws Exception {
        // Create a File instance
        java.io.File file = new java.io.File("scores.txt");

        // Create a Scanner for the file
        Scanner input = new Scanner(file);

        // Read data from a file
        while (input.hasNext()) {
            String firstName = input.next();
            String mi = input.next();
            String lastName = input.next();
            int score = input.nextInt();
            System.out.println(
                    firstName + " " + mi + " " + lastName + " " + score);
        }

        // Close the file
        input.close();

    }

    public static void main(String[] args) {
        ReadData rd = new ReadData();
        try {
            rd.perform();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
