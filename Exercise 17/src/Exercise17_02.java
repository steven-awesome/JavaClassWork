/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;

public class Exercise17_02 {
  
private String inputFile = "Exercise17_01.java";
private String outputFile = "Exercise17_01.dat";

public void perform() throws IOException {
        try (
      BufferedReader input = new BufferedReader(new FileReader(inputFile));
      DataOutputStream output = new DataOutputStream(new FileOutputStream(outputFile));
    ) {
      String line;
      while ((line = input.readLine()) != null)
        output.writeUTF(line);
    }

    try (
      InputStream input1 = new FileInputStream(inputFile);
      InputStream input2 = new FileInputStream(outputFile);
    ) {
      System.out.println(inputFile + "'s size is " + input1.available() + " bytes");
      System.out.println(outputFile + "'s size is " + input2.available() + " bytes");
    }
    }

    public static void main(String[] args) {
        Exercise17_02 ex = new Exercise17_02();
        try {
            ex.perform();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
    }
}


