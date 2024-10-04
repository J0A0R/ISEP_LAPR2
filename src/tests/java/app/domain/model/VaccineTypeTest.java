package app.domain.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class VaccineTypeTest {

    @Test
    void setDesignation() {
        VaccineType vt = new VaccineType("123456","Apply to fight covid","covid19");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                vt.setDesignation("");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "Designation cannot be null.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    @Test
    void setWhoID() {
        VaccineType vt = new VaccineType("123456","Apply to fight covid","covid19");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                vt.setWhoID("");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "WhowID cannot be null.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    //Code less than four
    @Test
    void setCodeLessThanFour() {
        VaccineType vt = new VaccineType("123456","Apply to fight covid","covid19");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                vt.setCode("123");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "Code must have 4 to 8 chars.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    // Code more than eight
    @Test
    void setCodeMoreThanEight() {
        VaccineType vt = new VaccineType("123456","Apply to fight covid","covid19");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                vt.setCode("123456789");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "Code must have 4 to 8 chars.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    // code null
    @Test
    void setCodeNull() {
        VaccineType vt = new VaccineType("123456","Apply to fight covid","covid19");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                vt.setCode("");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "Code cannot be null.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    @Test
    void getDesignation() {
        String expectedValue = "Apply to fight covid";
        VaccineType vt1 = new VaccineType("code1","Apply to fight covid","covid19");
        String obtainedValue = vt1.getDesignation();
        assertEquals(expectedValue,obtainedValue);
    }

    @Test
    void getWhoID() {
        String expectedValue = "covid19";
        VaccineType vt1 = new VaccineType("code1","Apply to fight covid","covid19");
        String obtainedValue = vt1.getWhoID();
        assertEquals(expectedValue,obtainedValue);
    }

    @Test
    void getCode() {
        String expectedValue = "code1";
        VaccineType vt = new VaccineType("code1","Apply to fight covid","covid19");
        String obtainedValue = vt.getCode();
        assertEquals(expectedValue,obtainedValue);
    }

    //the same object
    @Test
    void testEquals() {
        boolean expectedValue = true;
        VaccineType vt1 = new VaccineType("code1","Apply to fight covid","covid19");
        boolean currentValue = vt1.equals(vt1);
        assertEquals(expectedValue,currentValue);
    }

    //null object
    @Test
    void testEqualsNull() {
        boolean expectedValue = false;
        VaccineType vt = new VaccineType("code1","Apply to fight covid","covid19");
        VaccineType vt1 = null;
        boolean currentValue = vt.equals(vt1);
        assertEquals(expectedValue,currentValue);
    }

    //different objects
    @Test
    void testEqualsDifferentObjects() {
        boolean expectedValue = false;
        Vaccine v = new Vaccine("123456","Apply to fight covid","covid19","COVID-19 Vaccine Janssen","Janssen");
        VaccineType vt = new VaccineType("code1","Apply to fight covid","covid19");
        boolean currentValue = v.equals(vt);
        assertEquals(expectedValue,currentValue);
    }

    //Equals attributes
    @Test
    void testEqualsAttributes() {
        boolean expectedValue = true;
        VaccineType vt = new VaccineType("code1","Apply to fight covid","covid19");
        VaccineType vt1 = new VaccineType("code1","Apply covid","covid19");
        boolean currentValue = vt.equals(vt1);
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void testToString() {
        String expectedValue = "Your designation is Apply to fight covid, WhoID is covid19 and code is code1";
        VaccineType vt = new VaccineType("code1","Apply to fight covid","covid19");
        String currentValue = vt.toString();
        assertEquals(expectedValue,currentValue);
    }
}