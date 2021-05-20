package app.domain.model;

import app.domain.dto.TestDto;
import app.domain.dto.TestMapper;
import app.domain.shared.BarcodeAPI;
import app.domain.shared.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SampleStore implements BarcodeAPI {

    private final List<Sample> sampleList;
    private Test test;


    Company company;

    public SampleStore(){
        this.sampleList = new ArrayList<>();
    }


    public void setCompany (Company company) {
        this.company = company;
    }

    public Sample createSample() throws IOException {
        Sample sample = new Sample();

        return sample;
    }

    public boolean saveSample(Sample sample){
        if(sampleList.add(sample))
            return true;
        else
            return false;
    }

    public List<TestDto> getTests() {

        List<Test> tests = this.company.getTestStore().getTests(Constants.REGISTERED);

        TestMapper mapper = new TestMapper();
        return mapper.toDto(tests);
    }

    public void writeTest(TestDto testdto){
        this.test = this.company.getTestStore().getTestByCode(testdto.getCode());
    }
}
