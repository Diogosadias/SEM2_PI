package app.controller;


import app.domain.dto.TestDto;
import app.domain.dto.TestMapper;
import app.domain.model.*;
import app.domain.shared.Constants;

import java.io.IOException;
import java.util.List;
public class RecordSampleController {

    private Company company;
    private SampleStore tss;
    private Sample sample;
    public TestStore tstore = new TestStore();

    public RecordSampleController(Company company) {
        this.company = company;
        this.sample = null;
        this.tss = this.company.getSampleStore();
    }

    public RecordSampleController(){}

    public boolean createSample() throws IOException {
        this.sample = this.tss.createSample();
        return true;
    }

    public boolean saveSample(Test test) {
        tstore.addSampletoTest(sample, test);
        return this.tss.saveSample(sample);
    }

    public SampleStore getSampleStore(){
        return this.tss;
    }


}
