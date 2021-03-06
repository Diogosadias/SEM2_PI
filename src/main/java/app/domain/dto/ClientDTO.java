package app.domain.dto;

/**
 *
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 *  @author Márcio Ramos <1201682@isep.ipp.pt>
 */

public class ClientDTO {
    /**
     * The name of client.
     */
    private final String name;

    /**
     * The tin of client.
     */
    private final long tin;

    public ClientDTO(String name, long tin ){
        this.name = name;
        this.tin = tin;

    }


    public String getName() {
        return name;
    }

    public long getTin() {
        return tin;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "name='" + name + '\'' +
                ", tin=" + tin ;
    }

    public String toStringNameAndTIN() {
        return name +", TIN: " + tin ;
    }


}
