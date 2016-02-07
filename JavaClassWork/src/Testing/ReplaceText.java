/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author IT
 */
public class ReplaceText {
    
    String oldString = "public";
    String newString = "protected";

    public void perform() throws Exception {

        File sourceFile = new File("ReadData.java");

        // Check if source file exists
        if (!sourceFile.exists()) {
            System.out.println("File does not exists");
            System.exit(0);
        }

        // Check if target file exists
        File targetFile = new File("targetFile.txt");
        if (targetFile.exists()) {
            System.out.println("Target file already exists");
            System.exit(0);
        }

        try (
                // Create input and output files
                Scanner input = new Scanner(sourceFile);
                PrintWriter output = new PrintWriter(targetFile);) {
            while (input.hasNext()) {
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(oldString, newString);
                output.println(s2);
            }

        }
    }

    public static void main(String[] args) {
        ReplaceText rt = new ReplaceText();
        try {
            rt.perform();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
