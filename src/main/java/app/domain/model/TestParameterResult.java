package app.domain.model;

import com.example2.EMRefValue;

public class TestParameterResult {

    String result;
    double metric;
    EMRefValue refValue;
    public TestParameterResult (String result, double metric, EMRefValue refValue) {
        this.result = result;
        this.metric = metric;
        this.refValue = refValue;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public double getMetric() {
        return metric;
    }

    public void setMetric(double metric) {
        this.metric = metric;
    }

    public EMRefValue getRefValue() {
        return refValue;
    }

    public void setRefValue(EMRefValue refValue) {
        this.refValue = refValue;
    }

    @Override
    public String toString() {
        return "Result: " + result +
                "\nMetric: " + metric +
                "\n" + refValue +
                "\n";
    }
}
