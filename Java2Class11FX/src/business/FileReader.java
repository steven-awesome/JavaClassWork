/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author st_morr
 */
public class FileReader {
    
    public String read(){
        Scanner sc = new Scanner("Exercise282.txt");
        StringBuilder sb = new StringBuilder();
        
        while (sc.hasNext()){
            sb.append(sc.next());
        }
        return sb.toString();
    }
    
}
