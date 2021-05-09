package app.domain.model;

/**
 * This domain class allows to build an instance of parameter.
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class Parameter {

    /**
     * The code of parameter.
     */
    private String code;

    /**
     * The name of parameter.
     */
    private String name;

    /**
     * The description of parameter.
     */
    private String description;

    /**
     * The category of parameter.
     */
    private String category;

    /**
     * Constructor Parameter with the code, name, description and the category.
     *
     * @param code parameter's code
     * @param name parameter's name
     * @param description parameter's description
     * @param category parameter's category
     */
    public Parameter(String code, String name, String description, String category){
        this.code= code;
        this.name= name;
        this.description= description;
        this.category= category;
    }

    /**
     * Return the parameter's code.
     *
     * @return parameter's code
     */
    public String getCode(){return code;}

    /**
     * Return the parameter's name.
     *
     * @return parameter's name
     */
    public String getName(){return name;}

    /**
     * Return the parameter's description.
     *
     * @return parameter's description
     */
    public String getDescription(){return description;}

    /**
     * Return the parameter's category.
     *
     * @return parameter's category
     */
    public String getCategory(){return category;}

    /**
     * Change the parameter's code.
     *
     * @param code parameter's code
     */
    public void setCode(String code){this.code=code;}

    /**
     * Change the parameter's name.
     *
     * @param name paraemter's name
     */
    public void setName(String name){this.name=name;}

    /**
     * Change the parameter's description.
     *
     * @param description parameter's description
     */
    public void setDescription(String description){this.description=description;}

    /**
     * Change the parameter's category.
     *
     * @param category parameter's category
     */
    public void setCategory(String category){this.category=category;}

    /**
     * Return the textual description of the parameter.
     *
     * @return parameter's features
     */
    @Override
    public String toString() {
        return "Parameter{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='"+ category + '\''+
                '}';
    }
}
