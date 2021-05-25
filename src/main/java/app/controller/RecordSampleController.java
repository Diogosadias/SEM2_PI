package app.controller;


import app.domain.dto.TestDto;
import app.domain.dto.TestMapper;
import app.domain.model.*;
import app.domain.model.SampleStore;
import app.domain.model.TestStore;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.util.List;

import static app.domain.shared.Constants.ROLE_MED_LAB_TECH;

/**
 * RecordSampleController - Controller for US5, registering a sample to a test.
 *
 * @author Gil Pereira
 */
public class RecordSampleController {

    private Company company;
    private SampleStore tss;
    private Sample sample;
    public TestStore tstore;

    public RecordSampleController() {
        if (!App.getInstance().getCurrentUserSession().isLoggedInWithRole(ROLE_MED_LAB_TECH)) {
            throw new IllegalStateException("Access Unauthorized!");
        }
        this.company = App.getInstance().getCompany();
        this.tss = this.company.getSampleStore();
        this.tstore = this.company.getTestStore();
    }

    public Sample createSample(String id, String testCode) throws IOException, BarcodeException, OutputException {
        this.tstore.setTest(testCode);
        this.sample = this.tss.createSample(id);
        return sample;
    }

    public boolean saveSample() {
        if(this.tss.saveSample(this.sample)) {
            return this.tstore.addSampleToTest(sample);
        }
        System.out.println("\nSample is already registered in Test.");
        return false;
    }

    public List<TestDto> getTests() {
        List<Test> tests = this.tstore.getRegisteredTests();
        TestMapper mapper = new TestMapper();
        return mapper.toDto(tests);
    }

    public List<TestDto> listTestSamples() {
        List<Test> tests = this.tstore.getSampleCollectedTests();
        TestMapper mapper = new TestMapper();
        return mapper.testSamples_toDto(tests);
    }

    public Company getCompany() {
        return this.company;
    }

}
