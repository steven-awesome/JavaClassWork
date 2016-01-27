/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java2Class3;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author st_morr
 */
public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    
    public Account(){
        id = 0;
        balance = 0;
        dateCreated = new Date();
    }
    
    public Account(int id, double balance){
        this.id = id;
        this.balance = balance;
        dateCreated = new Date();
    }
    
    //================================

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    //================================
    
    
    public double getMonthlyInterestRate(){
        return (getAnnualInterestRate() / 100) / 12;
    }
    
    public double getMonthlyInterest(){
        return getBalance() * getMonthlyInterestRate();
    }
    
    public void withdraw(double amt){
        balance -= amt;
    }
    
    public void deposit(double amt){
        balance += amt;
    }
    
    
    
}
