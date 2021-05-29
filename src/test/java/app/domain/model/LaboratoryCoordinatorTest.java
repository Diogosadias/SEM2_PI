package app.domain.model;

import app.domain.shared.Constants;
import auth.AuthFacade;
import org.junit.Test;

import java.util.Properties;

import static app.domain.shared.Constants.*;
import static app.domain.shared.Constants.SPECIALIST_DOCTOR;
import static java.lang.System.getProperties;
import static org.junit.Assert.*;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class LaboratoryCoordinatorTest {
    Company company;
    AuthFacade authFacade;

    @Test
    public void testLaboratoryCoordinator(){

        company = new Company("Many labs");
        company.getOrgRoleStore().addOrgRole(new OrgRole(RECEPTIONIST,MODEL_CLASS_PATH +"" + RECEPTIONIST));
        Receptionist employee1 = new Receptionist(this.company.getOrgRoleStore().getRoleById(RECEPTIONIST), "R00001", "Receptionist1","R1-address",12900000001L,"R1-soc");

        LaboratoryCoordinator test1 = new LaboratoryCoordinator(employee1);
        LaboratoryCoordinator test2 = new LaboratoryCoordinator(this.company.getOrgRoleStore().getRoleById(RECEPTIONIST), "R00001", "Receptionist1","R1-address",12900000001L,"R1-soc");
    }
}