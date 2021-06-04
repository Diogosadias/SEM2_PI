package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * This domain class allows to build an instance of parameter category.
 *
 *  @author Márcio Ramos <1201682@isep.ipp.pt>
 *  @author Tiago Ferreira <1200601@isep.ipp.pt>
 *  @author Tiago Rocha <1181445@isep.ipp.pt>
*/
public class ParameterCategory implements Serializable {
    /**
     * code - Parameter Category Code
     */
    private String code;
    /**
     * description - Parameter Category Description
     */
    private String description;
    /**
     * nhsId - Parameter Category's NHS ID
     */
    private String nhsId;

    /**
     * Parameter Category Constructor.
     *
     * @param code - Parameter Category Code
     * @param description - Parameter Category Description
     * @param nhsId - Parameter Category NHS ID
     */
    public ParameterCategory(String code, String description, String nhsId){
        checkCodeRules(code);
        checkDescriptionRules(description);
        this.code = code;
        this.description = description;
        this.nhsId = nhsId;
    }

    /**
     * Method for validating a Code.
     *
     * @param code - Parameter Category Code
     */
    private void checkCodeRules(String code){
        if(StringUtils.isBlank(code))
            throw new IllegalArgumentException("Code cannot be blank");
        if((code.length()<4) || (code.length()> 8))
            throw new IllegalArgumentException("Code must have 4 to 8 characters.");
    }

    /**
     * Method for validating a Description.
     *
     * @param description - Parameter Category Description
     */
    private void checkDescriptionRules(String description){
        if(StringUtils.isBlank(description))
            throw new IllegalArgumentException("Code cannot be blank");
        if(description.length() > 40 )
            throw new IllegalArgumentException("Code must not exceed 40 chars.");
    }

    /**
     * Return the textual description of the parameter category.
     *
     * @return parameter category's features
     */


    @Override
    public String toString() {
        return "ParameterCategory{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", nhsId='" + nhsId + '\'' +
                '}';
    }

    /**
     * Return the ParameterCategory's code.
     *
     * @return ParameterCategory's code
     */
    public String getCode() {
        return code;
    }

    /**
     * Return the ParameterCategory's description.
     *
     * @return ParameterCategory's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Return the ParameterCategory's nhsid.
     *
     * @return ParameterCategory's nhsid
     */
    public String getNhsId() {
        return nhsId;
    }

    /**
     * Change the ParameterCategory's code.
     *
     * @param code ParameterCategory's code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Change the ParameterCategory's description.
     *
     * @param description ParameterCategory's description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Change the ParameterCategory's nhsid.
     *
     * @param nhsId ParameterCategory's nhsid
     */
    public void setNhsId(String nhsId) {
        this.nhsId = nhsId;
    }
    
}