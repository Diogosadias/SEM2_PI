package app.domain.dto;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 */
public class ParameterDto {

    private String code;
    private String name;

    public ParameterDto(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[ " + name + " ]\n";
    }

}
