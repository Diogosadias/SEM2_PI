package app.controller;

import app.domain.dto.ClientDTO;
import app.domain.dto.ClientMapper;
import app.domain.dto.TestDto;
import app.domain.dto.TestMapper;
import app.domain.model.*;
import app.domain.shared.SortAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OverviewAnalyzeTestsController {



    private final Company company;
    private final ClientStore cs;
    private final TestStore ts;


    public OverviewAnalyzeTestsController(){
        this.company = App.getInstance().getCompany();
        this.cs = this.company.getClientStore();
        this.ts = this.company.getTestStore();
    }

    public List<Test> listClientTest(ClientDTO dto){

        Client c = cs.getClientByTIN(dto.getTin());
        List<Test> tl = new ArrayList<>();

        for(Test t : ts.getValidatedTests()){

            if(t.getClient().getName().equalsIgnoreCase(c.getName())){
                tl.add(t);
            }
        }

        return tl;
    }




    public List <ClientDTO> getClient() {
        List<Client> client = this.cs.getClientList();
        ClientMapper mapper = new ClientMapper();
        return mapper.toDto(client);
    }

}
