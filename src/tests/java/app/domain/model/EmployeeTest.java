package app.domain.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    //test the exception
    @Test
    void setName() {
        Employee e = new Employee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                e.setName("");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "Name cannot be null.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    //test the exception
    @Test
    void setAddress() {
        Employee e = new Employee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                e.setAddress("");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "Address cannot be null.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    //test the exception
    @Test
    void setPhoneNumber() {
        Employee e = new Employee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                e.setPhoneNumber(0);
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "Phone number must have 9 digits.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    //test the exception
    @Test
    void setEmail() {
        Employee e = new Employee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                e.setEmail(" ");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "Email cannot be null.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    //test the exception
    @Test
    void setCitizenCardIDNumber() {
        Employee e = new Employee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                e.setCitizenCardIDNumber(" ");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "Citizen Card ID Number cannot be null.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    //test the exception
    @Test
    void setPassword() {
        Employee e = new Employee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                e.setPassword(" ");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "Password cannot be null.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    //test the exception
    @Test
    void setUsername() {
        Employee e = new Employee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                e.setUsername(" ");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "User Name cannot be null.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    //the same object
    @Test
    void testEquals() {
        boolean expectedValue = true;
        Employee e = new Employee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        boolean currentValue = e.equals(e);
        assertEquals(expectedValue,currentValue);
    }

    //null object
    @Test
    void testEqualsNull() {
        boolean expectedValue = false;
        Employee e = new Employee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        Employee e2 = null;
        boolean currentValue = e.equals(e2);
        assertEquals(expectedValue,currentValue);
    }

    //different objects
    @Test
    void testEqualsDifferentObjects() {
        boolean expectedValue = false;
        Employee e = new Employee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        Nurse n = new Nurse("Bruno Ribeiro","Rua Jose Pessoa",969935678,"121212@isep.ipp.pt","124578","pass2","Bruno","121212");
        boolean currentValue = e.equals(n);
        assertEquals(expectedValue,currentValue);
    }

    //Equals attributes
    @Test
    void testEqualsAttributes() {
        boolean expectedValue = true;
        Employee e = new Employee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        Employee e2 = new Employee("Vidall Jorge","Rua Jose Pessoa",969935678,"121485@isep.ipp.pt","124578","pass4","Jorge");
        boolean currentValue = e.equals(e2);
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void testEqualsEqualAttributes() {
        boolean expectedValue = true;
        Employee e = new Employee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        Employee e2 = new Employee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        boolean currentValue = e.equals(e2);
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void testToString() {
        String expectedValue = "Employee\n" +
                "-name: Jorge Vidall\n" +
                "-address: Rua Jose Pessoa\n" +
                "-phone number: 969935678\n" +
                "-email: 121223@isep.ipp.pt\n" +
                "-citizenCardIDNumber: 124578\n" +
                "-password: pass3\n" +
                "-username: Jorge\n";
        Employee e = new Employee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        String currentValue = e.toString();
        assertEquals(expectedValue,currentValue);
    }
}