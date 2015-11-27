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
public abstract class Person {
    
    private String name, address, number, email;
    
    public Person(){
        
    }
    
    public Person(String name, String address, String number, String email){
        this.name = name;
        this.address = address;
        this.number = number;
        this.email = email;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    public void setNumber(String number){
        this.number = number;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getName(){
        return name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getNumber(){
        return number;
    }
    
    public String getEmail(){
        return email;
    }
    
    
    @Override
    public String toString(){
        return "Name: "+name+"\n"+
                "Address: "+address+"\n"+
                "Phone Number: "+number+"\n"+
                "Email: "+email+"\n";
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Person){
            Person p = (Person) obj;
            if(name.equals(p.getName()) && address.equals(p.getAddress()) && number.equals(p.getNumber()) && email.equals(p.getEmail())){
                return true;
            }
        }
        return false;
    }
    
    public abstract String toPrint();
    
   
    
}
