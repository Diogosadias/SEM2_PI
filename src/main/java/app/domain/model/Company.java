package app.domain.model;

import auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 * @author Gil <1180838@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */
public class Company {

    private final String designation;
    private final AuthFacade authFacade;
    //STORES
    private CALStore calStore;
    private CreateClientStore createClientStore;
    private ParameterCategoryStore parameterCategoryStore;
    private SpecifyNewTestStore specifyNewTestStore;
    private EmployeeStore employeeStore;
    private ParameterStore parameterStore;

    public Company(String designation)
    {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();

        this.specifyNewTestStore= new SpecifyNewTestStore();
        this.calStore = new CALStore();
        this.createClientStore = new CreateClientStore(this.authFacade);
        this.parameterCategoryStore = new ParameterCategoryStore();
        this.employeeStore = new EmployeeStore();
        this.parameterStore = new ParameterStore();
    }

    public SpecifyNewTestStore getTestTypeStore() {
        return specifyNewTestStore;
    }

    public void setTestTypeStore(SpecifyNewTestStore testTypeStore) {
        this.specifyNewTestStore = testTypeStore;
    }
    
    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    public CALStore getCalStore() {
        return this.calStore;
    }

    public void setCalStore(CALStore calStore) {
        this.calStore = calStore;
    }

    public CreateClientStore getCreateClientStore() {
        return createClientStore;
    }

    public void setCreateClientStore(CreateClientStore createClientStore) {
        this.createClientStore = createClientStore;
    }

    public ParameterCategoryStore getParameterCategoryStore() {
        return parameterCategoryStore;
    }

    public void setParameterCategoryStore(ParameterCategoryStore parameterCategoryStore) {
        this.parameterCategoryStore = parameterCategoryStore;
    }

    public SpecifyNewTestStore getSpecifyNewTestStore() {
        return specifyNewTestStore;
    }

    public void setSpecifyNewTestStore(SpecifyNewTestStore specifyNewTestStore) {
        this.specifyNewTestStore = specifyNewTestStore;
    }

    public EmployeeStore getEmployeeStore() {
        return employeeStore;
    }

    public void setEmployeeStore(EmployeeStore employeeStore) {
        this.employeeStore = employeeStore;
    }

    public ParameterStore getParameterStore() {
        return parameterStore;
    }

    public void setParameterStore(ParameterStore parameterStore) {
        this.parameterStore = parameterStore;
    }
}
