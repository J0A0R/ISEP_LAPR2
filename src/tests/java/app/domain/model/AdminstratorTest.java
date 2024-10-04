package app.domain.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AdminstratorTest {

    //test the exception
    @Test
    void setUserID() {
        Adminstrator a = new Adminstrator("Bruno Ribeiro","Rua Jose Pessoa",969935678,"121212@isep.ipp.pt","124578","pass2","Bruno","121212");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                a.setUserID("");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "User ID cannot be null.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    @Test
    void testToString() {
        String expectedValue = "Employee\n" +
                "-name: Bruno Ribeiro\n" +
                "-address: Rua Jose Pessoa\n" +
                "-phone number: 969935678\n" +
                "-email: 121212@isep.ipp.pt\n" +
                "-citizenCardIDNumber: 124578\n" +
                "-password: pass2\n" +
                "-username: Bruno\n" +
                "\n" +
                " Your UserID is 121212 and has a password that is pass2";
        Adminstrator a = new Adminstrator("Bruno Ribeiro","Rua Jose Pessoa",969935678,"121212@isep.ipp.pt","124578","pass2","Bruno","121212");
        String currentValue = a.toString();
        assertEquals(expectedValue,currentValue);
    }
}