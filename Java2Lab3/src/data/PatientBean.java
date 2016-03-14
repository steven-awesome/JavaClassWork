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
public class PatientBean extends PatientParent {
    
    private int patientID;
    private String lastName;
    private String firstName;
    private String diagnosis;
    private Date admissionDate;
    private Date releaseDate;

    public PatientBean() {
    }

    public PatientBean(int patientID, String lastName, String firstName, String diagnosis, Date admissionDate, Date releaseDate) {
        this.patientID = patientID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.diagnosis = diagnosis;
        this.admissionDate = admissionDate;
        this.releaseDate = releaseDate;
    }

    public Date getAdmissionDate() {
        return admissionDate;
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

    @Override
    public int getPatientID() {
        return patientID;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
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

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
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
        PatientBean other = (PatientBean) o;
        if (patientID != other.patientID) {
            return false;
        }
        if (lastName == null) {
            if (other.lastName != null) {
                return false;
            }
        } else if (!lastName.equals(other.lastName)) {
            return false;
        }
        if (firstName == null) {
            if (other.firstName != null) {
                return false;
            }
        } else if (!firstName.equals(other.firstName)) {
            return false;
        }
        if (diagnosis == null) {
            if (other.diagnosis != null) {
                return false;
            }
        } else if (!diagnosis.equals(other.diagnosis)) {
            return false;
        }
         if (!admissionDate.equals(other.admissionDate)) {
            return false;
        }
         if (!releaseDate.equals(other.releaseDate)) {
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
        String s = "            Patient ID = " + patientID + "\n" + 
                       "         Last Name = " + lastName + "\n" + 
                       "         First Name = " + firstName + "\n" + 
                       "            Diagnosis = " + diagnosis + "\n" + 
                       "      Admission Date = " + admissionDate + "\n" + 
                       "          Release Date = " + releaseDate + "\n";

        return s;
    }
}

