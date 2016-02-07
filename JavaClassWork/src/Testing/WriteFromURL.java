/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author st_morr
 */
public class WriteFromURL {
    Scanner sc;
    StringBuilder sb;
    public void perform() throws Exception {
        java.io.File file = new java.io.File("scores1.txt");
        URL url = new URL("http://cs.armstrong.edu/liang/data/Scores.txt");
        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(0);
        }

        // Create a file
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        sc = new Scanner(url.openStream());
        sb = new StringBuilder();
        try{
        while (sc.hasNext()) {
            sb.append(sc.next() + " ");
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        output.println(sb.toString());
        output.println("total: ");

        // Close the file
        output.close();
    
}

public static void main(String[] args){
        WriteFromURL wfu = new WriteFromURL();
        try{
        wfu.perform();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}