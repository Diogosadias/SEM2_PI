package app.domain.model;

import com.example2.EMRefValue;

public class TestParameter {

    private Parameter param;

    private Report report;

    private TestParameterResult testResult;

    public TestParameter (Parameter param) {
        this.param = param;
    }

    public Parameter getParameter() {
        return this.param;
    }

    public boolean addResult(String result, double metric, EMRefValue refValue){
        return (this.testResult = new TestParameterResult(result,metric,refValue)) != null;
    }

    public TestParameterResult getResult() {
        return this.testResult;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Report getReport() {
        return this.report;
    }

    @Override
    public String toString () {
        String s = "Test Result: \n" +
                "Parameter: " + this.param + "\n";
        if(testResult != null) {
            s += this.testResult;
        }
        return s;
    }
}
