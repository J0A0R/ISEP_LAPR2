package app.controller;

import app.domain.model.Company;
import app.domain.model.CompanyDGS;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecifyNewEmployeeControllerTest {

    @Test
    void createEmployee() {
        boolean expectedValue = true;
        SpecifyNewEmployeeController se = new SpecifyNewEmployeeController();
        boolean currentValue = se.createEmployee("Tiago Ribeiro", "Rua nova", 961234567,"1202020@isep.ipp.pt", "123456","pass1","tiago");
        se.listEmployee();
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void createEmployeeReceptionist() {
        boolean expectedValue = true;
        SpecifyNewEmployeeController se = new SpecifyNewEmployeeController();
        boolean currentValue = se.createEmployeeReceptionist("Tiago Ribeiro", "Rua nova", 961234567,"1202020@isep.ipp.pt", "123456","pass1","tiago","202020");
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void createEmployeeNurse() {
        boolean expectedValue = true;
        SpecifyNewEmployeeController se = new SpecifyNewEmployeeController();
        boolean currentValue = se.createEmployeeNurse("Tiago Ribeiro", "Rua nova", 961234567,"1202020@isep.ipp.pt", "123456","pass1","tiago","202020");
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void createEmployeeAdminstrator() {
        boolean expectedValue = true;
        SpecifyNewEmployeeController se = new SpecifyNewEmployeeController();
        boolean currentValue = se.createEmployeeAdminstrator("Tiago Ribeiro", "Rua nova", 961234567,"1202020@isep.ipp.pt", "123456","pass1","tiago","202020");
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void createEmployeeCoordinator() {
        boolean expectedValue = true;
        SpecifyNewEmployeeController se = new SpecifyNewEmployeeController();
        boolean currentValue = se.createEmployeeCoordinator("Tiago Ribeiro", "Rua nova", 961234567,"1202020@isep.ipp.pt", "123456","pass1","tiago","202020");
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void saveEmployee() {
        boolean expectedValue = true;
        SpecifyNewEmployeeController se = new SpecifyNewEmployeeController();
        SpecifyNewEmployeeController se1 = new SpecifyNewEmployeeController( new Company());
        se.createEmployeeCoordinator("Tiago Ribeiro", "Rua nova", 961234567,"1202020@isep.ipp.pt", "123456","pass1","tiago","202020");
        boolean currentValue = se.saveEmployee();
        assertEquals(expectedValue,currentValue);
    }
}