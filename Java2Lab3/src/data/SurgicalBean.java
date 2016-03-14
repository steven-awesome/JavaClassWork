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
public class SurgicalBean extends PatientParent{
    
    private int ID;
    private int patientID;
    private Date dateOfSurgery;
    private String surgery;
    private double roomFee;
    private double surgeonFee;
    private double supplies;

    public SurgicalBean() {
    }

    public SurgicalBean(int ID, int patientID, Date dateOfSurgery, String surgery, double roomFee, double surgeonFee, double supplies) {
        this.ID = ID;
        this.patientID = patientID;
        this.dateOfSurgery = dateOfSurgery;
        this.surgery = surgery;
        this.roomFee = roomFee;
        this.surgeonFee = surgeonFee;
        this.supplies = supplies;
    }

    public Date getDateOfSurgery() {
        return dateOfSurgery;
    }

    public int getID() {
        return ID;
    }

    @Override
    public int getPatientID() {
        return patientID;
    }

    public double getRoomFee() {
        return roomFee;
    }

    public double getSupplies() {
        return supplies;
    }

    public double getSurgeonFee() {
        return surgeonFee;
    }

    public String getSurgery() {
        return surgery;
    }

    public void setDateOfSurgery(Date dateOfSurgery) {
        this.dateOfSurgery = dateOfSurgery;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public void setRoomFee(double roomFee) {
        this.roomFee = roomFee;
    }

    public void setSupplies(double supplies) {
        this.supplies = supplies;
    }

    public void setSurgeonFee(double surgeonFee) {
        this.surgeonFee = surgeonFee;
    }

    public void setSurgery(String surgery) {
        this.surgery = surgery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        SurgicalBean other = (SurgicalBean) o;
        if (patientID != other.patientID) {
            return false;
        }
        if (!dateOfSurgery.equals(other.dateOfSurgery)) {
                return false;
        }
        if (surgery == null) {
            if (other.surgery != null) {
                return false;
            }
        } else if (!surgery.equals(other.surgery)) {
            return false;
        }
        if (roomFee != other.roomFee) {
            return false;
        }
        if (surgeonFee != other.surgeonFee) {
            return false;
        }
        if (supplies != other.supplies) {
            return false;
        }
        
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        String s =  "            Patient ID = " + patientID + "\n" + 
                        "   Date Of Surgery = " + dateOfSurgery.toString() + "\n" + 
                        "               Surgery = " + surgery + "\n" + 
                        "           Room Fee = " + roomFee + "\n" + 
                        "        Surgeon Fee = " + surgeonFee + "\n" + 
                        "              Supplies = " + supplies + "\n";

        return s;
    }
    
    
    
}
