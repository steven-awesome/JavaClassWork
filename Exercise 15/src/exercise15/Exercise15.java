/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise15;

import java.util.Scanner;

/**
 *
 * @author IT
 */
public class Exercise15 {

    public void perform() throws Exception {
        java.net.URL url
                = new java.net.URL("http://cs.armstrong.edu/liang/data/Scores.txt");

        try (Scanner input = new Scanner(url.openStream())) {
            double sum = 0;
            int count = 0;
            while (input.hasNext()) {
                sum += input.nextDouble();
                count++;
            }

            System.out.println("Total is " + sum);
            System.out.println("Average is " + sum / count);
        }

    }

    public static void main(String[] args) {
        Exercise15 e15 = new Exercise15();
        try {
            e15.perform();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
