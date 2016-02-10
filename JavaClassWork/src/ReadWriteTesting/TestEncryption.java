/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadWriteTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author st_morr
 */
public class TestEncryption {
    ArrayList<Integer> num = new ArrayList();
    
    
    public void perform() throws Exception{
        
        write();
        
    }
    
    
    public void write() throws IOException{
        Scanner consoleInput = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String filenameInput = consoleInput.nextLine();
        String filenameOutput = consoleInput.nextLine();
        
        RandomAccessFile rafI = new RandomAccessFile(filenameInput, "r");
        RandomAccessFile rafO = new RandomAccessFile(filenameOutput, "rw");
    
        
        int test;
        while (rafI.getFilePointer() < rafI.length()){
            test = rafI.read();
            rafO.writeByte(test+5);
        }
        
        
        
    }
    
}
