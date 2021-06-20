package app.domain.shared;

import java.text.SimpleDateFormat;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 */
public class Constants {

    //User roles
    public static final String ROLE_ADMIN = "Administrator";
    public static final String ROLE_RECEP = "Receptionist";
    public static final String ROLE_CLIENT = "CLIENT";
    public static final String ROLE_EMPLOYEE = "EMPLOYEE";
    public static final String ROLE_SPEC_DOCTOR = "SpecialistDoctor";
    public static final String ROLE_LAB_COORDINATOR = "LaboratoryCoordinator";
    public static final String ROLE_CHEM_TECH = "ChemistryTechnologist";
    public static final String ROLE_MED_LAB_TECH = "MedicalLabTechnician";

    public static final String PARAMS_FILENAME = "config.properties";
    public static final String PARAMS_COMPANY_DESIGNATION = "Company.Designation";

    //Org Roles
    public static final String SPECIALIST_DOCTOR = "SpecialistDoctor";
    public static final String LABORATORY_COORDINATOR = "LaboratoryCoordinator";
    public static final String CHEMISTRY_TECHNOLOGIST = "ChemistryTechnologist";
    public static final String MEDICAL_LAB_TECHNICIAN = "MedicalLabTechnician";
    public static final String RECEPTIONIST = "Receptionist";
    public static final String ADMINISTRATOR = "Administrator";

    public static final String ANS_YES = "Y";
    public static final String ANS_NO = "N";

    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("EEEE, yyyy-MM-dd HH:mm:ss");

    public static final String EMAIL_SUFIX = "@lei.pt";
    public static final String MODEL_CLASS_PATH = "app.domain.model.";

    //Test - states
    public static final String REGISTERED = "Registered";
	public static final String SAMPLE_COLLECTED = "Sample Collected";
    public static final String SAMPLE_ANALYSED = "Sample Analysed";
    public static final String DIAGNOSIS_MADE = "Diagnosis Made";
    public static final String VALIDATED = "Validated";

    //Numbers
    public static final int DIGITS_NHS = 10;
    public static final int DIGITS_CC = 16;
    public static final int DIGITS_TIN = 10;
    public static final int DIGITS_PHONE_NUM = 11;
    public static final int CHARS_LAB_ID = 5;
    public static final int CHARS_LAB_NAME = 20;
    public static final int CHARS_LAB_ADDRESS = 30;
    public static final int CHARS_LAB_TAX_ID = 10;

    //JAVAFX - gui constants
    public static final double MINIMUM_WINDOW_WIDTH = 800.0;
    public static final double MINIMUM_WINDOW_HEIGHT = 500.0;
    public static final double SCENE_WIDTH = 800;
    public static final double SCENE_HEIGHT = 600.0;
    public static final String TOTAL_TESTS = "Total Tests";
    public static final String DIAGNOSIS_TESTS = "Tests waiting for diagnosis";
    public static final String RESULT_TESTS = "Tests waiting for results";
    public static final String GRAPH_DATE = "Date";
    public static final String DAILY_CHART = "Daily Chart";
    public static final String WEEKLY_CHART = "Weekly Chart";
    public static final String MONTHLY_CHART = "Monthly Chart";
    public static final String YEARLY_CHART = "Yearly Chart";
    public static final String WAITING_TESTS = "Waiting tests";
}
