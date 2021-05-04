package app.controller;

import app.domain.model.Company;
import app.domain.shared.Constants;
import auth.AuthFacade;
import auth.UserSession;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 * @author Gil <1180838@isep.ipp.pt>
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
        this.authFacade.addUserRole(Constants.ROLE_ADMIN,Constants.ROLE_ADMIN);
        this.authFacade.addUserRole(Constants.ROLE_RECEP,Constants.ROLE_RECEP);
        this.authFacade.addUserRole(Constants.ROLE_CLIENT,Constants.ROLE_CLIENT);


        this.authFacade.addUserWithRole("Admin", "admin@lei.pt", "495", Constants.ROLE_ADMIN);
        this.authFacade.addUserWithRole("Client", "client@lei.sem2.pt", "123",Constants.ROLE_RECEP);
        this.authFacade.addUserWithRole("Client1","clei@sd.pt","123",Constants.ROLE_CLIENT);
        this.authFacade.addUserWithRoles("SuperUser", "superuser@super.user", "123456", new String[] { Constants.ROLE_CLIENT,Constants.ROLE_ADMIN, Constants.ROLE_RECEP });
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
