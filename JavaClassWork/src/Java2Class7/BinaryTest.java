/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java2Class7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author st_morr
 */
public class BinaryTest {
    
    
    public BinaryTest(){}
    
    ArrayList<Integer> num = new ArrayList();
    
    
    public void perform() throws Exception{
        write();
        read();
    }
    
    
    public void write() throws IOException{
        try(ObjectOutputStream output = new ObjectOutputStream(
                    new FileOutputStream("Exercise17_01.dat",true));
            )
            {
        for (int i = 0; i < 100; i++){
            num.add((int)(Math.random()*10));
            
        }
        output.writeObject(num);
        }
    
        
    }
    
    public void read() throws IOException, ClassNotFoundException{
        ArrayList<Integer> nums = new ArrayList();
        ObjectInputStream input = new ObjectInputStream(
                new FileInputStream("Exercise17_01.dat"));
        //while(input.readObject() != null){
           nums = (ArrayList<Integer>) (input.readObject()); 
        //}
        
        System.out.println(nums.toString());
    }
    
    
    
    public static void main(String[] args) throws Exception{
        BinaryTest bt = new BinaryTest();
        try{
        bt.perform();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }
        

}
