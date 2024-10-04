package app.controller;

import app.AgeGroup.AgeGroup;
import app.domain.model.CompanyDGS;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecifyNewVaccineControllerTest {

    @Test
    void createVaccineType() {
        boolean expectedValue = true;
        SpecifyNewVaccineController vt = new SpecifyNewVaccineController();
        boolean currentValue =vt.createVaccineType("123456","Apply to fight covid","covid19");
        vt.listVaccineType();
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void saveVaccineType() {
        boolean expectedValue = true;
        SpecifyNewVaccineController vt = new SpecifyNewVaccineController();
        SpecifyNewVaccineController vt1 = new SpecifyNewVaccineController(new CompanyDGS());
        vt.createVaccineType("123456","Apply to fight covid","covid19");
        boolean currentValue = vt.saveVaccineType();
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void createVaccine(){
        boolean expectedValue = true;
        SpecifyNewVaccineController vt = new SpecifyNewVaccineController();
        vt.createVaccineType("123457","Apply to fight covid","covid19");
        vt.saveVaccineType();
        vt.listVaccineType2();
        boolean currentValue =vt.createVaccine(1,"covid19","covid19",12.0,"10ml", AgeGroup.age.ADULT);
        vt.saveVaccine();
        vt.listVaccine();
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void numberVaccineType(){
        int expectedValue = 1;
        SpecifyNewVaccineController vt = new SpecifyNewVaccineController();
        vt.createVaccineType("123457","Apply to fight covid","covid19");
        vt.saveVaccineType();
        vt.listVaccineType2();
        vt.createVaccine(1,"covid19","covid19",12.0,"10ml", AgeGroup.age.ADULT);
        vt.saveVaccine();
        vt.listVaccine();
        int currentValue = vt.numberVaccineType();
        assertEquals(expectedValue,currentValue);
    }
}