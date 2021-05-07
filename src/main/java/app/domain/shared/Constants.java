package app.domain.shared;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String ROLE_ADMIN = "ADMINISTRATOR";
    public static final String ROLE_RECEP = "RECEPTIONIST";
    public static final String ROLE_CLIENT = "CLIENT";

    public static final String PARAMS_FILENAME = "config.properties";
    public static final String PARAMS_COMPANY_DESIGNATION = "Company.Designation";

    public static final String ANS_YES = "Y";
    public static final String ANS_NO = "N";
}
