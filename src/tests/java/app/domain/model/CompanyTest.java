package app.domain.model;

import app.Vaccines.Vaccines;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    @Test
    void validateEmployee() {
        boolean expectedValue = false;
        Company c = new Company();
        Employee e = new Employee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        Employee e2 = new Employee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        c.createEmployee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        c.saveEmployee(e);
        c.createEmployee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        boolean currentValue = c.validateEmployee(e2);
        c.listEmployee();
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void validateEmployeeN() {
        boolean expectedValue = true;
        Company c = new Company();
        Employee e = new Employee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        Employee e2 = null;
        c.createEmployee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        c.saveEmployee(e);
        boolean currentValue = c.validateEmployee(e2);
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void saveEmployee() {
        boolean expectedValue = false;
        Company c = new Company();
        Employee e = new Employee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        c.createEmployee("Jorge Vidall","Rua Jose Pessoa",969935678,"121223@isep.ipp.pt","124578","pass3","Jorge");
        c.saveEmployee(e);
        boolean currentValue = c.saveEmployee(e);
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void orderUserEntryList() {
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,98765431);
        User user1 = new User("Francisco","MASCULINE","10/12/2010","Rua nova",967654321,"francisco@gmail.com",123456789,98765431);
        User user2 = new User("João","MASCULINE","10/12/2010","Rua nova",967654321,"joao@gmail.com",123456789,98765431);
        VaccinationCenter vc = new VaccinationCenter("centro1","rua1",123456789,"email1",123456789,"website1",12,13,14,15);
        VaccinationCenter vc1 = new VaccinationCenter("centro2","rua2",987654321,"email2",123456789,"website2",12,13,14,15);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 06, 24, 14, 33, 48, 123456789);
        LocalDateTime localDateTime2 = LocalDateTime.of(2021, 04, 24, 14, 33, 48, 123456789);
        LocalDateTime localDateTime3 = LocalDateTime.of(2021, 04, 28, 14, 33, 48, 123456789);
        LocalDateTime localDateTime4 = LocalDateTime.of(2021, 04, 24, 13, 33, 48, 123456789);
        LocalDateTime localDateTime5 = LocalDateTime.of(2021, 04, 27, 14, 33, 48, 123456789);

        UserEntry userEntry = new UserEntry(user2,now,localDateTime1,vc);
        UserEntry userEntry1 = new UserEntry(user1,localDateTime2,localDateTime3,vc);
        UserEntry userEntry2 = new UserEntry(user,localDateTime4,localDateTime5,vc1);

        Company c = new Company();

        c.userEntryList.add(userEntry);
        c.userEntryList.add(userEntry1);
        c.userEntryList.add(userEntry2);
        c.orderUserEntryList("centro1");
    }

    @Test
    void printVaccinationCenterList() {
        VaccinationCenter vc = new VaccinationCenter("centro 1","Rua Velha",912395145,"centro1@gmail.com",211222333,"www.centro1.com",8,20,15,5);
        String expectedstr = "-----------------------\n" +
                "1)\nThe Vaccination center name is centro 1, phone is 912395145 and fax is 211222333, e-mail is centro1@gmail.com, website is www.centro1.com, opening hours are 8, closing hours are 20, slot duration is 15, max number per slot is 5\n";

        Company c = new Company();
        c.saveVaccinationCenter(vc);
        c.printVaccinationCenterList();
    }

    @Test
    void checkVaccinationCenterExistence(){
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,98765431);
        User user2 = new User("João","MASCULINE","10/12/2010","Rua nova",967654321,"joao@gmail.com",123456789,98765431);
        VaccinationCenter vc = new VaccinationCenter("centro1","rua1",123456789,"email1",123456789,"website1",12,13,14,15);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 06, 24, 14, 33, 48, 123456789);
        UserEntry userEntry = new UserEntry(user2,now,localDateTime1,vc);
        UserEntry userEntry1 = new UserEntry(user,now,localDateTime1,vc);
        Company c = new Company();
        c.userEntryList.add(userEntry);
        c.userEntryList.add(userEntry1);
        String centerName = "centro1";
        String centerName2 = "centro2";
        c.saveVaccinationCenter(vc);
        c.checkVaccinationCenterExistence(centerName);
        c.checkVaccinationCenterExistence(centerName2);
        boolean check = true;
        boolean check2 = false;
        assertEquals(check,c.checkVaccinationCenterExistence(centerName));
        assertEquals(check2,c.checkVaccinationCenterExistence(centerName2));


    }


    @Test
    void listUserEntryList() {
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,98765431);
        User user2 = new User("João","MASCULINE","10/12/2010","Rua nova",967654321,"joao@gmail.com",123456789,98765431);
        VaccinationCenter vc = new VaccinationCenter("centro1","rua1",123456789,"email1",123456789,"website1",12,13,14,15);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 06, 24, 14, 33, 48, 123456789);
        UserEntry userEntry = new UserEntry(user2,now,localDateTime1,vc);
        UserEntry userEntry1 = new UserEntry(user,now,localDateTime1,vc);
        Company c = new Company();
        c.userEntryList.add(userEntry);
        c.userEntryList.add(userEntry1);
        c.listUserEntryList();
    }

    @Test
    void chooseUserAndVaccine() {
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,98765431);
        User user2 = new User("João","MASCULINE","10/12/2010","Rua nova",967654321,"joao@gmail.com",123456789,98765431);
        VaccinationCenter vc = new VaccinationCenter("centro1","rua1",123456789,"email1",123456789,"website1",12,13,14,15);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 06, 24, 14, 33, 48, 123456789);
        UserEntry userEntry = new UserEntry(user2,now,localDateTime1,vc);
        UserEntry userEntry1 = new UserEntry(user,now,localDateTime1,vc);
        Company c = new Company();
        c.userEntryList.add(userEntry);
        c.userEntryList.add(userEntry1);
        c.AddchooseUserAndVaccine(1, Vaccines.vacine.BioNtech,"12cd-12",2);
        c.ListvaccineAdministrations();
    }

    @Test
    void checkUserExistence() {
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,98765431);
        User user2 = new User("João","MASCULINE","10/12/2010","Rua nova",967654321,"joao@gmail.com",123456789,98765431);
        VaccinationCenter vc = new VaccinationCenter("centro1","rua1",123456789,"email1",123456789,"website1",12,13,14,15);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 06, 24, 14, 33, 48, 123456789);
        UserEntry userEntry = new UserEntry(user2,now,localDateTime1,vc);
        UserEntry userEntry1 = new UserEntry(user,now,localDateTime1,vc);
        Company c = new Company();
        c.userEntryList.add(userEntry);
        c.userEntryList.add(userEntry1);
        c.AddchooseUserAndVaccine(1, Vaccines.vacine.BioNtech,"12cd-12",2);
        c.checkUserExistence(123456789);
        boolean check = true;
        boolean check2 = false;
        assertEquals(check,c.checkUserExistence(123456789));
        assertEquals(check2,c.checkUserExistence(123333333));

    }

    @Test
    void addAdverseReactions() {
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,98765431);
        User user2 = new User("João","MASCULINE","10/12/2010","Rua nova",967654321,"joao@gmail.com",123456789,98765431);
        VaccinationCenter vc = new VaccinationCenter("centro1","rua1",123456789,"email1",123456789,"website1",12,13,14,15);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 06, 24, 14, 33, 48, 123456789);
        UserEntry userEntry = new UserEntry(user2,now,localDateTime1,vc);
        UserEntry userEntry1 = new UserEntry(user,now,localDateTime1,vc);
        Company c = new Company();
        c.userEntryList.add(userEntry);
        c.userEntryList.add(userEntry1);
        c.AddchooseUserAndVaccine(1, Vaccines.vacine.BioNtech,"12cd-12",2);
        c.checkUserExistence(123456789);
        boolean check = true;
        boolean check2 = false;
        assertEquals(check,c.checkUserExistence(123456789));
        assertEquals(check2,c.checkUserExistence(123333333));
        String adverseReactions = "Headache";
        c.addAdverseReactions(123456789,adverseReactions);
    }

    @Test
    void testToString() {
        User user = new User("Tiago","MASCULINE","10/12/2010","Rua nova",967654321,"tiago@gmail.com",123456789,98765431);
        User user2 = new User("João","MASCULINE","10/12/2010","Rua nova",967654321,"joao@gmail.com",123456789,98765431);
        VaccinationCenter vc = new VaccinationCenter("centro1","rua1",123456789,"email1",123456789,"website1",12,13,14,15);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 06, 24, 14, 33, 48, 123456789);
        UserEntry userEntry = new UserEntry(user2,now,localDateTime1,vc);
        UserEntry userEntry1 = new UserEntry(user,now,localDateTime1,vc);
        Company c = new Company();
        c.userEntryList.add(userEntry);
        c.userEntryList.add(userEntry1);
        c.AddchooseUserAndVaccine(1, Vaccines.vacine.BioNtech,"12cd-12",2);
        c.toString();
    }
}