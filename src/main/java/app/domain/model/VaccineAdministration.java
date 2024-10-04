package app.domain.model;

import app.Vaccines.Vaccines;
import app.controller.App;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VaccineAdministration implements Serializable {

    /**
     * Adverse Reactions
     */
    private String adverseReactions;

    /**
     * Vaccine
     */
    private Vaccines.vacine vacine;

    /**
     * User waiting to take the vaccine
     */
    private UserEntry user;

    /**
     * vaccine lot
     */
    private String lot;

    /**
     * vaccine dose
     */
    private int dose;
    public List<VaccineAdministration> vaccineAdministrations;
    Company company;
    /**
     * Builds an instance of the administration of a vaccine to SNS user receiving vaccine, SNS user and vaccine lot.
     * @param vacine vaccine to be administered
     * @param user user who takes the vaccine
     * @param lot vaccine lot
     */
    public VaccineAdministration(Vaccines.vacine vacine, UserEntry user, String lot, int dose) {
        this.vacine = vacine;
        this.user = user;
        this.dose = dose;
        setLot(lot);
     //   this.adverseReactions = null;
    }

    /*public VaccineAdministration(){
        company = App.getInstance().getCompany();
       vaccineAdministrations = new ArrayList<>(company.vaccineAdministrationsList);
    }*/

    public VaccineAdministration(Vaccines.vacine vacine, UserEntry user, String lot, int dose, String adverseReactions) {
        this.vacine = vacine;
        this.user = user;
        this.dose = dose;
        setLot(lot);
        setAdverseReactions(adverseReactions);
    }

    /**
     * Modify the vaccine lot and tested the credibility.
     * @param lot vaccine lot
     */
    public void setLot(String lot) {
        if (lot.isBlank())
            throw new IllegalArgumentException("Lot cannot be null.");
        else
            this.lot = lot;
    }

    /**
     * Method that searches for an SNS Number
     * @return the sns number
     */
    public int getSnsUserNumber(){
        return user.getUser().getSnsUserNumber();
    }

    /**
     * Method that sets the Adverse Reaction from what the nurse wrote
     * @param adverseReactions
     */
    public void setAdverseReactions(String adverseReactions){
        this.adverseReactions = adverseReactions;
    }


    /**
     * Returns the textual description of the vaccine administration.
     * @return Vaccine, user and lot
     */
    @Override
    public String toString() {
        return String.format("Vaccine Administration: " + "vacine: " + vacine + " User: " + user + " Lot: " + lot);
    }

    public String toString1() {
        return String.format("Vaccine Administration: " + "vacine: " + vacine + " User: " + user + " Lot: " + lot + " Dose: " + dose + " Adverse Reactions: "+adverseReactions);
    }
}
