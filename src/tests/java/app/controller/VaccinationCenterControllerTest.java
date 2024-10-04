package app.controller;

import app.domain.model.Company;
import app.domain.model.VaccinationCenter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VaccinationCenterControllerTest {


    @Test
    void showVaccinationCenterList() {
        VaccinationCenter vc = new VaccinationCenter("centro 1","Rua Velha",912395145,"centro1@gmail.com",211222333,"www.centro1.com",8,20,15,5);
        VaccinationCenterController vcc = new VaccinationCenterController();
        vcc.showVaccinationCenterList();

    }

    @Test
    void numberVaccinationCenter() {
        VaccinationCenter vc = new VaccinationCenter("centro 1","Rua Velha",912395145,"centro1@gmail.com",211222333,"www.centro1.com",8,20,15,5);
        VaccinationCenterController vcc = new VaccinationCenterController();
        vcc.numberVaccinationCenter();
    }

    @Test
    void orderUserEntryList() {
        VaccinationCenter vc = new VaccinationCenter("centro 1","Rua Velha",912395145,"centro1@gmail.com",211222333,"www.centro1.com",8,20,15,5);
        VaccinationCenterController vcc = new VaccinationCenterController();
        String centerName = "centro1";
        vcc.orderUserEntryList(centerName);
    }

    @Test
    void checkVaccinationCenter() {
        VaccinationCenter vc = new VaccinationCenter("centro 1","Rua Velha",912395145,"centro1@gmail.com",211222333,"www.centro1.com",8,20,15,5);
        VaccinationCenterController vcc = new VaccinationCenterController();
        String centerName = "centro1";
        vcc.checkVaccinationCenter(centerName);
    }
}