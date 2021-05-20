package app.controller;


import app.domain.dto.TestDto;
import app.domain.dto.TestMapper;
import app.domain.model.*;
import net.sourceforge.barbecue.BarcodeException;
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
        this.sample = null;
        this.tss.setCompany(this.company);
    }

    public Sample createSample(String id) throws IOException, BarcodeException {
        this.sample = this.tss.createSample(id);
        return sample;
    }

    public boolean saveSample(TestDto test) {
        this.tstore = this.company.getTestStore();
        tstore.addSampleToTest(sample, new TestMapper().getTest(test));
        return this.tss.saveSample(sample);
    }

    public List<TestDto> getTests() {
        return this.tstore.getRegisteredTests();
    }
}
