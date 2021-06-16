package app.controller;

import app.domain.model.*;
import app.domain.shared.Constants;
import auth.AuthFacade;
import auth.UserSession;
import auth.domain.model.Email;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;


import java.io.*;
import java.util.Date;
import java.util.Properties;

import static app.domain.shared.Constants.*;
//coment test commit
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
/*
        this.authFacade.addUserWithRole("Admin", "admin@lei.pt", "495", Constants.ROLE_ADMIN);
        this.authFacade.addUserWithRoles("SuperUser", "superuser@super.user", "123456", new String[] { Constants.ROLE_CLIENT,Constants.ROLE_ADMIN, Constants.ROLE_RECEP });

        //Employee
        // email: R00001@lei.pt pass: 123
        Receptionist employee1 = new Receptionist(this.company.getOrgRoleStore().getRoleById(RECEPTIONIST), "R00001", "Receptionist1","R1-address",12900000001L,"R1-soc");
        this.authFacade.addUserWithRole(employee1.getName(), employee1.getEmail(), "123",Constants.ROLE_RECEP);
        this.company.getEmployeeStore().addEmployee(employee1);

        // email: MLT00002@lei.pt pass: 123
        MedicalLabTechnician employee2 = new MedicalLabTechnician(this.company.getOrgRoleStore().getRoleById(MEDICAL_LAB_TECHNICIAN), "MLT00002", "Medical Lab Technician1","MLT1-address",12900000201L,"MLT1-soc");
        this.authFacade.addUserWithRole(employee2.getName(), employee2.getEmail(), "123", MEDICAL_LAB_TECHNICIAN);
        this.company.getEmployeeStore().addEmployee(employee2);

        // email: CMT00003@lei.pt pass: 123
        ChemistryTechnologist employee4 = new ChemistryTechnologist(this.company.getOrgRoleStore().getRoleById(CHEMISTRY_TECHNOLOGIST), "CMT00003", "Chemistry Technologist1", "CMT-adress",12900001231L,"CMT-soc");
        this.authFacade.addUserWithRole(employee4.getName(), employee4.getEmail(), "123", CHEMISTRY_TECHNOLOGIST );
        this.company.getEmployeeStore().addEmployee(employee4);

        // email: SD00004@lei.pt pass: 123
        SpecialistDoctor employee3 = new SpecialistDoctor(this.company.getOrgRoleStore().getRoleById(SPECIALIST_DOCTOR), "SD00004", "Specialist Doctor1","SD1-address",12900000231L,"SD1-soc",11921);
        this.authFacade.addUserWithRole(employee3.getName(), employee3.getEmail(), "123", SPECIALIST_DOCTOR);
        this.company.getEmployeeStore().addEmployee(employee3);

        // email: LC00005@lei.pt pass: 123
        LaboratoryCoordinator employee5 = new LaboratoryCoordinator(this.company.getOrgRoleStore().getRoleById(LABORATORY_COORDINATOR), "LC00005", "Lab Coordinator1", "LC-address",98765432101L,"LC-soc");
        this.authFacade.addUserWithRole(employee5.getName(), employee5.getEmail(), "123", LABORATORY_COORDINATOR );
        this.company.getEmployeeStore().addEmployee(employee5);

        //ParameterCategory - Covid Tests
        ParameterCategory categoryCovid = new ParameterCategory("Covid","Covid Test","21001");
        this.company.getParameterCategoryStore().addParameterCategory(categoryCovid);

        //Parameter - Category Covid
        Parameter parameter8 = new Parameter("IgGAN","IgGAN","Detect presence of antibodies.",categoryCovid.getCode());
        this.company.getParameterStore().addParameter(parameter8);

        //TestType - Covid
        TestType type2 = new TestType("Covid","Covid Test","Sample");
        type2.addParameterCategory(categoryCovid);
        this.company.getTestTypeStore().addTestType(type2);

        //ParameterCategory - Blood Tests
        ParameterCategory category1 = new ParameterCategory("HCBC","Hemogram","11001");
        this.company.getParameterCategoryStore().addParameterCategory(category1);
        ParameterCategory category2 = new ParameterCategory("CHLT","Cholesterol","11002");
        this.company.getParameterCategoryStore().addParameterCategory(category2);

        //Parameter - Category Hemogram
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
        Parameter parameter12 = new Parameter("MCHC0","Mean Cell Haemoglobin Concentration (MCHC)","Mean Cell Haemoglobin concentration",category1.getCode());
        this.company.getParameterStore().addParameter(parameter12);
        Parameter parameter13 = new Parameter("ESR00","Erythrocyte Sedimentation Rate (ESR)","Erythrocyte Sedimentation count",category1.getCode());
        this.company.getParameterStore().addParameter(parameter13);

        //Parameter - Category Cholesterol
        Parameter parameter14 = new Parameter("HDL00","High-density lipoprotein","Complex particles composed of multiple proteins",category2.getCode());
        this.company.getParameterStore().addParameter(parameter14);

        //TestType
        TestType type1 = new TestType("Blood","Blood Test","Blood sample");
        type1.addParameterCategory(category1);
        this.company.getTestTypeStore().addTestType(type1);

        //Test
        Test forSamples = new Test (type1,type1.getCollectingMethod(),client1);
        forSamples.addCategory(category1);
        forSamples.addParameter(parameter1);
        forSamples.setNhsCode("nhsCode-AB01");
        forSamples.setCode("000000000001");
        this.company.getTestStore().addTest(forSamples);

        Test covid1 = new Test (type2,type2.getCollectingMethod(),client1);
        covid1.addCategory(categoryCovid);
        covid1.addParameter(parameter8);
        covid1.setNhsCode("nhsCode-CV01");
        covid1.setCode("000000000002");
        this.company.getTestStore().addTest(covid1);


        Test forReports = new Test (type1,type1.getCollectingMethod(),client1);
        forReports.addCategory(category1);
        forReports.addParameter(parameter1);
        forReports.setNhsCode("nhsCode-AB02");
        forReports.setCode("000000000002");
        forReports.addTestResult(parameter1.getCode(),"result",1);
        forReports.addResultToList();
        this.company.getTestStore().addTest(forReports);
*/

    }

    public static void runDailyTasks() {
        try {
            new DailyNhsReportController().runDailyTask();
        } catch (FileNotFoundException | NullPointerException e) {
            e.printStackTrace();
        }
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
