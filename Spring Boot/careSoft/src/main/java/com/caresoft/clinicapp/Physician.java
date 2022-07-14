package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {

    public Physician(Integer id) {
        super(id);
    }
    //... imports class definition...

    // Inside class:
    private ArrayList<String> patientNotes;

    // TO DO: Constructor that takes an ID
    // TO DO: Implement HIPAACompliantUser!

    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
                "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    // TO DO: Setters & Getters

    @Override
    public boolean assignPin(int pin) {
        if (pin < 4){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        if (getId() == confirmedAuthID){
            return true;
        } else {
            return false;
        }
    }
}
