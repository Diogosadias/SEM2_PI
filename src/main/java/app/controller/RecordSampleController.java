package app.controller;


import app.domain.dto.ClientDTO;
import app.domain.dto.TestDto;
import app.domain.dto.TestMapper;
import app.domain.model.*;
import app.domain.model.SampleStore;
import app.domain.model.TestStore;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import static app.domain.shared.Constants.ROLE_MED_LAB_TECH;

/**
 * RecordSampleController - Controller for US5, registering a sample to a test.
 *
 * @author Gil Pereira
 * @author Tiago Ferreira
 */
public class RecordSampleController {

    private final Company company;
    private final SampleStore sampleStore;
    private final TestStore testStore;
    private final ClientStore clientStore;
    private Sample sample;

    public RecordSampleController() {
        this.company = App.getInstance().getCompany();
        this.sampleStore = this.company.getSampleStore();
        this.testStore = this.company.getTestStore();
        this.clientStore = this.company.getClientStore();
    }

    public Sample createSample(String id, String testCode) throws IOException, BarcodeException, OutputException {
        this.testStore.setTest(this.testStore.getTestByCode(testCode));
        this.sample = this.sampleStore.createSample(id);

        return sample;
    }

    public boolean saveSample() {
        if(this.sampleStore.saveSample(this.sample)) {

            return this.testStore.addSampleToTest(sample);
        }
        System.out.println("\nSample is already registered in Test.");
        return false;
    }

    public List<TestDto> getTests() {
        List<Test> tests = this.testStore.getRegisteredTests();
        TestMapper mapper = new TestMapper();
        return mapper.registeredToDto(tests);
    }

    public List<TestDto> listTestSamples() {
        List<Test> tests = this.testStore.getSampleCollectedTests();
        TestMapper mapper = new TestMapper();
        return mapper.testSamplesToDto(tests);
    }

    public String getTestClientNameByCC(long cc){
        return this.clientStore.getClientByCC(cc).getName();
    }

    public Company getCompany() {
        return this.company;
    }



}
