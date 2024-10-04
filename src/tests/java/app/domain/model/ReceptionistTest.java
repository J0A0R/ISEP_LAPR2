package app.domain.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ReceptionistTest {

    @Test
    void setUserID() {
        Receptionist r = new Receptionist("Óscar Ribeiro","Rua Jose Pessoa",969935678,"121212@isep.ipp.pt","124578","pass2","Óscar","121212");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                r.setUserID("");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "User ID cannot be null.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    @Test
    void testToString() {
        String expectedValue = "Employee\n" +
                "-name: Óscar Ribeiro\n" +
                "-address: Rua Jose Pessoa\n" +
                "-phone number: 969935678\n" +
                "-email: 121212@isep.ipp.pt\n" +
                "-citizenCardIDNumber: 124578\n" +
                "-password: pass2\n" +
                "-username: Óscar\n" +
                "\n" +
                " Your UserID is 121212 and has a password that is pass2";
        Receptionist r = new Receptionist("Óscar Ribeiro","Rua Jose Pessoa",969935678,"121212@isep.ipp.pt","124578","pass2","Óscar","121212");
        String currentValue = r.toString();
        assertEquals(expectedValue,currentValue);
    }
}