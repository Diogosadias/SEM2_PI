package app.controller;


import app.domain.dto.TestDto;
import app.domain.dto.TestMapper;
import app.domain.model.*;

import java.io.IOException;
import java.util.List;
public class RecordSampleController {

    private Company company;
    private SampleStore ts;
    private Sample sample;
    public TestStore tstore = new TestStore();

    public RecordSampleController(Company company) {
        this.company = company;
        this.sample = null;
        this.ts = company.getSampleStore();
    }

    public RecordSampleController(){}

    public boolean createSample() throws IOException {
        this.sample = this.ts.createSample();
        return true;
    }

    public boolean saveSample(Test test) {
        tstore.addSampletoTest(sample, test);
        return this.ts.saveSample(sample);
    }


    public List<TestDto> getTests() {
        List<Test> tests = this.tstore.getTests("Introduz aqui state does Dtos");
        TestMapper mapper = new TestMapper();
        return mapper.toDto(tests);
    }
}
