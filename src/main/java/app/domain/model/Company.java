package app.domain.model;

import auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;

/**
 * This domain class allows to build an instance of company.
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 * @author Gil <1180838@isep.ipp.pt>
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 */
public class Company {

    /**
     * The designation of company.
     */
    private final String designation;

    /**
     * The AuthFacade of company.
     */
    private final AuthFacade authFacade;

    /**
     * The store of Clinical Analysis Laboratory.
     */
    private CALStore calStore;

    /**
     * The store of create a client.
     */
    private CreateClientStore createClientStore;

    /**
     * The store of parameter category.
     */
    private ParameterCategoryStore parameterCategoryStore;

    /**
     * The store of specify new test type.
     */
    private SpecifyNewTestStore specifyNewTestStore;

    /**
     * The store of employee.
     */
    private EmployeeStore employeeStore;

    /**
     * The store of parameter.
     */
    private ParameterStore parameterStore;

    /**
     * Constructor Company with the designation.
     *
     * @param designation company's designation
     */

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

    /**
     * Return the SpecifyNewTest's store.
     *
     * @return SpecifyNewTest's store
     */
    public SpecifyNewTestStore getTestTypeStore() {
        return specifyNewTestStore;
    }

    /**
     * Change the TestType's store.
     *
     * @param testTypeStore TestType's store
     */
    public void setTestTypeStore(SpecifyNewTestStore testTypeStore) {
        this.specifyNewTestStore = testTypeStore;
    }

    /**
     * Return the company's designation.
     *
     * @return company's designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Return the company's AuthFacade.
     *
     * @return company's AuthFacade
     */
    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    /**
     * Return the ClinicalAnalysisLaboratory's store.
     *
     * @return ClinicalAnalysisLaboratory's store
     */
    public CALStore getCalStore() {
        return this.calStore;
    }

    /**
     * Change the ClinicalAnalysisLaboratory's store.
     *
     * @param calStore ClinicalAnalysisLaboratory's store
     */
    public void setCalStore(CALStore calStore) {
        this.calStore = calStore;
    }

    /**
     * Return the Createclient's store.
     *
     * @return Createclient's store
     */
    public CreateClientStore getCreateClientStore() {
        return createClientStore;
    }

    /**
     * Change the CreateClient's store.
     *
     * @param createClientStore CreateClient's store
     */
    public void setCreateClientStore(CreateClientStore createClientStore) {
        this.createClientStore = createClientStore;
    }

    /**
     * Return the ParameterCategory's store.
     *
     * @return ParameterCategory's store
     */
    public ParameterCategoryStore getParameterCategoryStore() {
        return parameterCategoryStore;
    }

    /**
     * Change the ParameterCategory's store.
     *
     * @param parameterCategoryStore ParameterCategory's store
     */
    public void setParameterCategoryStore(ParameterCategoryStore parameterCategoryStore) {
        this.parameterCategoryStore = parameterCategoryStore;
    }

    /**
     * Return the SpecifyNewTest's store.
     *
     * @return SpecifyNewTest's store
     */
    public SpecifyNewTestStore getSpecifyNewTestStore() {
        return specifyNewTestStore;
    }

    /**
     * Change the SpecifyNewTest's store.
     *
     * @param specifyNewTestStore SpecifyNewTest's store
     */
    public void setSpecifyNewTestStore(SpecifyNewTestStore specifyNewTestStore) {
        this.specifyNewTestStore = specifyNewTestStore;
    }

    /**
     * Return the Employee's store.
     *
     * @return Employee's store
     */
    public EmployeeStore getEmployeeStore() {
        return employeeStore;
    }

    /**
     * Change the Employee's store.
     *
     * @param employeeStore Employee's store
     */
    public void setEmployeeStore(EmployeeStore employeeStore) {
        this.employeeStore = employeeStore;
    }

    /**
     * Return the Parameter's store.
     *
     * @return Parameter's store
     */
    public ParameterStore getParameterStore() {
        return parameterStore;
    }

    /**
     * Change the Parameter's store.
     *
     * @param parameterStore Parameter's store
     */
    public void setParameterStore(ParameterStore parameterStore) {
        this.parameterStore = parameterStore;
    }
}
