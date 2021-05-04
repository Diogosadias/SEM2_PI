package app.domain.model;

public class Parameter {
    private String code;
    private String name;
    private String description;
    private String categoryselect;

    public Parameter(String code, String name, String description){
        this.code= code;
        this.name= name;
        this.description= description;


    }
    //gets:
    public String getCode(){return code;}
    public String getName(){return name;}
    public String getDescription(){return description;}

    //sets:
    public void setCode(String code){this.code=code;}
    public void setName(String name){this.name=name;}
    public void setDescription(String description){this.description=description;}

}
