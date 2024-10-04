package app.controller;

import app.domain.model.Company;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdverseReactionsControllerTest {

    @Test
    void checkUserExistence() {
        AdverseReactionsController ar = new AdverseReactionsController();
        int snsnumber = 123456788;
        ar.checkUserExistence(snsnumber);
    }

    @Test
    void addAdverseReactions() {
        AdverseReactionsController ar = new AdverseReactionsController();
        int snsnumber = 123456788;
        String adverseReactions = "Headache and stomach dilatation";
        ar.addAdverseReactions(snsnumber,adverseReactions);
    }

    @Test
    void AdverseReactions(){
        Company company = new Company();
    }
}