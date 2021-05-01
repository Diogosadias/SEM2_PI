package app.domain.model;

import org.apache.commons.lang3.StringUtils;

public class ParameterCategory {


    private String code;
    private String description;
    private String nhsId;

    public ParameterCategory(String code, String description, String nhsId){
        checkCodeRules(code);
        checkDescriptionRules(description);
        this.code = code;
        this.description = description;
        this.nhsId = nhsId;
    }

    private void checkCodeRules(String code){
        if(StringUtils.isBlank(code))
            throw new IllegalArgumentException("Code cannot be blank");
        if((code.length()<4) || (code.length()> 8))
        throw new IllegalArgumentException("Code must have 4 to 8 characters.");
    }

    private void checkDescriptionRules(String description){
        if(StringUtils.isBlank(description))
            throw new IllegalArgumentException("Code cannot be blank");
        if(code.length() > 40 )
        throw new IllegalArgumentException("Code must not exceed 40 chars.");
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getNhsId() {
        return nhsId;
    }
}