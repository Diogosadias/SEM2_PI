package app.domain.model;

public class Parameter {
    private String code;
    private String name;
    private String description;
    private String category;

    public Parameter(String code, String name, String description, String category){
        this.code= code;
        this.name= name;
        this.description= description;
        this.category= category;
    }
    //gets:
    public String getCode(){return code;}
    public String getName(){return name;}
    public String getDescription(){return description;}
    public String getCategory(){return category;}

    //sets:
    public void setCode(String code){this.code=code;}
    public void setName(String name){this.name=name;}
    public void setDescription(String description){this.description=description;}
    public void setCategory(String category){this.category=category;}

    @Override
    public String toString() {
        return "ParameterCategory{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='"+ category + '\''+
                '}';
    }
}
