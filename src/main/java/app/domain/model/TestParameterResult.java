package app.domain.model;

import com.example2.EMRefValue;

import java.io.Serializable;


public class TestParameterResult  implements Serializable {

    /**
     * The result of TestParameterResult.
     */
    private String result;

    /**
     * The metric of TestParameterResult.
     */
    private double metric;

    /**
     * The refValue of TestParameterResult.
     */
    private EMRefValue refValue;

    /**
     * Constructor TestParameterResult with the result, metric, refValue.
     *
     * @param result TestParameterResult's result
     * @param metric TestParameterResult's metric
     * @param refValue TestParameterResult's refValue
     */
    public TestParameterResult (String result, double metric, EMRefValue refValue) {
        this.result = result;
        this.metric = metric;
        this.refValue = refValue;
    }

    /**
     * Return the TestParameterResult's result.
     *
     * @return TestParameterResult's result
     */
    public String getResult() {
        return result;
    }

    /**
     * Change the TestParameterResult's result.
     *
     * @param result - TestParameterResult's result
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * Return the TestParameterResult's metric.
     *
     * @return TestParameterResult's metric
     */
    public double getMetric() {
        return metric;
    }

    /**
     * Change the TestParameterResult's metric.
     *
     * @param metric - TestParameterResult's metric
     */
    public void setMetric(double metric) {
        this.metric = metric;
    }

    /**
     * Return the TestParameterResult's refValue.
     *
     * @return TestParameterResult's refValue
     */
    public EMRefValue getRefValue() {
        return refValue;
    }

    /**
     * Change the TestParameterResult's refValue.
     *
     * @param refValue - TestParameterResult's refValue
     */
    public void setRefValue(EMRefValue refValue) {
        this.refValue = refValue;
    }

    /**
     * Return the textual description of the test parameter result.
     *
     * @return TestParameterResult's features
     */
    @Override
    public String toString() {
        return "Result: " + result +
                "\nMetric: " + metric +
                "\n" + refValue +
                "\n";
    }
}
