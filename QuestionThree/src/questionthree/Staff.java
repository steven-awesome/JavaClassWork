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
public class Staff extends Employee{
    
    private String title;
    
    
    
    public Staff(){
        
    }
    
    
    public Staff(String name, String address, String number, String email, String office, int salary, String dateHired, String title){
        setName(name);
        setAddress(address);
        setNumber(number);
        setEmail(email);
        setOffice(office);
        setSalary(salary);
        setDateHired(dateHired);
        this.title = title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getTitle(){
        return title;
    }
    
    @Override
    public String toString(){
        return super.toString() +
                "Title: "+title;
    }
    
    public boolean equals(Object obj){
        if (obj instanceof Staff){
            Staff st = (Staff) obj;
            if (super.equals(st) && title.equals(st.getTitle()))
                return true;
        }
        return false;
    }
    
    @Override
    public String toPrint(){
        return super.toPrint() + " " + getClass().toString();
    }
    
}
