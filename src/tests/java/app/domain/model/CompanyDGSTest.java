package app.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyDGSTest {

    @Test
    void validateVaccineType() {
        boolean expectedValue = true;
        CompanyDGS c = new CompanyDGS();
        VaccineType vt = new VaccineType("123456","Apply to fight covid","covid19");
        boolean currentValue = c.validateVaccineType(null);
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void validateVaccineTypeExist() {
        boolean expectedValue = false;
        CompanyDGS c = new CompanyDGS();
        VaccineType vt = new VaccineType("123456","Apply to fight covid","covid19");
        VaccineType vt1 = new VaccineType("123456","Apply to fight covid","covid19");
        c.validateVaccineType(vt);
        c.saveVaccineType(vt);
        c.saveVaccineType(vt1);
        boolean currentValue = c.saveVaccineType(vt1);
        c.listVaccineType();
        assertEquals(expectedValue,currentValue);
    }

    @Test
    void equalsVaccineType() {
        boolean expectedValue = true;
        CompanyDGS c = new CompanyDGS();
        VaccineType vt = new VaccineType("123456","Apply to fight covid","covid19");
        VaccineType vt1 = null;
        c.createVaccineType("123456","Apply to fight covid","covid19");
        c.saveVaccineType(vt);
        boolean currentValue = c.validateVaccineType(vt1);
        assertEquals(expectedValue,currentValue);
    }
}