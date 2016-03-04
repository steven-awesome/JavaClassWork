/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author st_morr
 */
public class FileReading {
    
    
    public String read() throws FileNotFoundException, IOException{
        Scanner sc = new Scanner("Exercise282.txt");
        StringBuilder sb = new StringBuilder();
        String s = null;
        
        BufferedReader br;
        br = new BufferedReader(new FileReader("C:\\Users\\fista\\Documents\\NetBeansProjects\\JavaClassWork\\Java2Class11FX\\jfxTest.txt"));
        
        while ((s = br.readLine()) != null){
            sb.append(s+"\n\n");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException{
        FileReading fr= new FileReading();
        System.out.println(fr.read());
    }
    
}
