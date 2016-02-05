/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java2Class4;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author st_morr
 */
public class NewClass {
    StringBuilder s = null;
    
    public void ReadWriteFile() throws Exception{
        
        File file = new File("Exercise14.txt");
        if (!file.exists()) {
                System.out.println("File already exists");
                System.exit(0);
            }
        
        Scanner input = new Scanner(file);
        
        
        while(input.hasNext()){
            String s1 = input.nex();
            
            if (input.next().equalsIgnoreCase("john")){
                s.append("\n"+s1);
            }
        }
        
        PrintWriter output = new PrintWriter(file);
        
        output.println(s.toString());
        output.close();
        input.close();
        
    }
    
    
    
    public static void main(String[] args){
        NewClass nc = new NewClass();
        try{
            nc.ReadWriteFile();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

