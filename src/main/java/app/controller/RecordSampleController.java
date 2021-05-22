package app.controller;


import app.domain.dto.TestDto;
import app.domain.dto.TestMapper;
import app.domain.model.*;
import app.domain.model.stores.SampleStore;
import app.domain.model.stores.TestStore;
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

    public Sample createSample(String id) throws IOException, BarcodeException, OutputException {
        this.sample = this.tss.createSample(id);
        return sample;
    }

    public boolean saveSample(TestDto dto) {
        this.tstore = this.company.getTestStore();
        Test test = this.tstore.getTestByCode(dto.getCode());
        tstore.addSampleToTest(sample, test);
        return this.tss.saveSample(sample);
    }

    public List<TestDto> getTests() {
        List<Test> tests = this.tstore.getRegisteredTests();
        TestMapper mapper = new TestMapper();
        return mapper.toDto(tests);
    }
}
