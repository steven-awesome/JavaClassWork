/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Writing;

public class WriteDataWithAutoClose {

    public void perform() throws Exception {
        java.io.File file = new java.io.File("scores.txt");
        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(0);
        }

        try (
                // Create a file
                java.io.PrintWriter output = new java.io.PrintWriter(file);) {
            // Write formatted output to the file
            output.print("John T Smith ");
            output.println(90);
            output.print("Eric K Jones ");
            output.println(85);
        }

    }

    public static void main(String[] args) {
        WriteDataWithAutoClose wd = new WriteDataWithAutoClose();
        try {
            wd.perform();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}