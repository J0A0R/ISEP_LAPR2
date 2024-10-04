package app.domain.model;

import app.AgeGroup.AgeGroup;
import app.controller.SpecifyNewVaccineController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class VaccineTest {

    @Test
    void setName() {
        Vaccine v = new Vaccine("123456","Apply to fight covid","covid19","COVID-19 Vaccine Janssen","Janssen");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                v.setName("");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "Name cannot be null.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    @Test
    void setBrand() {
        Vaccine v = new Vaccine("123456","Apply to fight covid","covid19","COVID-19 Vaccine Janssen","Janssen");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                v.setBrand("");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "Brand cannot be null.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    @Test
    void testToString() {
        String expectedValue = "The name of the vaccine is COVID-19 Vaccine Janssenand your brand is Janssen. ";
        Vaccine v = new Vaccine("123456","Apply to fight covid","covid19","COVID-19 Vaccine Janssen","Janssen");
        String currentValue = v.toString();
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void setDosages(){
        VaccineType vt = new VaccineType("code1","Apply to fight covid","covid19");
        Vaccine v = new Vaccine(vt,"covid19","covid19",12.0,"10ml", AgeGroup.age.ADULT);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                v.setDosages("");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "Dosages cannot be null.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    @Test
    void setNumberDoses(){
        VaccineType vt = new VaccineType("code1","Apply to fight covid","covid19");
        Vaccine v = new Vaccine(vt,"covid19","covid19",12.0,"10ml", AgeGroup.age.YOUNG);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                v.setNumberDoses(0.0);
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "Invalid number of doses.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    @Test
     void toSVaccine(){
        String expectedValue = "The name of the vaccine is covid19 and your brand is covid19. Age group CHILD. Number of doses are 12.0 and dosage is 10ml. Your designation is Apply to fight covid, WhoID is covid19 and code is code1";
        VaccineType vt = new VaccineType("code1","Apply to fight covid","covid19");
        Vaccine v = new Vaccine(vt,"covid19","covid19",12.0,"10ml",AgeGroup.age.CHILD);
        String currentValue = v.toSVaccine();
        assertEquals(expectedValue,currentValue);
    }


}