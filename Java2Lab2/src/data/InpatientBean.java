/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Date;


/**
 *
 * @author Steven
 */
public class InpatientBean {
    
    private int ID;
    private int patientID;
    private Date dateOfStay;
    private String roomNumber;
    private double dailyRate;
    private double supplies;
    private double services;

    public InpatientBean() {
    }

    public InpatientBean(int ID, int patientID, Date dateOfStay, String roomNumber, double dailyRate, double supplies, double services) {
        this.ID = ID;
        this.patientID = patientID;
        this.dateOfStay = dateOfStay;
        this.roomNumber = roomNumber;
        this.dailyRate = dailyRate;
        this.supplies = supplies;
        this.services = services;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public Date getDateOfStay() {
        return dateOfStay;
    }

    public int getID() {
        return ID;
    }

    public int getPatientID() {
        return patientID;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public double getServices() {
        return services;
    }

    public double getSupplies() {
        return supplies;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public void setDateOfStay(Date dateOfStay) {
        this.dateOfStay = dateOfStay;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setServices(double services) {
        this.services = services;
    }

    public void setSupplies(double supplies) {
        this.supplies = supplies;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
