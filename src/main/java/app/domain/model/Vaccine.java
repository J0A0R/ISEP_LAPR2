package app.domain.model;

import app.AgeGroup.AgeGroup;

/**
 * Represents a Vaccine through your name and brand.
 */
public class Vaccine {
    /**
     * The Vaccine name.
     */
    private String name;

    /**
     * The Vaccine Type brand.
     */
    private String brand;

    /**
     * Number of vaccine doses
     */
    private double numberDoses;

    /**
     * Vaccine dosage
     */
    private String dosages;

    /**
     * Age
     */
    private AgeGroup.age age;

    /**
     * Vaccine Type
     */

    private VaccineType vt;


    /**
     * Builds an instance of the Vaccine receiving the name and brand.
     * @param code the code of the Vaccine
     * @param designation the designation of the Vaccine
     * @param WhoID the WhoID of the Vaccine
     * @param name the name of the Vaccine
     * @param brand the brand of the Vaccine
     */
    public Vaccine(String code, String designation, String WhoID , String name, String brand) {
        setName(name);
        setBrand(brand);
        this.name = name;
        this.brand = brand;
    }


    /**
     * Modify the vaccine name and tested the credibility.
     * @param name the new vaccine whoID
     */
    public void setName(String name) {
        if (name.isBlank())
            throw new IllegalArgumentException("Name cannot be null.");
        else
            this.name = name;
    }

    /**
     * Modify the vaccine brand and tested the credibility.
     * @param brand the new vaccine brand
     */
    public void setBrand(String brand) {
        if (brand.isBlank())
            throw new IllegalArgumentException("Brand cannot be null.");
        else
            this.brand = brand;
    }

    /**
     * Returns the textual description of the vaccine.
     * @return Characteristics of the vaccine
     */
    @Override
    public String toString() {
        return String.format("The name of the vaccine is " +name+ "and your brand is "+brand +". ");
    }
    /**
     * Builds an instance of the Vaccine receiving the name, brand, number of doses and dosage.
     * @param vt The vaccine type
     * @param name the name of the Vaccine
     * @param brand the brand of the Vaccine
     * @param numberDoses the number of doses
     * @param dosages the dosage of the Vaccine
     */
    public Vaccine ( VaccineType vt ,String name, String brand, Double numberDoses, String dosages, AgeGroup.age age) {
        this.vt = vt;
        setName(name);
        setBrand(brand);
        setDosages(dosages);
        setNumberDoses(numberDoses);
        this.age =age;
    }

    /**
     * Modify the dosage and tested the credibility
     * @param dosages the dosage of the Vaccine (ml)
     */

    public void setDosages(String dosages) {
        if (dosages.isBlank())
            throw new IllegalArgumentException("Dosages cannot be null.");
        else
            this.dosages = dosages;
    }

    /**
     * Modify the number of doses and tested the credibility
     * @param numberDoses the number of the Vaccine (1,2,3,...)
     */

    public void setNumberDoses(Double numberDoses){
        if (numberDoses<=0){
            throw new IllegalArgumentException("Invalid number of doses.");
        }else
            this.numberDoses = numberDoses;
    }

    /**
     * Returns the textual description of the vaccine.
     * @return attributes of vaccine
     */
    public String toSVaccine(){
        return String.format("The name of the vaccine is " +name+ " and your brand is "+brand +". Age group "+ age + ". Number of doses are " + numberDoses +" and dosage is "+ dosages + ". " + vt.toString());

    }
}
