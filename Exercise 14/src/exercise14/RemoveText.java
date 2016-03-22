/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class RemoveText {

    private String fileName = "";
    private String name = "";
    StringBuilder sb = new StringBuilder();

    public void input() {
        Scanner gettingInput = new Scanner(System.in);
        System.out.println("Please provide a file name");
        fileName = gettingInput.nextLine();

        System.out.println("Please provide a word");
        name = gettingInput.nextLine();
    }

    public void perform() throws Exception {

        input();
        // Check if the file exists
        File sourceFile = new File(fileName);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + fileName + " not exist");
            System.exit(2);
        }
        // Read text from the file and save it in a string builder
        Scanner input = new Scanner(sourceFile);

        while (input.hasNext()) {
            String s1 = input.nextLine();
            String s2 = s1.replaceAll(name, "");

            sb.append('\n' + s2);

        }
        // Write back to the file
        PrintWriter output = new PrintWriter(sourceFile);
        output.println(sb.toString());
        output.close();

    }

    public static void main(String[] args) {
        RemoveText rt = new RemoveText();
        try {
            rt.perform();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
