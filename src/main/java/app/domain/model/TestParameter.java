package app.domain.model;

import com.example2.EMRefValue;

/**
 *
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 */

public class TestParameter {

    private final Parameter param;

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
