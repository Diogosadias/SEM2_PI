package app.controller;

import app.domain.dto.EmployeeDto;
import app.domain.model.*;
import app.domain.shared.Constants;
import auth.AuthFacade;
import auth.UserSession;
import auth.domain.model.Email;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import static app.domain.shared.Constants.*;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 * @author Gil <1180838@isep.ipp.pt>
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 */
public class
App {

    private final Company company;
    private final AuthFacade authFacade;

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
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "Many Labs");


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
        this.authFacade.addUserRole(Constants.ROLE_EMPLOYEE,Constants.ROLE_EMPLOYEE);
        this.authFacade.addUserRole(Constants.ROLE_ADMIN,Constants.ROLE_ADMIN);
        this.authFacade.addUserRole(Constants.ROLE_RECEP,Constants.ROLE_RECEP);
        this.authFacade.addUserRole(Constants.ROLE_CLIENT,Constants.ROLE_CLIENT);
        this.authFacade.addUserRole(Constants.ROLE_SPEC_DOCTOR,Constants.SPECIALIST_DOCTOR);
        this.authFacade.addUserRole(Constants.ROLE_LAB_COORDINATOR,Constants.LABORATORY_COORDINATOR);
        this.authFacade.addUserRole(Constants.ROLE_CHEM_TECH,Constants.CHEMISTRY_TECHNOLOGIST);
        this.authFacade.addUserRole(Constants.ROLE_MED_LAB_TECH,Constants.MEDICAL_LAB_TECHNICIAN);

        this.company.getOrgRoleStore().addOrgRole(new OrgRole(SPECIALIST_DOCTOR, MODEL_CLASS_PATH +"" + SPECIALIST_DOCTOR));
        this.company.getOrgRoleStore().addOrgRole(new OrgRole(LABORATORY_COORDINATOR,MODEL_CLASS_PATH +"" + LABORATORY_COORDINATOR));
        this.company.getOrgRoleStore().addOrgRole(new OrgRole(CHEMISTRY_TECHNOLOGIST, MODEL_CLASS_PATH +"" + CHEMISTRY_TECHNOLOGIST));
        this.company.getOrgRoleStore().addOrgRole(new OrgRole(MEDICAL_LAB_TECHNICIAN,MODEL_CLASS_PATH +"" + MEDICAL_LAB_TECHNICIAN));
        this.company.getOrgRoleStore().addOrgRole(new OrgRole(RECEPTIONIST,MODEL_CLASS_PATH +"" + RECEPTIONIST));
        //this.company.getEmployeeStore().addOrgRole(new OrgRole(ADMINISTRATOR, MODEL_CLASS_PATH +"" + ADMINISTRATOR));

        this.authFacade.addUserWithRole("Admin", "admin@lei.pt", "495", Constants.ROLE_ADMIN);
        this.authFacade.addUserWithRole("Client1","clei@sd.pt","123",Constants.ROLE_CLIENT);
        this.authFacade.addUserWithRoles("SuperUser", "superuser@super.user", "123456", new String[] { Constants.ROLE_CLIENT,Constants.ROLE_ADMIN, Constants.ROLE_RECEP });


        //Employee
        Receptionist employee1 = new Receptionist(this.company.getOrgRoleStore().getRoleById(RECEPTIONIST), "R00001", "Receptionist1","R1:address",12900000001L,"R1:soc");
        this.authFacade.addUserWithRole(employee1.getName(), employee1.getEmail(), "123",Constants.ROLE_RECEP);
        this.company.getEmployeeStore().addEmployee(employee1);

        MedicalLabTechnician employee2 = new MedicalLabTechnician(this.company.getOrgRoleStore().getRoleById(MEDICAL_LAB_TECHNICIAN), "ML00002", "Receptionist1","R1:address",12900000201L,"R1:soc");
        this.authFacade.addUserWithRole(employee2.getName(), employee2.getEmail(), "123", MEDICAL_LAB_TECHNICIAN);
        this.company.getEmployeeStore().addEmployee(employee2);

        //Client
        Client client1 = new Client (new Email("client1@lei.pt"),"Client Teste",1234567890L,1212121212121212L,210000000001L,new Date(1990,01,01),"M",91000000000L);
        this.authFacade.addUserWithRole(client1.getName(), client1.getId().getEmail(), "123" , Constants.ROLE_CLIENT);
        this.company.getCreateClientStore().addClient(client1);

        //ParameterCategory
        ParameterCategory category1 = new ParameterCategory("PC-01","Hemogram","nhsid");
        this.company.getParameterCategoryStore().addParameterCategory(category1);

        //Parameter
        Parameter parameter1 = new Parameter("P-001","Red Blood Cells (RBC)","Number of RBC",category1.getCode());
        this.company.getParameterStore().addParameter(parameter1);

        //TestType
        TestType type1 = new TestType("TT-01","Blood Test","Blood Sample");
        type1.addParameterCategory(category1);
        this.company.getTestTypeStore().addTestType(type1);

        //Test
        Test test1 = new Test (type1,type1.getCollectingMethod(),client1);
        test1.addParameter(parameter1);
        test1.setNhsCode("nhsCode-AB01");
        this.company.getTestStore().addTest(test1);
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
}
