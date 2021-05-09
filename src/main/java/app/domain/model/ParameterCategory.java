package app.domain.model;

import org.apache.commons.lang3.StringUtils;
/**
 *
 *  @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class ParameterCategory {
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
     * @param description - Parameter Category Description
     */
    private void checkDescriptionRules(String description){
        if(StringUtils.isBlank(description))
            throw new IllegalArgumentException("Code cannot be blank");
        if(description.length() > 40 )
            throw new IllegalArgumentException("Code must not exceed 40 chars.");
    }

    @Override
    public String toString() {
        return "ParameterCategory{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", nhsId='" + nhsId + '\'' +
                '}';
    }

    /**
     * Getters and Setters
     */

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getNhsId() {
        return nhsId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNhsId(String nhsId) {
        this.nhsId = nhsId;
    }
    
}