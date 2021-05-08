package app.domain.model;
import app.domain.model.ParameterCategory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class ParameterCategoryStore {

    private List<ParameterCategory> parameterCategoryList = new ArrayList<>();



    public ParameterCategory createParameterCategory(String code, String description, String nhsId){
        if (code == null && description == null && nhsId == null) return null;
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

    public List<ParameterCategory> getParameterCategoryList() {
        return parameterCategoryList;
    }

    @Override
    public String toString() {

        List<ParameterCategory> copia = new ArrayList<>(parameterCategoryList);


        StringBuilder s = new StringBuilder();
        for (ParameterCategory param : copia) {
            s.append(param);
            s.append("\n");
        }

        return s.toString();
    }
}