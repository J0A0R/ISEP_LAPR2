package app.controller;

import app.domain.model.Company;

public class AdverseReactionsController {
    /**
     * Company
     */
    private static Company company;

    /**
     * Constructor method that makes sure there is a company to connect
     */
    public AdverseReactionsController(){
        if(company == null){
            company = App.getInstance().getCompany();
        }

    }

    /**
     * Method that instantiates the company
     * @param company
     */
    public AdverseReactionsController(Company company){this.company = company;}


    /**
     * Method that checks an SNS User Number existence and if it has taken a vaccine
     * @param snsnumber
     * @return true if both conditions are true or false if one of them is false
     */
    public boolean checkUserExistence(int snsnumber){
        boolean check = false;
        check = company.checkUserExistence(snsnumber);
        return  check;
    }

    /**
     * Method that receives the adverse reactions and an SNS Number and adds to the information of the vaccination of that SNS User the adverse reactions
     * @param snsnumber
     * @param adverseReactions
     */
    public void addAdverseReactions(int snsnumber,String adverseReactions){
        company.addAdverseReactions(snsnumber,adverseReactions);
    }

}
