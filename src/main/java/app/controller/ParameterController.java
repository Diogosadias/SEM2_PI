package app.controller;

import app.domain.model.*;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class ParameterController {

    private Company company;
    private Parameter p;
    private ParameterStore ps;

    public ParameterController(){
        this(App.getInstance().getCompany());
    }

    public ParameterController(Company company){
        this.company = company;
        this.p = null;
        this.ps = company.getParameterStore();
    }

    public boolean createParameter(String code, String name, String description, String category){


        this.p = this.ps.createParameter(code,name,description,category);
        if(this.ps.validateParameter(p)){
            ps.saveParameter(p);
            return true;
        }
        else {
            return false;
        }

    }
    public boolean deleteParameter(String code){
        if(ps.deleteParameter(code)){
            return true;
        }else{
            return false;
        }
    }
    public void writeParameters(){
        System.out.println(ps.toString());

    }

    public Parameter getParameter(String code){

        for(Parameter f : ps.getParameterList()){
            if(f.getCode().equals(code))
                return f;
        }
        return null;
    }

    public boolean saveParameter(){
        return this.ps.saveParameter(p);
    }

}
