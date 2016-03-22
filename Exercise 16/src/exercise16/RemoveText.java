/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise16;

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

        // read from a file by using BufferedReader
        Path file = Paths.get(fileName);

        try (BufferedReader reader
                = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            String line = null;
            while ((line = reader.readLine()) != null) {

                String s2 = line.replaceAll(name, "");

                sb.append('\n' + s2);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        // write to a file by using BufferWriter
        try (BufferedWriter writer
                = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
            writer.write(sb.toString(), 0, sb.length());
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

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
