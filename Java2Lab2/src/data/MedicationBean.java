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
public class MedicationBean {
    
    private int ID;
    private int patientID;
    private Date dateOfMed;
    private String med;
    private double unitCost;
    private double units;

    public MedicationBean() {
    }

    public MedicationBean(int ID, int patientID, Date dateOfMed, String med, double unitCost, double units) {
        this.ID = ID;
        this.patientID = patientID;
        this.dateOfMed = dateOfMed;
        this.med = med;
        this.unitCost = unitCost;
        this.units = units;
    }

    public Date getDateOfMed() {
        return dateOfMed;
    }

    public int getID() {
        return ID;
    }

    public String getMed() {
        return med;
    }

    public int getPatientID() {
        return patientID;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public double getUnits() {
        return units;
    }

    public void setDateOfMed(Date dateOfMed) {
        this.dateOfMed = dateOfMed;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMed(String med) {
        this.med = med;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public void setUnits(double units) {
        this.units = units;
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
