package app.domain.model;

/**
 * Represents a Vaccine Type through your code, designation and WhoID.
 */
public class VaccineType {

    /**
     * The Vaccine Type code.
     */
    private String code;

    /**
     * The Vaccine Type designation.
     */
    private String designation;

    /**
     * The Vaccine Type WhowID.
     */
    private String whoID;

    /**
     * Builds an instance of the Type Vaccine receiving the code, designation and WhowID.
     * @param code the code of the Type Vaccine
     * @param designation the designation of the Type Vaccine
     * @param whoID the WhoID of the Type Vaccine
     */

    public VaccineType(String code, String designation, String whoID) {
        setCode(code);
        setDesignation(designation);
        setWhoID(whoID);
    }

    /**
     * Modify the vaccine designation and tested the credibility.
     * @param designation the new vaccine designation
     */
    public void setDesignation(String designation) {
        if (designation.isBlank())
            throw new IllegalArgumentException("Designation cannot be null.");
        else
            this.designation = designation;
    }

    /**
     * Modify the vaccine whoID and tested the credibility.
     * @param whoID the new vaccine whoID
     */
    public void setWhoID(String whoID) {
        if (whoID.isBlank())
            throw new IllegalArgumentException("WhowID cannot be null.");
        else
            this.whoID = whoID;
    }

    /**
     * Modify the vaccine code and tested the credibility.
     * @param code the new vaccine code
     */
    public void setCode(String code) {
        if (code.isBlank())
            throw new IllegalArgumentException("Code cannot be null.");
        else if ( (code.length() < 4) || (code.length() > 8))
            throw new IllegalArgumentException("Code must have 4 to 8 chars.");
        else
            this.code = code;
    }

    /**
     * Gets designation.
     *
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Gets whoId.
     *
     * @return the whoId
     */
    public String getWhoID() {
        return whoID;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Compare two vaccine type objects
     * @param o another object
     * @return False if object O is null or if class type is different. Otherwise return true.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VaccineType that = (VaccineType) o;
        return code.equals(that.code) && whoID.equals(that.whoID);
    }

    /**
     * Returns the textual description of the vaccine
     * @return Characteristics, designation and whoID of the vaccine
     */
    @Override
    public String toString(){
        return String.format("Your designation is "+designation +", WhoID is "+ whoID +" and code is "+code);
    }

}
