/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questionthree;

import java.util.Set;




/**
 *
 * @author st_morr
 */
public class TestClass {
    
    Student stu1 = new Student("Amin", "Montreal", "514-848-2424", "amin@concordia.ca", "freshman");
    Student stu2 = new Student("Amin", "Montreal", "514-848-2424", "amin@concordia.ca", "freshman");
    Staff staff = new Staff();
    
    public void perform(){
        staff.setAddress("Montreal");
        staff.setName("Amin");
        staff.setNumber("514-848-2424");
        staff.setEmail("amin@concordia.ca");
        staff.setSalary(35000);
        staff.setDateHired("22 Sept 2012");
        staff.setTitle("secretary");
        
        System.out.println("Are student1 and student2 equal?\n"
                + "Answer: "+stu1.equals(stu2)+"\n\n");
        System.out.println("Staff info: \n" + staff.toString()+"\n");
        String print = staff.toPrint();
        System.out.println("toPrint printout: " +print);
    }
    
    public static void main(String[] args){
        TestClass tc = new TestClass();
        tc.perform();
    }
    
}
