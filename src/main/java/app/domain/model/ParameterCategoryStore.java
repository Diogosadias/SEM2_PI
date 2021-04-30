package app.domain.model;

import java.util.List;

public class ParameterCategoryStore {

    private List<ParameterCategory> parameterCategoryList;

    public ParameterCategory createParameterCategory(String code, String description, String nhsId){
        return new ParameterCategory(code, description, nhsId);
    }



    public ParameterCategory getParameterCategoryByCode(String code){
        for( ParameterCategory f : parameterCategoryList){
            if(code.equals(f.getCode()))
                return f;
        }
        return null;
    }

    public boolean validateParameterCategory(ParameterCategory pc){
        if(pc == null)
            return false;
        return ! this.parameterCategoryList.contains(pc);
    }

    public boolean saveParameterCategory(ParameterCategory pc){
        if(!validateParameterCategory(pc))
            return false;
        return this.parameterCategoryList.add(pc);
    }

}