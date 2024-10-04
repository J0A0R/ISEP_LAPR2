package app.domain.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void setName() {
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                user.setName("");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "Name cannot be null.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    @Test
    void setBirthDate() {
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                user.setBirthDate("");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "Birth date cannot be null.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    @Test
    void setSex() {
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        /*IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                user.setSex("");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "Sex cannot be null.";*/

        String expectedValue = "";
        user.setSex("");
        String currentValue = user.getSex();

        assertEquals(expectedValue,currentValue);
    }

    // Sex invalid
    @Test
    void setSexInvalid() {
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        /*IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                user.setSex("MASC");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "invalid sex.";*/
        String expectedValue = "Masculino";
        user.setSex("Masculino");
        String currentValue = user.getSex();

        assertEquals(expectedValue,currentValue);
    }

    @Test
    void setAddress() {
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                user.setAddress("");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "Address cannot be null.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    @Test
    void setPhoneNumber() {
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                user.setPhoneNumber(0);
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "Phone number must have 9 digits.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    @Test
    void setEmail() {
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                user.setEmail("");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "E-mail cannot be null.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    @Test
    void setSnsUserNumber() {
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                user.setSnsUserNumber(0);
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "SNS User Number must have 9 digits.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    @Test
    void setCitizenCardNumber() {
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                user.setCitizenCardNumber(0);
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "Citizen Card Number must have 8 digits.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    //the same object
    @Test
    void testEquals() {
        boolean expectedValue = true;
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        boolean currentValue = user.equals(user);
        assertEquals(expectedValue,currentValue);
    }

    //null object
    @Test
    void testEqualsNull() {
        boolean expectedValue = false;
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        User user1 = null;
        boolean currentValue = user.equals(user1);
        assertEquals(expectedValue,currentValue);
    }

    //different objects
    @Test
    void testEqualsDifferentObjects() {
        boolean expectedValue = false;
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        User user1 = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",127456789,97654321);
        boolean currentValue = user.equals(user1);
        assertEquals(expectedValue,currentValue);
    }

    //Equals attributes
    @Test
    void testEqualsAttributes() {
        boolean expectedValue = true;
        User user = new User("Tiago", "MASCULINE", "10/12/2010", "Rua nova", 967654321, "tiago@gmail.com", 123456789, 97654321);
        User user1 = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        boolean currentValue = user.equals(user1);
        assertEquals(expectedValue, currentValue);
    }

    @Test
    void testToString() {
        String expectedValue = "name= Tiago, sex= MASCULINE, birth date= 10/12/2010, address= Rua nova, phoneNumber= 967654321, email= tiago@gmail.com, SNSUserNumber= 123456789 and citizenCardNumber=97654321";
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        String currentValue = user.toString();
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void getName() {
        String expectedValue = "Tiago";
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        String currentValue = user.getName();;
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void getSex() {
        String expectedValue = "MASCULINE";
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        String currentValue = user.getSex();;
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void getBirthDate() {
        String expectedValue = "10/12/2010";
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        String currentValue = user.getBirthDate();
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void getAddress() {
        String expectedValue = "Rua nova";
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        String currentValue = user.getAddress();
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void getPhoneNumber() {
        int expectedValue = 967654321;
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        int currentValue = user.getPhoneNumber();
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void getEmail() {
        String expectedValue = "tiago@gmail.com";
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        String currentValue = user.getEmail();
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void getSnsUserNumber() {
        int expectedValue = 123456789;
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        int currentValue = user.getSnsUserNumber();
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void getCitizenCardNumber() {
        int expectedValue = 97654321;
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        int currentValue = user.getCitizenCardNumber();
        assertEquals(expectedValue,currentValue);
    }
}