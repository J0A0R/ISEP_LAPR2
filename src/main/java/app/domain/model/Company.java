package app.domain.model;

import app.Vaccines.Vaccines;
import app.controller.App;
import com.opencsv.CSVWriter;
import pt.isep.lei.esoft.auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

/**
 *The Company.
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company implements Serializable {


    /**
     * List that keeps employees
     */
    private List<Employee> employeeList;


    /**
     * List that stores Vaccination Centers
     */
    private List<VaccinationCenter> vaccinationCenterList = new ArrayList<>();

    /**
     * List that keeps users
     */
    private List<User> userList;

    /**
     * List that keeps users vaccinated
     */
    public List<VaccineAdministration> vaccineAdministrationsList = new ArrayList<>();

    /**
     * List that keeps users vaccinated with adverse reactions
     */
    public List<VaccineAdministration> vaccineAdministrationsList2 = new ArrayList<>();

    /**
     * List of all UserEntries
     */
    public List<UserEntry> userEntryList = new ArrayList<>();
    private String designation;
    private AuthFacade authFacade;

    /**
     * Separator ";" of file
     */
    private static final String SEPARATOR_A = ";";

    /**
     * Separator "," of file
     */
    private static final String SEPARATOR_B = ",";

    public Company(String designation) {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
    }

    /**
     * Instantiates a new Company.
     */
    public Company() {
        if (employeeList == null)
            employeeList = new ArrayList<>();
        if (userEntryList == null)
            userEntryList = new ArrayList<>();
        if (userList == null)
            userList = new ArrayList<>();
        if (vaccinationCenterList == null)
            vaccinationCenterList = new ArrayList<>();
        if (vaccineAdministrationsList == null)
            vaccineAdministrationsList = new ArrayList<>();
    }

    public Company(int valor) {
        ArrayList<VaccineAdministration> VaccineAdministration2 = new ArrayList<>(vaccineAdministrationsList);
    }

    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    /**
     * Create employee.
     *
     * @param name                the name of the employee
     * @param address             the address of the employee
     * @param phoneNumber         the phone number of the employee
     * @param email               the email of the employee
     * @param citizenCardIDNumber the citizen card id number of the employee
     * @param password            the password of the employee
     * @param username            the username of the employee
     * @return the new employee
     */
    public Employee createEmployee(String name, String address, int phoneNumber, String email, String citizenCardIDNumber, String password, String username) {
        return new Employee(name, address, phoneNumber, email, citizenCardIDNumber, password, username);
    }

    /**
     * Validate employee.
     *
     * @param em the employee
     * @return true if the employee exist in the employee list, otherwise it returns false.
     */
    public boolean validateEmployee(Employee em) {
        boolean validate = false;
        if (em == null)
            validate = false;
        if (!equalsEmployee(employeeList, em))
            validate = true;
        return validate;
    }

    /**
     * Create receptionist type employee.
     *
     * @param name                the name of the receptionist
     * @param address             the address of the receptionist
     * @param phoneNumber         the phone number of the receptionist
     * @param email               the email of the receptionist
     * @param citizenCardIDNumber the citizen card id number of the receptionist
     * @param password            the password of the receptionist
     * @param username            the username of the receptionist
     * @param userID              the user id of the receptionist
     * @return the new receptionist
     */
    public Receptionist createEmployeeReceptionist(String name, String address, int phoneNumber, String email, String citizenCardIDNumber, String password, String username, String userID) {
        return new Receptionist(name, address, phoneNumber, email, citizenCardIDNumber, password, username, userID);
    }

    /**
     * Create nurse type employee.
     *
     * @param name                the name of the nurse
     * @param address             the address of the nurse
     * @param phoneNumber         the phone number of the nurse
     * @param email               the email of the nurse
     * @param citizenCardIDNumber the citizen card id number of the nurse
     * @param password            the password of the nurse
     * @param username            the username of the nurse
     * @param userID              the user id of the nurse
     * @return the new nurse
     */
    public Nurse createEmployeeNurse(String name, String address, int phoneNumber, String email, String citizenCardIDNumber, String password, String username, String userID) {
        return new Nurse(name, address, phoneNumber, email, citizenCardIDNumber, password, username, userID);
    }

    /**
     * Create adminstrator type employee.
     *
     * @param name                the name of the adminstrator
     * @param address             the address of the adminstrator
     * @param phoneNumber         the phone number of the adminstrator
     * @param email               the email of the adminstrator
     * @param citizenCardIDNumber the citizen card id number of the adminstrator
     * @param password            the password of the adminstrator
     * @param username            the username of the adminstrator
     * @param userID              the user id of the adminstrator
     * @return the new adminstrator
     */
    public Adminstrator createEmployeeAdminstrator(String name, String address, int phoneNumber, String email, String citizenCardIDNumber, String password, String username, String userID) {
        return new Adminstrator(name, address, phoneNumber, email, citizenCardIDNumber, password, username, userID);
    }

    /**
     * Create coordinator type employee.
     *
     * @param name                the name of the coordinator
     * @param address             the address of the coordinator
     * @param phoneNumber         the phone number of the coordinator
     * @param email               the email of the coordinator
     * @param citizenCardIDNumber the citizen card id number of the coordinator
     * @param password            the password of the coordinator
     * @param username            the username of the coordinator
     * @param userID              the user id of the coordinator
     * @return the new coordinator
     */
    public Coordinator createEmployeeCoordinator(String name, String address, int phoneNumber, String email, String citizenCardIDNumber, String password, String username, String userID) {
        return new Coordinator(name, address, phoneNumber, email, citizenCardIDNumber, password, username, userID);
    }

    public VaccinationCenter createVaccinationCenter(String name, int phone, String adress, String mail, int fax, String website, int opening_hours, int closing_hours, int slot_duration, int max_number_person_per_slot) {
        return new VaccinationCenter(name, adress, phone, mail, fax, website, opening_hours, closing_hours, slot_duration, max_number_person_per_slot);

    }

    /**
     * Save employee.
     *
     * @param em the new employee
     * @return true if the employee does not exist, otherwise it returns false.
     */
    public boolean saveEmployee(Employee em) {
        if (!validateEmployee(em))
            return false;
        return this.employeeList.add(em);
    }

    /**
     * Save a Vaccination Center
     *
     * @param center vaccination center to be saved
     * @return
     */
    public boolean saveVaccinationCenter(VaccinationCenter center) {

        this.vaccinationCenterList.add(center);
        Serialize.serialize(vaccinationCenterList, "VaccinationCenterList");
        return true;
    }

    /**
     * List employee.
     */
    public void listEmployee() {
        for (Employee em : employeeList) {
            if (em != null) {
                System.out.println(em.toString());
            }
        }
    }

    /**
     * List all VaccinationCenters
     */
    public void listVaccinationCenter() {
        for (VaccinationCenter center : vaccinationCenterList) {
            if (center != null) {
                System.out.println(center);
            }
        }
    }

    public List<VaccinationCenter> getVaccinationCenterList() {
        return this.vaccinationCenterList;
    }

    /**
     * Checks if the employee already exists in the list.
     *
     * @param employeeList list of employees
     * @param em           new employee
     * @return true if the employee already exists, otherwise it returns false.
     */
    private boolean equalsEmployee(List<Employee> employeeList, Employee em) {
        boolean equals = false;
        for (Employee employee : employeeList) {
            if (employee != null) {
                if (employee.equals(em)) {
                    equals = true;
                }
            }
        }
        return equals;
    }

    /**
     * List of receptionists.
     */

    public void listReceptionist() {
        for (Employee i : employeeList) {
            if (i instanceof Receptionist) {
                System.out.println(i);
            }
        }
    }

    /**
     * List of nurses.
     */

    public void listNurse() {
        for (Employee i : employeeList) {
            if (i instanceof Nurse) {
                System.out.println(i);
            }
        }
    }

    /**
     * List of administrators.
     */

    public void listAdministrator() {
        for (Employee i : employeeList) {
            if (i instanceof Adminstrator) {
                System.out.println(i);
            }
        }
    }

    /**
     * List of coordinators.
     */

    public void listCoordinator() {
        for (Employee i : employeeList) {
            if (i instanceof Coordinator) {
                System.out.println(i);
            }
        }
    }

    public void listAllUsersEntry() {
        for (UserEntry entry : userEntryList) {
            System.out.println(entry);
        }
    }


    /**
     * Identify the file.
     *
     * @param path the file path
     */
    public void importFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            if (line.contains(SEPARATOR_A)) {
                read(path, SEPARATOR_A);
            } else
                read(path, SEPARATOR_B);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Import CSV file.
     *
     * @param path      the file path
     * @param separacao the file separator
     */
    public void read(String path, String separacao) {
        int cont = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            if (Objects.equals(separacao, SEPARATOR_A)) {
                line = br.readLine();
            }
            while (line != null) {

                String[] vect = line.split(separacao);
                String name = vect[0];
                String sex = vect[1];
                String birthDate = vect[2];
                String address = vect[3];
                int phoneNumber = Integer.parseInt(vect[4]);
                String email = vect[5];
                int snsUserNumber = Integer.parseInt(vect[6]);
                int citizenCardNumber = Integer.parseInt(vect[7]);

                User user = null;
                try {
                    user = new User(name, sex, birthDate, address, phoneNumber, email, snsUserNumber, citizenCardNumber);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
                if (equalsUser(userList, user)) {
                    cont++;
                } else {
                    userList.add(user);
                    App.getInstance().addSNSUser(email);
                }

                line = br.readLine();
            }

            if (cont > 0) {
                System.out.println(cont + " users you tried to add already exist");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * list users.
     */
    public void listImportUser() {
        for (User user : userList) {
            if (user != null) {
                System.out.println(user.toString());
            }
        }
    }

    /**
     * Checks if the user already exists in the list.
     *
     * @param userList list of users
     * @param us       new User
     * @return true if the user already exists, otherwise it returns false.
     */
    public boolean equalsUser(List<User> userList, User us) {
        boolean equals = false;
        for (User users : userList) {
            if (users != null) {
                if (users.equals(us)) {
                    equals = true;
                }
            }
        }
        return equals;
    }

    /**
     * Method that registers the new UserEntry, Verifies if he is before schedueled, and if he
     * is was about to be registered twice the same day
     *
     * @param user user trying to be registered
     * @return true if user is registered, false if not
     */
    public boolean registerNewUserArrival(User user, VaccinationCenter vaccinationCenter) {
        for (UserEntry entry : userEntryList) {
            if (entry.getUser().equals(user)) {
                if (LocalDateTime.now().isBefore(entry.getNextEntry())) {
                    System.out.println("User is only scheduled to take the next vaccine:\n" + entry.getNextEntry() + "\n");
                    return false;
                }
                if (entry.getLastEntry().equals(LocalDateTime.now())) {
                    System.out.println("User was already registered Today\n");
                    return false;
                }
            }
        }

        UserEntry newEntry = new UserEntry(user, LocalDateTime.now(), LocalDateTime.now().plusMonths(6), vaccinationCenter);
        this.userEntryList.add(newEntry);
        Serialize.serialize(userEntryList, "UserEntryList");
        return true;

    }

    /**
     * Order user entry list
     */
    public void orderUserEntryList(String centername) {
        Collections.sort(userEntryList, new OrderUserEntryList());
        for (UserEntry userEntry : userEntryList) {
            if (userEntryList != null) {
                userEntry.toString1(centername);
            }
        }
    }

    /**
     * Returns the vaccination center list size, which is the number of vaccination centers saved
     *
     * @return number of vaccinations centers saved
     */
    public int numberVaccinationCenter() {
        return vaccinationCenterList.size();
    }

    /**
     * Prints the Vaccination Center data
     */
    public void printVaccinationCenterList() {
        int i = 1;
        for (VaccinationCenter vc : vaccinationCenterList) {
            if (vc != null) {
                System.out.println("-----------------------");
                System.out.println(i + ")");
                System.out.println(vc.toString());
                i++;
            }
        }
    }

    /**
     * Method that checks if a Vaccination Center exists on the Arraylist or not
     *
     * @param vaccinationCenterName - Vaccination Center name to be searched on the list
     * @return true if the vaccination center exists or false if it doesn't
     */
    public boolean checkVaccinationCenterExistence(String vaccinationCenterName) {
        boolean check;
        check = false;
        outer:
        for (UserEntry userEntry : userEntryList) {
            if (userEntry.checkVaccinationCenterExistence(vaccinationCenterName)) {
                check = true;
                break outer;
            }
        }
        return check;
    }

    /**
     * List user entry.
     */
    public String listUserEntryList() {
        int i = 0;
       /* for (UserEntry userEntry : userEntryList) {
            if (userEntryList != null) {
                System.out.println(i++);
                System.out.println(userEntry.toString());
            }
        }*/

        List<UserEntry> copia = new ArrayList<>(userEntryList);

        StringBuilder s = new StringBuilder();
        for (UserEntry userEntry : copia) {
            i++;
            s.append(i);
            s.append(userEntry);
            s.append("\n");
        }

        return s.toString().trim();
    }

    /**
     * User choice.
     *
     * @param number User list position
     */
    public boolean AddchooseUserAndVaccine(int number, Vaccines.vacine vaccine, String lot, int dose) {
        VaccineAdministration vaccineAdministration = new VaccineAdministration(vaccine, userEntryList.get(number), lot, dose);
        VaccineAdministration vaccineAdministration2 = new VaccineAdministration(vaccine, userEntryList.get(number), lot, dose, "");
        vaccineAdministrationsList2.add(vaccineAdministration2);
        return vaccineAdministrationsList.add(vaccineAdministration);
    }

    /**
     * List users with administered vaccine.
     */
    public void ListvaccineAdministrations() {
        for (VaccineAdministration vaccineAdministration : vaccineAdministrationsList) {
            if (vaccineAdministrationsList != null) {
                System.out.println(vaccineAdministration.toString());
            }
        }
    }

    /**
     * List users with vaccine administered for the graphical interface
     *
     * @return List users with vaccine administered
     */
    @Override
    public String toString() {
        List<VaccineAdministration> copia = new ArrayList<>(vaccineAdministrationsList);

        StringBuilder s = new StringBuilder();
        for (VaccineAdministration vaccineAdministration : copia) {
            s.append(vaccineAdministration);
            s.append("\n");
        }

        return s.toString().trim();
    }



    /**
     * This method verifies if the SNS Number is valid and if it is, if the sns user has taken a vaccine
     *
     * @param snsnumber
     * @return false if the user has been not found or if found has not taken the vaccine and true if both conditions are true
     */
    public boolean checkUserExistence(int snsnumber) {
        boolean check = false;

        for (VaccineAdministration ue : vaccineAdministrationsList) {
            if (ue.getSnsUserNumber() == snsnumber) {
                check = true;
            }

        }

        return check;
    }

    /**
     * Method that adds adverse reactions to an SNS User that is valid and that has taken the vaccine
     *
     * @param snsnumber
     * @param adverseReactions
     */
    public void addAdverseReactions(int snsnumber, String adverseReactions) {

        for (int i = 0; i < vaccineAdministrationsList2.size(); i++) {
            if (vaccineAdministrationsList2.get(i).getSnsUserNumber() == snsnumber) {
                vaccineAdministrationsList2.get(i).setAdverseReactions(adverseReactions);
            }
        }
        Serialize.serialize(vaccineAdministrationsList2, "adverseReactions");
        for (VaccineAdministration ue : vaccineAdministrationsList2) {
            System.out.println(ue.toString1());
        }
    }


    /**
     * Deserialize Vaccine Administrations List
     */
    public void deserializeVaccineAdministrations() {
        vaccineAdministrationsList = Serialize.deserialize("vaccineAdministration");
    }

    public void deserializeUserEntry() {
        userEntryList = Serialize.deserialize("UserEntryList");
    }

    public void deserializeVaccinationCenter() {
        vaccinationCenterList = Serialize.deserialize("VaccinationCenterList");
    }

    /**
     * Deserialize Adverse Reactions
     */
    public void deserializeAdverseReactions(){
        vaccineAdministrationsList2 = Serialize.deserialize("adverseReactions");
    }

    public void exportToCsv() {

        List<String[]> csvData = new LinkedList<>();

        String[] header = {"Day", "People Vacinated"};
        csvData.add(header);


        int counter_per_day = 0;

        for (UserEntry entry : this.userEntryList) {

            int index = this.userEntryList.indexOf(entry);

            if (index != 0) {

                if (entry.getLastEntry().getDayOfYear() == this.userEntryList.get(index - 1).getLastEntry().getDayOfYear()) {

                    counter_per_day++;
                } else {
                    String[] line = {entry.getLastEntry().toString(), Integer.toString(counter_per_day)};
                    csvData.add(line);
                    counter_per_day = 0;
                }
            } else {
                counter_per_day++;
            }
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter("docs\\data.csv"))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}





