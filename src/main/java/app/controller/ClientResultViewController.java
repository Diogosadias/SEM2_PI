package app.controller;

import app.domain.dto.ClientDTO;
import app.domain.dto.ClientMapper;
import app.domain.dto.TestDto;
import app.domain.dto.TestMapper;
import app.domain.model.*;
import auth.domain.model.Email;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class ClientResultViewController {

    private final Company company;
    private final ClientStore cs;
    private final TestStore ts;
    private Client client;

    public ClientResultViewController(){
        this.company = App.getInstance().getCompany();
        this.cs = this.company.getClientStore();
        this.ts = this.company.getTestStore();
    }

    public Client getClient(){
        Email id = App.getInstance().getCurrentUserSession().getUserId();
        this.client= cs.getClientByID(id);
        return client;
    }

    public List<Test> listClientTest(Client cl) {

        Client c = cs.getClientByTIN(cl.getTin());
        List<Test> tl = new ArrayList<>();
        for(Test t : ts.getValidatedTests()){

            if(t.getClient().getName().equalsIgnoreCase(c.getName())){
                tl.add(t);
            }
        }

        return tl;
    }

    public List <TestDto> toDTO(List<Test> testList) {
        TestMapper mapper = new TestMapper();
        return mapper.toDto(testList);
    }

   /* public List <TestDto> getTest() {
        List<Test> testList = this.ts.getValidatedTests();
        TestMapper mapper = new TestMapper();
        return mapper.toDto(testList);
    }*/
}
