package app.controller;


import app.domain.dto.TestDto;
import app.domain.dto.TestMapper;
import app.domain.model.*;
import app.domain.shared.Constants;

import java.io.IOException;
import java.util.List;

import static app.domain.shared.Constants.*;

public class RecordSampleController {

    private Company company;
    private SampleStore tss;
    private Sample sample;
    public TestStore tstore;

    public RecordSampleController() {
        if (!App.getInstance().getCurrentUserSession().isLoggedInWithRole(ROLE_MED_LAB_TECH)) {
            throw new IllegalStateException("Utilizador nï¿½o Autorizado");
        }
        this.company = App.getInstance().getCompany();
        this.tss = this.company.getSampleStore();
        this.sample = null;
        this.tss.setCompany(this.company);

    }

    public Sample createSample() throws IOException {
        this.sample = this.tss.createSample();
        return sample;
    }

    public boolean saveSample(Test test) {
        this.tstore = this.company.getTestStore();
        tstore.addSampletoTest(sample, test);
        return this.tss.saveSample(sample);
    }

    public SampleStore getSampleStore(){
        return this.tss;
    }

    public void convertDtoToTest(TestDto t){ tss.writeTest(t);}


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
