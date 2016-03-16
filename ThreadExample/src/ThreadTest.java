
import java.util.concurrent.ExecutorService;
import java.util.concurrent.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fista
 */
public class ThreadTest {
    
    public static class testRunable implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 100; i++){
                System.out.println("a");
            }
        }
    
    }
    
    public static class testRunable2 implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 100; i++){
                System.out.println("b");
            }
        }
    
    }
    
    public static class testRunable3 implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 100; i++){
                System.out.println(i);
            }
        }
    
    }
    
     public static void main(String args[]) throws InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        ex.execute(new testRunable());
        ex.execute(new testRunable2());
        ex.execute(new testRunable3());
    }

}
