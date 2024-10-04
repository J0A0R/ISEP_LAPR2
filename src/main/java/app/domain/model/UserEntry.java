package app.domain.model;

import app.controller.VaccinationCenterController;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Class that keeps track of Users last entry to be administered a Vaccine and of the next vaccine administration
 *
 * @author Diogo Carvalho </1200611@isep.ipp.pt>
 */
public class UserEntry implements Serializable {

    /**
     * User associated to the entries
     */
    private User user;

    /**
     * Last time the user was administred a vaccine
     */
    private LocalDateTime lastEntry;

    /**
     * Date and time for the next scheduled vaccine administration
     */
    private LocalDateTime nextEntry;

    /**
     * Center that the entry is registered
     */
    private VaccinationCenter center;


    /**
     * Constructor
     * Instaciates a new UserEntry
     * @param user User to keep track of
     * @param lastEntry last vaccine taken
     * @param nextEntry next vaccine to be taken
     */
    public UserEntry(User user, LocalDateTime lastEntry, LocalDateTime nextEntry, VaccinationCenter vaccinationCenter) {
        this.user = user;
        this.lastEntry = lastEntry;
        this.nextEntry = nextEntry;
        this.center = vaccinationCenter;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLastEntry() {
        return lastEntry;
    }

    public void setLastEntry(LocalDateTime lastEntry) {
        this.lastEntry = lastEntry;
    }

    public LocalDateTime getNextEntry() {
        return nextEntry;
    }

    public void setNextEntry(LocalDateTime nextEntry) {
        this.nextEntry = nextEntry;
    }


    /**
     * Returns the textual description of the user entry.
     *
     * @return the username and last entry
     */
    public void toString1(String vaccinationCenterName) {
        if(vaccinationCenterName.equalsIgnoreCase(center.getName())){
            System.out.println( "UserEntry " +
                "user= " + user +
                ", lastEntry=" + lastEntry);
        }
    }

    /**
     * Checks if a vaccination center exists or not, searching it using a name inserted by the nurse
     * @param vaccinationCenterName - Name inserted by the nurse of the Vaccination Center
     * @return true if vaccination center is found or false if not
     */
    public boolean checkVaccinationCenterExistence(String vaccinationCenterName) {
        boolean check = false;
        if (vaccinationCenterName.equalsIgnoreCase(center.getName())) {
            check = true;
        }
       return check;
    }

    /**
     * Method that returns data from a User entry
     * @return data from the user entry object
     */
    @Override
    public String toString() {
        return "UserEntry{" +
                "user=" + user +
                ", lastEntry=" + lastEntry +
                ", nextEntry=" + nextEntry +
                ", center=" + center +
                '}';
    }
}
