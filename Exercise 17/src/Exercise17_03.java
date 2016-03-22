/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;

public class Exercise17_03 {

    public void perform() throws IOException {
        try (
                ObjectOutputStream output = new ObjectOutputStream(
                        new FileOutputStream("Exercise17_03.dat"));) {
                    output.writeObject(new int[]{1, 2, 3, 4, 5});
                    output.writeObject(new java.util.Date());
                    output.writeDouble(5.5);
                }
    }

    public static void main(String[] args) {
        Exercise17_03 ex = new Exercise17_03();
        try {
            ex.perform();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
    }
}
