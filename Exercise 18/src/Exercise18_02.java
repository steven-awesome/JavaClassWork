/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.io.*;

public class Exercise18_02 {

    public void perform() throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an encrypted file: ");
        File inputFile = new File(input.nextLine());
        System.out.print("Enter the output file: ");
        File outputFile = new File(input.nextLine());

        try (
                BufferedInputStream in = new BufferedInputStream(
                        new FileInputStream(inputFile));
                BufferedOutputStream output = new BufferedOutputStream(
                        new FileOutputStream(outputFile));) {
                    int value;
                    while ((value = in.read()) != -1) {
                        output.write(value - 5);
                    }
                }
    }

    public static void main(String[] args) {
        Exercise18_02 ex = new Exercise18_02();
        try {
            ex.perform();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
    }
}


