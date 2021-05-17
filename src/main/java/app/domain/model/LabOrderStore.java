package app.domain.model;

import java.util.List;

public class LabOrderStore {

    private List<LabOrder> orders;

    public LabOrderStore () {

    }

    public LabOrder getClientLabOrder(Client client) {
        for (LabOrder order : orders) {
            if (order.getClient().equals(client));
        }
        throw new IllegalArgumentException("Client doesnt have Lab Order registered.");
    }

}
