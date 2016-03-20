/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author fista
 */
public class Test {
    
    static int i = 1;
    static String s = "mnm";
    
    public boolean isInt(Object i){
        Object n = (Integer) i;
        if( n instanceof Integer){
            return true;
        } else return false;
    }
    
    public static void main(String[] args){
        Test t = new Test();
        System.out.println(t.isInt(s));
    }
    
}
