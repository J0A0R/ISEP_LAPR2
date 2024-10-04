package app.controller;

import app.domain.model.Company;
import app.domain.shared.Constants;
import app.ui.utils.Utils;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;
import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.UserSession;

import java.io.*;
import java.util.Properties;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class App {

    private Company company;
    private AuthFacade authFacade;

    private App()
    {
        Properties props = getProperties();
        this.company = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION));
        this.authFacade = this.company.getAuthFacade();
        bootstrap();
    }

    public Company getCompany()
    {
        return this.company;
    }


    public UserSession getCurrentUserSession()
    {
        return this.authFacade.getCurrentUserSession();
    }

    public boolean doLogin(String email, String pwd)
    {
        return this.authFacade.doLogin(email,pwd).isLoggedIn();
    }

    public void doLogout()
    {
        this.authFacade.doLogout();
    }

    private Properties getProperties()
    {
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "DGS/SNS");


        // Read configured values
        try
        {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            in.close();
        }
        catch(IOException ex)
        {

        }
        return props;
    }


    private void bootstrap()
    {
        this.authFacade.addUserRole(Constants.ROLE_ADMIN,Constants.ROLE_ADMIN);
        this.authFacade.addUserRole(Constants.ROLE_NURSE,Constants.ROLE_NURSE);
        this.authFacade.addUserRole(Constants.ROLE_RECEPTIONIST,Constants.ROLE_RECEPTIONIST);
        this.authFacade.addUserRole(Constants.ROLE_COORDINATOR,Constants.ROLE_COORDINATOR);

        this.authFacade.addUserWithRole("Main Administrator", "admin@lei.sem2.pt", "123456",Constants.ROLE_ADMIN);
        this.authFacade.addUserWithRole("Nurse", "nurse@lei.sem2.pt", "123456",Constants.ROLE_NURSE);
        this.authFacade.addUserWithRole("Receptionist", "receptionist@lei.sem2.pt","123456",Constants.ROLE_RECEPTIONIST);
        this.authFacade.addUserWithRole("Center Coordinator","coordinator@lei.sem2.pt","123456",Constants.ROLE_COORDINATOR);

    }

    public void addSNSUser(String email){
        this.authFacade.addUserRole(Constants.ROLE_SNSUSER, Constants.ROLE_SNSUSER);

        this.authFacade.addUserWithRole("SNSUser", email,"123456",Constants.ROLE_SNSUSER);
    }

    // Extracted from https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static App singleton = null;
    public static App getInstance()
    {
        if(singleton == null)
        {
            synchronized(App.class)
            {
                singleton = new App();
            }
        }
        return singleton;
    }

    public void fechar(WindowEvent event) {
        Alert aviso = new Alert(Alert.AlertType.CONFIRMATION, "Deseja mesmo sair?", ButtonType.YES, ButtonType.NO);
        aviso.setHeaderText("Confirmação da ação");
        aviso.showAndWait();
        ButtonType resultado = aviso.getResult();
        if(resultado == ButtonType.NO) {
            event.consume();
            return;
        }

        try
        {
            FileOutputStream file = new FileOutputStream(Constants.PARAMS_FICHEIRO_DADOS);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(this.company);

            out.close();
            file.close();
        }
        catch(IOException e)
        {
            Utils.createAlert(Alert.AlertType.WARNING, "Save data", "Error saving: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
