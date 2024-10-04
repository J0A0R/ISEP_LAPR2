package app.domain.model;

import app.AgeGroup.AgeGroup;
import app.Vaccines.Vaccines;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class VaccineAdministrationTest {

    @Test
    void setLot() {
        VaccineType vt = new VaccineType("code1","Apply to fight covid","covid19");
        Vaccine v = new Vaccine(vt,"Covid", "Janssen", 2.0,"12ml", AgeGroup.age.ADULT);
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 06, 01, 14, 33, 48, 123456789);
        LocalDateTime localDateTime2 = LocalDateTime.of(2022, 06, 03, 14, 33, 48, 123456789);
        VaccinationCenter vaccinationCenter = new VaccinationCenter("Centro1", "Rua nova",123456789,"centro1@gmail.com",123456789,"centro1.com",8,18,5,4);
        UserEntry userEntry = new UserEntry(user, localDateTime1,localDateTime2,vaccinationCenter);
        VaccineAdministration vaccineAdministration = new VaccineAdministration(Vaccines.vacine.BioNtech,userEntry,"12CD1-12",2);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                // The method to test expected to generate an exception
                vaccineAdministration.setLot("");
            }
        });
        String exceptionMessage = exception.getMessage();
        String expectedMessage = "Lot cannot be null.";

        assertEquals(expectedMessage, exceptionMessage);
    }

    @Test
    void testToString() {
        String expectedValue = "Vaccine Administration: vacine: BioNtech User: UserEntry{user=name= Tiago, sex= MASCULINE, birth date= 10/12/2010, address= Rua nova, phoneNumber= 967654321, email= tiago@gmail.com, SNSUserNumber= 123456789 and citizenCardNumber=97654321, lastEntry=2022-06-01T14:33:48.123456789, nextEntry=2022-06-03T14:33:48.123456789, center=The Vaccination center name is Centro1, phone is 123456789 and fax is 123456789, e-mail is centro1@gmail.com, website is centro1.com, opening hours are 8, closing hours are 18, slot duration is 5, max number per slot is 4} Lot: 12CD1-12";
        VaccineType vt = new VaccineType("code1","Apply to fight covid","covid19");
        Vaccine v = new Vaccine(vt,"Covid", "Janssen", 2.0,"12ml", AgeGroup.age.ADULT);
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,97654321);
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 06, 01, 14, 33, 48, 123456789);
        LocalDateTime localDateTime2 = LocalDateTime.of(2022, 06, 03, 14, 33, 48, 123456789);
        VaccinationCenter vaccinationCenter = new VaccinationCenter("Centro1", "Rua nova",123456789,"centro1@gmail.com",123456789,"centro1.com",8,18,5,4);
        UserEntry userEntry = new UserEntry(user, localDateTime1,localDateTime2,vaccinationCenter);
        VaccineAdministration vaccineAdministration = new VaccineAdministration(Vaccines.vacine.BioNtech,userEntry,"12CD1-12",2);
        String currentValue = vaccineAdministration.toString();
        assertEquals(expectedValue,currentValue);
    }
}