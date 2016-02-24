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
public class PatientBean implements Comparable {
    
    private int patiendID;
    private String lastName;
    private String firstName;
    private String diagnosis;
    private Date admissonDate;
    private Date releaseDate;

    public PatientBean() {
    }

    public Date getAdmissonDate() {
        return admissonDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPatiendID() {
        return patiendID;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setAdmissonDate(Date admissonDate) {
        this.admissonDate = admissonDate;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatiendID(int patiendID) {
        this.patiendID = patiendID;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
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

    @Override
    public int compareTo(Object o) {
        return 
    }
    
    
    
    
}
