package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin{

    public AdminUser(Integer id, String companion) {
        super(id);
    }

    //... imports class definition...

    // Inside class:
    private Integer employeeID;
    private String role;
    public ArrayList<String> securityIncidents;

    // TO DO: Implement a constructor that takes an ID and a role
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!

    public void newIncident(String notes) {
        String report = String.format(
                "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n",
                new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
                "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n",
                new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

    // TO DO: Setters & Getters

    @Override
    public ArrayList<String> reportSecurityIncidents() {
        return null;
    }

    @Override
    public boolean assignPin(int pin) {
        if (pin < 6){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        if (getId() == confirmedAuthID){
            return true;
        } else {
            authIncident();
            return false;
        }
    }
}
