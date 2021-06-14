package app.domain.dto;


import app.domain.model.Client;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 */



public class ClientMapper {

    public List toDto(List<Client> list) {
        List <ClientDTO> clientDto = new ArrayList<>();

        for(Client c : list){
            String name = c.getName();
            long tin = c.getTin();

            ClientDTO dto = new ClientDTO(name,tin);
            clientDto.add(dto);
        }
          return clientDto;
    }
}
