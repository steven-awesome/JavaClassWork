/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c.raps;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author smorrissey
 */
public class TestReadClass {
    
    
    public void WriteFile() throws Exception{
        java.io.File file = new File("Test txt.txt");
        if (file.exists()){
            System.out.println("File already exists");
            System.exit(0);
        }
        
        
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        output.print("Test1 testt ");
        output.println(10);
        output.print("Test2 tesst ");
        output.println(200);
        
        output.close();
        
        
        
        
    }
    
    public void ReadFile() throws Exception{
        java.io.File file = new File("Test txt.txt");
        
        Scanner sc = new Scanner(file);
        
        while(sc.hasNext()){
            String testString1 = sc.next();
            String testString2 = sc.next();
            int testNum = sc.nextInt();
            System.out.println(
                    testString1 + " " + testString2 + " " + testNum);
        }
        
        sc.close();
    }
    
    
    
    public static void main(String[] args){
        TestReadClass trc = new TestReadClass();
        try{
            trc.WriteFile();
            trc.ReadFile();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
