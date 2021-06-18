package app.controller;

import app.domain.dto.TestDto;
import app.domain.dto.TestMapper;
import app.domain.model.*;

import java.util.ArrayList;
import java.util.List;

public class ClientResultViewController {

    private final Company company;
    private final ClientStore cs;
    private final TestStore ts;


    public ClientResultViewController(){
        this.company = App.getInstance().getCompany();
        this.cs = this.company.getClientStore();
        this.ts = this.company.getTestStore();
    }

    public List<Test> listClientTest(TestDto dto) {

        Client c = cs.getClientByCC(dto.getClientCC());
        List<Test> tl = new ArrayList<>();

        for (Test t : ts.getValidatedTests()) {

            if (t.getClient().getCitizenCard() == (c.getCitizenCard())) {
                tl.add(t);
            }
        }

        return tl;
    }

    public List <TestDto> getTest() {
        List<Test> testList = this.ts.getValidatedTests();
        TestMapper mapper = new TestMapper();
        return mapper.toDto(testList);
    }
}
