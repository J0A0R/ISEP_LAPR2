package app.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NurseControllerTest {

    @Test
    void listOfVaccinationCenters() {
        NurseController nc = new NurseController();
        nc.listOfVaccinationCenters();
    }

    @Test
    void numberVaccinationCenter() {
        NurseController nc = new NurseController();
        nc.numberVaccinationCenter();
    }
}