package app.domain.model;

import auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class Company {

    private String designation;
    private AuthFacade authFacade;

    /**
     * * list of CAL
     */
    //O QUE ESTIVER COMENTADO AINDA NÃO ESTÁ TERMINADO
    //private List<CAL> calList;

    public Company(String designation)
    {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
    }

    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }


    public SpecifyNewTypeTestStore getSpecifyNewTypeTestStore(SpecifyNewTypeTestStore tpl){
        return tpl;
        }


    /*public CAL registerNewCAL(String LabName,String Address,int PhoneNumber,int TINNumber){
        return new CAL(LabName,Address,PhoneNumber,TINNumber);
    }
    public boolean validateCLA(CAL CAL){
        if(CAL == null)
            return false;
        return ! this.calList.contains(CAL);
    }
    public boolean saveCAL(CAL CAL){
        if(!validateCLA(CAL))
            return false;
        return this.calList.add(CAL);
    }
    private boolean addCAL(CAL CAL){
        if(!validateCLA(CAL))
            return false;
        return this.calList.add(CAL); //???
    }
*/

}
