package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class ParameterStore {
    private List<Parameter> parameterList = new ArrayList<>();



    public Parameter createParameter(String code, String name, String description, String category){
        return new Parameter(code, name, description,category);
    }



    public Parameter getParameterByCode(String code){
        for( Parameter f : parameterList){
            if(code.equals(f.getCode()))
                return f;
        }
        return null;
    }

    public boolean validateParameter(Parameter p){
        if(p == null)
            return false;
        return ! this.parameterList.contains(p);
    }

    public boolean saveParameter(Parameter p){
        if(!validateParameter(p))
            return false;
        return this.parameterList.add(p);
    }

    public List<Parameter> getParameterList() {
        return parameterList;
    }

    @Override
    public String toString() {

        List<Parameter> copia = new ArrayList<>(parameterList);
        StringBuilder s = new StringBuilder();

        for (Parameter param : copia) {
            s.append(param);
            s.append("\n");
        }

        return s.toString();
    }
}