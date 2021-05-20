package app.domain.model;

import app.domain.dto.TestDto;
import app.domain.dto.TestMapper;
import app.domain.shared.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SampleStore {

    private final List<Sample> sampleList;



    Company company;

    public SampleStore(){
        this.sampleList = new ArrayList<>();
    }


    public void setCompany (Company company) {
        this.company = company;
    }

    public Sample createSample() throws IOException {
        return new Sample();
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
}
