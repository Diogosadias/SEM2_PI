package app.controller;

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
 * @author Tiago Rocha <1181445@isep.ipp.pt>
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
        Receptionist employee1 = new Receptionist(this.company.getOrgRoleStore().getRoleById(RECEPTIONIST), "R00001", "Receptionist1","R1-address",12900000001L,"R1-soc");
        this.authFacade.addUserWithRole(employee1.getName(), employee1.getEmail(), "123",Constants.ROLE_RECEP);
        this.company.getEmployeeStore().addEmployee(employee1);

        MedicalLabTechnician employee2 = new MedicalLabTechnician(this.company.getOrgRoleStore().getRoleById(MEDICAL_LAB_TECHNICIAN), "MLT00002", "Medical Lab Technician1","MLT1-address",12900000201L,"MLT1-soc");
        this.authFacade.addUserWithRole(employee2.getName(), employee2.getEmail(), "123", MEDICAL_LAB_TECHNICIAN);
        this.company.getEmployeeStore().addEmployee(employee2);

        SpecialistDoctor employee3 = new SpecialistDoctor(this.company.getOrgRoleStore().getRoleById(SPECIALIST_DOCTOR), "SD00004", "Specialist Doctor1","SD1-address",12900000231L,"SD1-soc",11921);
        this.authFacade.addUserWithRole(employee3.getName(), employee3.getEmail(), "123", SPECIALIST_DOCTOR);
        this.company.getEmployeeStore().addEmployee(employee3);


        ChemistryTechnologist employee4 = new ChemistryTechnologist(this.company.getOrgRoleStore().getRoleById(CHEMISTRY_TECHNOLOGIST), "CMT00003", "Chemistry Technologist1", "CMT-adress",12900001231L,"CMT-soc");
        this.authFacade.addUserWithRole(employee4.getName(), employee4.getEmail(), "123", CHEMISTRY_TECHNOLOGIST );
        this.company.getEmployeeStore().addEmployee(employee4);

        //Client
        Client client1 = new Client (new Email("client1@lei.pt"),"Client Teste",1234567890L,1212121212121212L,210000000001L,new Date("1990/01/01"),"M",91000000000L);
        this.company.getClientStore().saveClients(client1,"123");

        //ParameterCategory - Covid Tests
        ParameterCategory categoryCovid = new ParameterCategory("SC200","SARS-CoV-2","21001");
        this.company.getParameterCategoryStore().addParameterCategory(categoryCovid);

        //ParameterCategory - Blood Tests
        ParameterCategory category1 = new ParameterCategory("CBC00","Hemogram (CBC)","11001");
        this.company.getParameterCategoryStore().addParameterCategory(category1);

        ParameterCategory category2 = new ParameterCategory("BMP00","Basic Metabolic Panel","11002");
        this.company.getParameterCategoryStore().addParameterCategory(category2);

        ParameterCategory category3 = new ParameterCategory("CMP00","Complete Metabolic Panel","11003");
        this.company.getParameterCategoryStore().addParameterCategory(category3);

        //Parameter - Category 1
        Parameter parameter1 = new Parameter("WBC00","White Blood Cells (WBC)","White blood cells count",category1.getCode());
        this.company.getParameterStore().addParameter(parameter1);
        Parameter parameter2 = new Parameter("RBC00","Red Blood Cells (RBC)","Red blood cells count",category1.getCode());
        this.company.getParameterStore().addParameter(parameter2);
        Parameter parameter3 = new Parameter("PLT00","Platelet Count (PLT)","Platelets count",category1.getCode());
        this.company.getParameterStore().addParameter(parameter3);
        Parameter parameter9 = new Parameter("HB000","Haemoglobin (HB)","Haemoglobin count",category1.getCode());
        this.company.getParameterStore().addParameter(parameter9);
        Parameter parameter10 = new Parameter("MCV00","Mean Cell Volume (MCV)","Mean Cell count",category1.getCode());
        this.company.getParameterStore().addParameter(parameter10);
        Parameter parameter11 = new Parameter("MCH00","Mean Cell Haemoglobin (MCH)","Mean Cell Haemoglobin count",category1.getCode());
        this.company.getParameterStore().addParameter(parameter11);
        Parameter parameter12 = new Parameter("MCHC0","Mean Cell Haemoglobin Concentration (MCHC)","Mean Cell Haemoglobin count",category1.getCode());
        this.company.getParameterStore().addParameter(parameter12);
        Parameter parameter13 = new Parameter("ESR00","Erythrocyte Sedimentation Rate (ESR)","Erythrocyte Sedimentation count",category1.getCode());
        this.company.getParameterStore().addParameter(parameter13);

        //Parameter - Category 2
        Parameter parameter4 = new Parameter("ElT00","Electrolytes","Check levels of Electrolytes in blood.",category2.getCode());
        this.company.getParameterStore().addParameter(parameter4);
        Parameter parameter5 = new Parameter("CLC00","Calcium","Check levels of Calcium in blood.",category2.getCode());
        this.company.getParameterStore().addParameter(parameter5);

        //Parameter - Category 3
        Parameter parameter6 = new Parameter("ABM00","Albumin","BMP measurements as well as Albumin,related to liver function.",category3.getCode());
        this.company.getParameterStore().addParameter(parameter6);
        Parameter parameter7 = new Parameter("TPT00","Total protein","BMP measurements as well as total Proteins, related to liver function.",category3.getCode());
        this.company.getParameterStore().addParameter(parameter7);

        //Parameter - Category Covid
        Parameter parameter8 = new Parameter("IgGAN","IgC antibodies","Detect presence of antibodies.",categoryCovid.getCode());
        this.company.getParameterStore().addParameter(parameter8);

        //TestType
        TestType type1 = new TestType("TT-01","Blood Test","Blood sample");
        type1.addParameterCategory(category1);
        type1.addParameterCategory(category2);
        type1.addParameterCategory(category3);
        this.company.getTestTypeStore().addTestType(type1);

        TestType type2 = new TestType("TT-02","Covid Test","Sample");
        type2.addParameterCategory(categoryCovid);
        this.company.getTestTypeStore().addTestType(type2);

        //Test
        Test test1 = new Test (type1,type1.getCollectingMethod(),client1);
        test1.addCategory(category1);
        test1.addParameter(parameter1);
        test1.setNhsCode("nhsCode-AB01");
        test1.setCode("000000000001");
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
