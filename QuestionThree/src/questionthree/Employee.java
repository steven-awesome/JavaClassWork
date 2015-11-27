/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questionthree;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author st_morr
 */
public class Employee extends Person {
    private String office;
    private double salary;
    private String dateHired;
    
    
    public Employee(){
        
    }
    
    public Employee(String name, String address, String number, String email, String office, double salary, String dateHired){
        setName(name);
        setAddress(address);
        setNumber(number);
        setEmail(email);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }
    
    public void setOffice(String office){
        this.office = office;
    }
    
    public void setSalary(double salary){
        this.salary = salary;
    }
    
    public void setDateHired(String dateHired){
        
        this.dateHired = dateHired;
    }
    
    public String getOffice(){
        return office;
    }
    
    public double getSalary(){
        return salary;
    }
    
    public String getDateHired(){
        return dateHired;
    }
    
    
    @Override
    public String toString(){
        return super.toString()+
                "Office: "+office+"\n"+
                "Salary: "+salary+"\n"+
                "Date Hired: "+dateHired+"\n";
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Employee){
            Employee e = (Employee) obj;
            if (super.equals(e) && office.equals(e.getOffice()) && salary == e.getSalary() && dateHired.equals(e.getDateHired())){
                return true;
            }
        }
        return false;
    }
    
    
   
    @Override
    public String toPrint(){
        String s = getClass().toString() +" " + super.getClass().toString();
        return s;
    }
    
    
}
