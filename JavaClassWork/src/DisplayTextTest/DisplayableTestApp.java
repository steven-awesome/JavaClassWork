package DisplayTextTest;


import java.util.Scanner;

public class DisplayableTestApp
{
    
    private static String displayMultiple(Displayable d, int count){
      int x = 0;
      String s = "";
        
      while (x < count){
          String t = d.getDisplayText();
          s = s + t + "\n";
          ++x;
      }
      return s;
    }
    
    
    
    
    public static void main(String args[])
    {
        System.out.println("Welcome to the Displayable Test application\n");

        // create an Employee object
        Displayable e1 = new Employee(1, "testName", "testLast", 45.9);
        // display the employee information        
        //System.out.println(e1.getDisplayText() + "\n");
        
      //  String s = DisplayableTestApp.displayMultiple(e1, 3);
        System.out.println(DisplayableTestApp.displayMultiple(e1, 10));
        // create a Product object
        Displayable p2 = new Product("xyz", "this is a product", 45.555);
        Displayable p3 = new Product("aaa", "this is a product", 45.555);
        // display the product information
        System.out.println(DisplayableTestApp.displayMultiple(p2, 2) + " " + p2.equals(p3));
        
        // create another Employee object
        Displayable e2 = new Employee(2, "secondTest", "secondTestTest", 54.657);
        // compare the two Employee objects
        
        System.out.println();
        
        // create another Product object
        
        // compare the two Product objects
        
    }
}