package app.domain.model;

//import jdk.internal.icu.impl.BMPSet;

import app.AgeGroup.AgeGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * The Company dgs.
 */
public class CompanyDGS {

    /**
     * List that keeps Vaccine Type
     */
    private final List<VaccineType> vaccineTypeList;

    /**
     * List vaccines
     */
    private final List<Vaccine> vaccineList;

    /**
     * Instantiates a new Company dgs.
     */
    public CompanyDGS(){
        vaccineTypeList = new ArrayList<>();
        vaccineList = new ArrayList<>();

    }

    /**
     * Create vaccine type.
     *
     * @param code the code of the vaccine type
     * @param designation the designation of the vaccine type
     * @param whoId the who id of the vaccine type
     * @return the new vaccine type
     */
    public VaccineType createVaccineType (String code, String designation, String whoId) {
        return new VaccineType(code, designation, whoId);
    }

    /**
     * Validate vaccine type boolean.
     *
     * @param vt the vaccine type
     * @return true if the vaccine exist in the vaccine list, otherwise it returns false.
     */
    public boolean validateVaccineType (VaccineType vt) {
        boolean validate = false;
        if (vt == null)
            validate = false;
        if (!equalsVaccineType(vaccineTypeList,vt))
            validate = true;
        return validate;
    }

    /**
     * Save vaccine type boolean.
     *
     * @param svt the new vaccine type
     * @return true if the vaccine type does not exist, otherwise it returns false.
     */
    public boolean saveVaccineType (VaccineType svt) {
        if (!validateVaccineType(svt))
            return false;
        return this.vaccineTypeList.add(svt);
    }

    /**
     * List vaccine type.
     */
    public void listVaccineType(){
        for (VaccineType vt : vaccineTypeList) {
            if (vt != null) {
                System.out.println(vt.toString());
                //System.out.println("Code: "+vt.getCode()+" Designation: "+vt.getDesignation()+" WhoID: "+vt.getWhoID());
            }
        }
    }

    /**
     * Checks if the employee already exists in the list.
     *
     * @param lvt list of Vaccine Type
     * @param vt  new Vaccine Type
     * @return true if the Vaccine Type already exists, otherwise it returns false.
     */
    public boolean equalsVaccineType(List<VaccineType> lvt, VaccineType vt){
        boolean equals = false;
        for (VaccineType vts: lvt) {
            if (vts != null){
                if (vts.equals(vt)){
                    equals = true;
                }
            }
        }
        return equals;
    }

    /**
     * Create vaccine
     * @param number the number vaccine Type
     * @param name the name
     * @param brand the brand
     * @param numberDoses the number of doses
     * @param dosages the dosage of the Vaccine
     * @return the vaccine
     */
    public Vaccine createVaccine(int number, String name, String brand, Double numberDoses, String dosages, AgeGroup.age age) {
        return new Vaccine ( vaccineTypeList.get(number) , name, brand, numberDoses, dosages, age);

    }

    /**
     * Validate vaccine
     * @param v the vaccine
     * @return the boolean
     */

    public boolean validateVaccine(Vaccine v) {
        if (v == null)
            return false;
        return ! this.vaccineList.contains(v);
    }


    /**
     * save vaccine
     * @param v vaccicne
     * @return false if vaccine validation is not invalid. True otherwise
     */
    public boolean saveVaccine(Vaccine v) {
        if (!validateVaccine(v))
            return false;
        return this.vaccineList.add(v);
    }

    /**
     * Show the contents of the vaccine arraylist
     */
    public void listVaccine() {
        for (Vaccine v : vaccineList) {
            if (v != null) {
                System.out.println(v.toSVaccine());
            }
        }
    }

    /**
     * Show the contents of the vaccine type arraylist
     */
    public void listVaccinetype2() {
        int i = 1;
        for (VaccineType vt : vaccineTypeList) {
            if (vt != null) {
                System.out.println("-----------------------");
                System.out.println(i+")");
                System.out.println(vt.toString());
                i++;
            }
        }
    }

    /**
     *
     * @return the size of vaccine  type list
     */
    public int numberVaccineType(){
        return vaccineTypeList.size();
    }
}
