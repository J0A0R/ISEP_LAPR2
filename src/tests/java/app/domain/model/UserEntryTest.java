package app.domain.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserEntryTest {

    @Test
    void toString1() {
        User user1 = new User("Francisco","MASCULINE","10/12/2010","Rua nova",967654321,"francisco@gmail.com",123456789,98765431);
        User user2 = new User("João","MASCULINE","10/12/2010","Rua nova",967654321,"joao@gmail.com",123456789,98765432);
        VaccinationCenter vc = new VaccinationCenter("centro1","rua1",123456789,"email1",123456789,"website1",12,13,14,15);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 06, 24, 14, 33, 48, 123456789);
        LocalDateTime localDateTime2 = LocalDateTime.of(2021, 04, 24, 14, 33, 48, 123456789);
        LocalDateTime localDateTime3 = LocalDateTime.of(2021, 04, 28, 14, 33, 48, 123456789);

        UserEntry userEntry = new UserEntry(user2,now,localDateTime1,vc);
        UserEntry userEntry1 = new UserEntry(user1,localDateTime2,localDateTime3,vc);

        String expected = "UserEntry user= name= Francisco, sex= MASCULINE, birth date= 10/12/2010, address= Rua nova, phoneNumber= 967654321, email= francisco@gmail.com, SNSUserNumber= 123456789 and citizenCardNumber=987654321, lastEntry=2022-05-29T16:03:14.070786300";



    }

    @Test
    void testToString() {
        User user1 = new User("Francisco","MASCULINE","10/12/2010","Rua nova",967654321,"francisco@gmail.com",123456789,98765421);
        User user2 = new User("João","MASCULINE","10/12/2010","Rua nova",967654321,"joao@gmail.com",123456789,98765432);
        VaccinationCenter vc = new VaccinationCenter("centro1","rua1",123456789,"email1",123456789,"website1",12,13,14,15);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 06, 24, 14, 33, 48, 123456789);
        LocalDateTime localDateTime2 = LocalDateTime.of(2021, 04, 24, 14, 33, 48, 123456789);
        LocalDateTime localDateTime3 = LocalDateTime.of(2021, 04, 28, 14, 33, 48, 123456789);

        UserEntry userEntry = new UserEntry(user2,now,localDateTime1,vc);
        UserEntry userEntry1 = new UserEntry(user1,localDateTime2,localDateTime3,vc);

    }
}