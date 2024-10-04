package app.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VaccinationCenter implements Serializable {
    /**
     * The Vaccine Center name.
     */
    private String name;

    /**
     * The Vaccine Center phone.
     */
    private int phone;

    /**
     * The Vaccine Center address.
     */
    private String address;

    /**
     * The Vaccine Center e-mail.
     */
    private String mail;

    /**
     * The Vaccine Center fax.
     */
    private int fax;

    /**
     * The Vaccine Center website.
     */
    private String website;

    /**
     * The Vaccine Center opening_hours.
     */
    private int opening_hours;

    /**
     * The Vaccine Center closing_hours.
     */
    private int closing_hours;

    /**
     * The Vaccine Center slot_duration.
     */
    private int slot_duration;

    /**
     * The Vaccine Center max_number_per_slot.
     */
    private int max_number_per_slot;

    /**
     * List of users on the waiting line for given center
     */
    private List<User> waiting_line;


    /**
     * Builds an instance of the Type Vaccine receiving the code, designation and WhowID.
     * @param name the name of the Vaccine Center
     * @param address the designation of the Vaccine Center
     * @param phone the phone of the Vaccine Center
     * @param mail the mail of the Vaccine Center
     * @param fax the fax of the Vaccine Center
     * @param website the website of the Vaccine Center
     * @param opening_hours the opening_hours of the Vaccine Center
     * @param closing_hours the closing_hours of the Vaccine Center
     * @param slot_duration the slot_duration of the Vaccine Center
     * @param max_number_per_slot the max_number_per_slot of the Vaccine Center
     */

    public VaccinationCenter(String name, String address, int phone, String mail, int fax, String website, int opening_hours, int closing_hours, int slot_duration, int max_number_per_slot) {
        setName(name);
        setAddress(address);
        setPhone(phone);
        setMail(mail);
        setFax(fax);
        setWebsite(website);
        setOpening_hours(opening_hours);
        setClosing_hours(closing_hours);
        setSlot_duration(slot_duration);
        setMax_number_per_slot(max_number_per_slot);
        this.waiting_line = new ArrayList<>();
    }

    /**
     * Modify the vaccine center name and tested the credibility.
     * @param name the new vaccine center name
     */
    public void setName(String name) {
        if (name.isBlank())
            throw new IllegalArgumentException("Name cannot be null.");
        else
            this.name = name;
    }

    /**
     * Modify the vaccine center address and tested the credibility.
     * @param address the new vaccine center address
     */
    public void setAddress(String address) {
        if (address.isBlank())
            throw new IllegalArgumentException("Address cannot be null.");
        else
            this.address = address;
    }

    /**
     * Modify the vaccine center phone and tested the credibility.
     * @param phone the new vaccine center phone number
     */
    public void setPhone(int phone) {
        String phone2 = String.valueOf(phone);
        if (phone2.isBlank())
            throw new IllegalArgumentException("Phone cannot be null.");
        else if (phone2.length() != 9)
            throw new IllegalArgumentException("Phone must have 9 digits.");
        else
            this.phone = phone;
    }

    /**
     * Modify the vaccine center mail and tested the credibility.
     * @param mail the new vaccine center e-mail
     */
    public void setMail(String mail) {
        if (mail.isBlank())
            throw new IllegalArgumentException("Code cannot be null.");
        else
            this.mail = mail;
    }

    /**
     * Modify the vaccine center fax and tested the credibility.
     * @param fax the new vaccine center fax
     */
    public void setFax(int fax) {
        String fax2 = String.valueOf(fax);
        if (fax2.isBlank())
            throw new IllegalArgumentException("Fax cannot be null.");
        else
            this.fax = fax;
    }

    /**
     * Modify the vaccine center website and tested the credibility.
     * @param website the new vaccine center website
     */
    public void setWebsite(String website) {
        if (website.isBlank())
            throw new IllegalArgumentException("website cannot be null.");
        else
            this.website = website;
    }

    /**
     * Modify the vaccine center opening_hours and tested the credibility.
     * @param opening_hours the new vaccine center opening hours
     */
    public void setOpening_hours(int opening_hours) {
        String opening_hours2 = String.valueOf(opening_hours);
        if (opening_hours2.isBlank())
            throw new IllegalArgumentException("Opening hours cannot be null.");
        else
            this.opening_hours = opening_hours;
    }

    /**
     * Modify the vaccine center closing_hours  and tested the credibility.
     * @param closing_hours the new vaccine center closing hours
     * @return
     */
    public void setClosing_hours(int closing_hours) {
        String closing_hours2 = String.valueOf(closing_hours);
        if (closing_hours2.isBlank())
            throw new IllegalArgumentException("Closing hours cannot be null.");
        else
            this.closing_hours = closing_hours;
    }

    /**
     * Modify the vaccine center slot_duration and tested the credibility.
     * @param slot_duration the new vaccine center slot duration
     */
    public void setSlot_duration(int slot_duration) {
        String slot_duration2 = String.valueOf(slot_duration);
        if (slot_duration2.isBlank())
            throw new IllegalArgumentException("slot duration cannot be null.");
        else
            this.slot_duration = slot_duration;
    }

    /**
     * Modify the vaccine center Max_number_per_slot and tested the credibility.
     * @param max_number_per_slot the new vaccine center max number per slot
     */
    public void setMax_number_per_slot(int max_number_per_slot) {
        String max_number_per_slot2 = String.valueOf(max_number_per_slot);
        if (max_number_per_slot2.isBlank())
            throw new IllegalArgumentException("Code cannot be null.");
        else
            this.max_number_per_slot = max_number_per_slot;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress2() {
        return address;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * Gets mail.
     *
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * Gets fax.
     *
     * @return the fax
     */
    public int getFax() {
        return fax;
    }

    /**
     * Gets website.
     *
     * @return website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Gets opening_hours.
     *
     * @return the opening_hours
     */
    public int getOpening_hours() {
        return opening_hours;
    }

    /**
     * Gets closing_hours.
     *
     * @return the closing_hours
     */
    public int getClosing_hours() {
        return closing_hours;
    }

    /**
     * Gets slot_duration.
     *
     * @return the slot_duration
     */
    public int getSlot_duration() {
        return slot_duration;
    }

    /**
     * Gets max_number_per_slot.
     *
     * @return the max_number_per_slot
     */
    public int getMax_number_per_slot() {
        return max_number_per_slot;
    }

    /**
     * Gets waiting_line
     * @return waiting_line
     */
    public List<User> getWaiting_line() {
        return waiting_line;
    }

    /**
     * sets the wating_line
     * @param waiting_line
     */
    public void setWaiting_line(List<User> waiting_line) {
        this.waiting_line = waiting_line;
    }

    /**
     * Compare two vaccine centers
     * @param o another object
     * @return False if object O is null or if class type is different. Otherwise return true.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VaccinationCenter that = (VaccinationCenter) o;
        return name.equals(that.name) && address.equals(that.address);
    }

    /**
     * Returns the textual description of the vaccine center
     * @return Characteristics, designation and whoID of the vaccine
     */
    @Override
    public String toString(){
        return String.format("The Vaccination center name is "+ name +", phone is "+ phone +" and fax is "+ fax +", e-mail is "+ mail +", website is "+ website +", opening hours are "+ opening_hours +", closing hours are "+ closing_hours +", slot duration is "+ slot_duration +", max number per slot is "+ max_number_per_slot);
    }
}

















