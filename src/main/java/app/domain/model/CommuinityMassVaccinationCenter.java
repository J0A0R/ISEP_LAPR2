package app.domain.model;

public class CommuinityMassVaccinationCenter {
    /**
     * the center address
     */
    private String address;

    /**
     * the center name
     */
    private String name;

    /**
     * the center fax
     */
    private int fax;

    /**
     * the center phone
     */
    private int phone;

    /**
     * the center mail
     */
    private String mail;

    /**
     * the center website
     */
    private String website;

    /**
     * the center opening hours
     */
    private int opening_hours;

    /**
     * the center closing hours
     */
    private int closing_hours;

    /**
     * the center slot duration
     */
    private int slot_duration;

    /**
     * the center max number per slot
     */
    private int max_number_per_slot;


    /**
     * Builds an instance of the Type of the Vaccination Center.
     *
     * @param name                the name of the Vaccine Center
     * @param address             the designation of the Vaccine Center
     * @param phone               the phone of the Vaccine Center
     * @param mail                the mail of the Vaccine Center
     * @param fax                 the fax of the Vaccine Center
     * @param website             the website of the Vaccine Center
     * @param opening_hours       the opening_hours of the Vaccine Center
     * @param closing_hours       the closing_hours of the Vaccine Center
     * @param slot_duration       the slot_duration of the Vaccine Center
     * @param max_number_per_slot the max_number_per_slot of the Vaccine Center
     */
    /*public CommuinityMassVaccinationCenter(String name, String address, int phone, String mail, int fax, String website, int opening_hours, int closing_hours, int slot_duration, int max_number_per_slot) {
        super(name, address, phone, mail, fax, website, opening_hours, closing_hours, slot_duration, max_number_per_slot);
        setName(name);
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
        this.fax = fax;
        this.website = website;
        this.opening_hours = opening_hours;
        this.closing_hours = closing_hours;
        this.slot_duration = slot_duration;
        this.max_number_per_slot = max_number_per_slot;
    }*/

    private void setName(String name) {
    }


    /**
     * Gets center name.
     *
     * @return the center name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets center name.
     *
     * @param phone the center adress
     */
    public void setAddress(int phone) {
        if (address.isBlank())
            throw new IllegalArgumentException("User address cannot be null.");
        else
            this.address = address;
    }

    /**
     * Gets center e-mail.
     *
     * @return the center name e-mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * Sets center e-mail.
     *
     * @param mail the center e-mail
     */
    public void setMail(String mail) {
        if (mail.isBlank())
            throw new IllegalArgumentException("Center mail cannot be null.");
        else
            this.mail = mail;
    }

    /**
     * Gets center website.
     *
     * @return the center website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Sets center website.
     *
     * @param website the center website
     */
    public void setWebsite(String website) {
        if (website.isBlank())
            throw new IllegalArgumentException("Center website cannot be null.");
        else
            this.website = website;
    }

    /**
     * Gets center phone.
     *
     * @return the center phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * Sets center phone.
     *
     * @param phone the center phone
     */
    public void setPhone(int phone) {
        String phone2 = String.valueOf(phone);
        if (phone2.isBlank())
            throw new IllegalArgumentException("Center phone number cannot be null.");
        else if (phone2.length() != 9)
            throw new IllegalArgumentException("Phone must have 9 digits.");
        else
            this.phone = phone;
    }

    /**
     * Gets center fax.
     *
     * @return the center fax
     */
    public int getFax() {
        return fax;
    }

    /**
     * Sets center fax.
     *
     * @param fax the center fax
     */
    public void setFax(int fax) {
        String fax2 = String.valueOf(fax);
        if (fax2.isBlank())
            throw new IllegalArgumentException("User ID cannot be null.");
        else
            this.name = name;
    }

    /**
     * Gets center opening hours.
     *
     * @return the center opening hours
     */
    public int getOpening_hours() {
        return opening_hours;
    }

    /**
     * Sets center opening hours.
     *
     * @param opening_hours the center opening hours
     */
    public void setOpening_hours(int opening_hours) {
        String opening_hours2 = String.valueOf(opening_hours);
        if (opening_hours2.isBlank())
            throw new IllegalArgumentException("User ID cannot be null.");
        else
            this.opening_hours = opening_hours;
    }

    /**
     * Gets center slot duration.
     *
     * @return the center slot duration
     */
    public int getSlot_duration() {
        return slot_duration;
    }

    /**
     * Sets center slot duration.
     *
     * @param slot_duration the center name
     * @return
     */
    public void setSlot_duration(int slot_duration) {
        String slot_duration2 = String.valueOf(slot_duration);
        if (slot_duration2.isBlank())
            throw new IllegalArgumentException("Center slot duration cannot be null.");
        else
            this.slot_duration = slot_duration;
    }

    /**
     * Gets center closing hours.
     *
     * @return the center closing hours
     */
    public int getClosing_hours() {
        return closing_hours;
    }

    /**
     * Sets center closing hours.
     *
     * @param closing_hours the center name
     * @return
     */
    public void setClosing_hours(int closing_hours) {
        String closing_hours2 = String.valueOf(closing_hours);
        if (closing_hours2.isBlank())
            throw new IllegalArgumentException("User ID cannot be null.");
        else
            this.closing_hours = closing_hours;
    }

    /**
     * Gets center closing hours.
     *
     * @return the center max number per slot
     */
    public int getMax_number_per_slot() {
        return max_number_per_slot;
    }

    /**
     * Sets center closing hours.
     *
     * @param max_number_per_slot the center max number per slot
     * @return
     */
    public void setMax_number_per_slot(int max_number_per_slot) {
        String max_number_per_slot2 = String.valueOf(max_number_per_slot);
        if (max_number_per_slot2.isBlank())
            throw new IllegalArgumentException("User ID cannot be null.");
        else
            this.max_number_per_slot = max_number_per_slot;
    }



    @Override
    public String toString () {
        return String.format(super.toString() + "\n The Vaccination center name is "+ name +", phone is "+ phone +" and fax is "+ fax +", e-mail is "+ mail +", website is "+ website +", openig hours are "+ opening_hours +", closing hours are "+ closing_hours +", slot duration is "+ slot_duration +", max number per slot is "+ max_number_per_slot);
    }
}

