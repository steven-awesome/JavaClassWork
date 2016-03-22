/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;

public class Exercise17_01 {

    public void perform() throws IOException {
        try (DataOutputStream output
                = new DataOutputStream(new FileOutputStream("Exercise17_01.dat", true));) {
            for (int i = 0; i < 100; i++) {
                output.writeInt((int) (Math.random() * 100000));
            }
        }

        System.out.println("Done");
    }

    public static void main(String[] args) {
        Exercise17_01 ex = new Exercise17_01();
        try {
            ex.perform();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
    }
}
