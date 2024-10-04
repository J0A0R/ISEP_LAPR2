package app.controller;

import app.Vaccines.Vaccines;
import app.domain.model.Company;
import app.domain.model.User;
import app.domain.model.UserEntry;
import app.domain.model.VaccinationCenter;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SpecifyNewVaccineAdministrationControllerTest {

    @Test
    void getListaTelefonica() {
        String expectedValue = "";
        User user2 = new User("João","MASCULINE","10/12/2010","Rua nova",967654321,"joao@gmail.com",123456789,98765431);
        VaccinationCenter vc = new VaccinationCenter("centro1","rua1",123456789,"email1",123456789,"website1",12,13,14,15);
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 06, 24, 14, 33, 48, 123456789);
        LocalDateTime localDateTime2 = LocalDateTime.of(2022, 06, 22, 14, 33, 48, 123456789);
        UserEntry userEntry = new UserEntry(user2,localDateTime2,localDateTime1,vc);
        Company c = new Company();
        c.userEntryList.add(userEntry);
        /*SpecifyNewVaccineAdministrationController specifyNewVaccineAdministrationController = new SpecifyNewVaccineAdministrationController();
        specifyNewVaccineAdministrationController.AddchooseUserAndVaccine(1, Vaccines.vacine.BioNtech,"12AB",2);
        String currentValue = specifyNewVaccineAdministrationController.getListaTelefonica();*/
       // assertEquals(expectedValue,currentValue);
    }

    @Test
    void addchooseUserAndVaccine() {
        boolean expectedValue = true;
        User user2 = new User("João","MASCULINE","10/12/2010","Rua nova",967654321,"joao@gmail.com",123456789,98765431);
        VaccinationCenter vc = new VaccinationCenter("centro1","rua1",123456789,"email1",123456789,"website1",12,13,14,15);
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 06, 24, 14, 33, 48, 123456789);
        LocalDateTime localDateTime2 = LocalDateTime.of(2022, 06, 22, 14, 33, 48, 123456789);
        UserEntry userEntry = new UserEntry(user2,localDateTime2,localDateTime1,vc);
        Company c = new Company();
        c.userEntryList.add(userEntry);
       /* SpecifyNewVaccineAdministrationController specifyNewVaccineAdministrationController = new SpecifyNewVaccineAdministrationController();
        boolean currentValue = specifyNewVaccineAdministrationController.AddchooseUserAndVaccine(0, Vaccines.vacine.BioNtech,"12AB",2);*/
        //assertEquals(expectedValue,currentValue);
    }
}