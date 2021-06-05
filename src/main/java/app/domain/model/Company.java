package app.domain.model;

import auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * This domain class allows to build an instance of company.
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 * @author Gil <1180838@isep.ipp.pt>
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class Company {

    private List<Store> stores;

    /**
     * The designation of company.
     */
    private String designation;

    /**
     * The AuthFacade of company.
     */
    private AuthFacade authFacade;

    /**
     * The store of Clinical Analysis Laboratory.
     */
    private CALStore calStore;

    /**
     * The store of report.
     */
    private ReportStore reportStore;

    /**
     * The store of create a client.
     */
    private ClientStore clientStore;

    /**
     * The store of parameter category.
     */
    private ParameterCategoryStore parameterCategoryStore;

    /**
     * The store of OrgRole.
     */
    private OrgRoleStore orgRoleStore;

    /**
     * The store of employee.
     */
    private EmployeeStore employeeStore;

    /**
     * The store of parameter.
     */
    private ParameterStore parameterStore;

    /**
     * The store of registered Tests to clients.
     */
    private TestStore testStore;

    /**
     * The store of client's LabOrder.
     */
    private TestTypeStore testTypeStore;

    /**
     * The store of Sample.
     */
    private SampleStore sampleStore;

    /**
     * Constructor Company with the designation.
     *
     * @param designation company's designation
     */

    public Company(String designation)  {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
        this.orgRoleStore = new OrgRoleStore();
        this.stores = new ArrayList<>();

        stores.add(this.authFacade.getUserStore());
        this.reportStore = new ReportStore();
        stores.add(reportStore);
        this.calStore = new CALStore();
        this.clientStore = new ClientStore(this.authFacade);
        stores.add(clientStore);
        this.parameterCategoryStore = new ParameterCategoryStore();
        stores.add(parameterCategoryStore);
        this.employeeStore = new EmployeeStore(this.orgRoleStore,this.authFacade);
        stores.add(employeeStore);
        this.parameterStore = new ParameterStore();
        stores.add(parameterStore);
        this.testStore = new TestStore();
        stores.add(testStore);
        this.testTypeStore = new TestTypeStore();
        stores.add(testTypeStore);
        this.sampleStore = new SampleStore();
        stores.add(sampleStore);


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
    public ClientStore getClientStore() {
        return clientStore;
    }

    /**
     * Change the CreateClient's store.
     *
     * @param clientStore CreateClient's store
     */
    public void setClientStore(ClientStore clientStore) {
        this.clientStore = clientStore;
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
    public TestTypeStore getTestTypeStore() {
        return this.testTypeStore;
    }

    /**
     * Change the TestType's store.
     *
     * @param testTypeStore TestType's Store
     */

    public void setTestTypeStore(TestTypeStore testTypeStore) {
        this.testTypeStore = testTypeStore;
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

    /**
     * Return the OrgRole's store.
     *
     * @return OrgRole's store
     */

    public OrgRoleStore getOrgRoleStore() {
        return this.orgRoleStore;
    }

    /**
     * Return the Test's store.
     *
     * @return Test's store
     */

    public TestStore getTestStore() {
        return this.testStore;
    }

    /**
     * Return the Report's store.
     *
     * @return Report's store
     */

    public ReportStore getReportStore() {
        return this.reportStore;
    }

    /**
     * Return the Sample's store.
     *
     * @return Sample's store
     */

    public SampleStore getSampleStore() {
        return this.sampleStore;
    }

    /**
     * Change the Sample's store.
     *
     * @param sampleStore Sample's store
     */

    public void setSampleStore(SampleStore sampleStore) {
        this.sampleStore = sampleStore;
    }

    public List getListStores () {
        if(stores.size() == 0) throw new IllegalArgumentException("Store list is empty");
        return this.stores;
    }
}
