/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questionthree;

/**
 *
 * @author st_morr
 */
public class Student extends Person {
    
    private String status;
    
    public Student(){
        
    }
    
    public Student(String name, String address, String number, String email, String status){
        setName(name);
        setAddress(address);
        setNumber(number);
        setEmail(email);
        this.status = status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public String getStatus(){
        return status;
    }
    
    
    @Override
    public String toString(){
        return super.toString()+
                "Office: "+status;
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Student){
            Student s = (Student) obj;
            if (super.equals(s) && status.equals(s.getStatus()))
                return true;
        }
        return false;
    }
    
    
   
    @Override
    public String toPrint(){
        String s = getClass().toString() + " " + super.getClass().toString();
        return s;
    }
    
    
}
