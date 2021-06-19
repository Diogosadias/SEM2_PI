package app.domain.model;

import com.example2.EMRefValue;

import java.io.Serializable;

/**
 *
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 */

public class TestParameter implements Serializable {

    /**
     * The parameter of Test Parameter
     */
    private final Parameter param;

    /**
     * The test result of Test Parameter
     */
    private TestParameterResult testResult;

    /**
     * Creates a Test Parameter instance and returns it.
     *
     * @param param TestParameter's parameter
     */

    public TestParameter (Parameter param) {
        this.param = param;
    }

    /**
     * Return the TestParameter's parameter.
     *
     * @return TestParameter's parameter
     */
    public Parameter getParameter() {
        return this.param;
    }

    /**
     * Add a result to Test Parameter.
     *
     * @param result TestParameter's result
     * @param metric TestParameter's metric
     * @param refValue TestParameter's refValue
     *
     * @return boolean
     */

        public boolean addResult(String result, double metric, EMRefValue refValue){
        return (this.testResult = new TestParameterResult(result,metric,refValue)) != null;
    }

    /**
     * Return the TestParameter's result.
     *
     * @return TestParameter's result
     */
    public TestParameterResult getResult() {
        return this.testResult;
    }

    /**
     * Return the textual description of the test parameter.
     *
     * @return TestParameter's features
     */
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
