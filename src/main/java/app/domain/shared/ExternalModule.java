package app.domain.shared;

import app.domain.model.Parameter;
import com.example1.ExternalModule3API;
import com.example2.EMRefValue;
import com.example2.ExternalModule2API;
import com.example3.CovidReferenceValues1API;

import java.util.Date;

public class ExternalModule {

    private final CovidReferenceValues1API crv1;
    private final ExternalModule2API em2;
    private final ExternalModule3API em3;

    private static final int ACCESSKEY = 12345;
    private static final String BLOOD_TEST = "Blood Test";
    private static final String COVID_TEST = "Covid Test";

    public ExternalModule () {
        this.crv1 = new CovidReferenceValues1API();
        this.em2 = new ExternalModule2API();
        this.em3 = new ExternalModule3API();
    }

    public EMRefValue getEMRefValue(String description, Parameter param) {
        if (description.equals(BLOOD_TEST)) {
            String paramId = param.getCode();
            String metric = this.usedMetricBlood(param);
            double minValue = this.getMinReferenceValueBlood(param);
            double maxValue = this.getMaxReferenceValueBlood(param);
            Date date = new Date();
            return new EMRefValue(paramId,metric,minValue,maxValue,date);
        } else if (description.equals(COVID_TEST)) {
            String paramId = param.getCode();
            String metric = this.usedMetricCovid(param);
            double minValue = this.getMinReferenceValueCovid(param);
            double maxValue = this.getMaxReferenceValueCovid(param);
            Date date = new Date();
            return new EMRefValue(paramId,metric,minValue,maxValue,date);
        }
        return null;
    }

    // API 1 - Covid
    public String usedMetricCovid(Parameter param) {
        return this.crv1.usedMetric(param.getCode(), ACCESSKEY);
    }
    public Double getMinReferenceValueCovid(Parameter param) {
        return this.crv1.getMinReferenceValue(param.getCode(), ACCESSKEY);
    }
    public Double getMaxReferenceValueCovid(Parameter param) {
        return this.crv1.getMaxReferenceValue(param.getCode(), ACCESSKEY);
    }

    // API 2 - Blood
    public EMRefValue getReferenceValue(Parameter param) {
        return this.em2.getReferenceFor(param.getCode());
    }
    public EMRefValue getReferenceValue(Parameter param, Date date) {
        return this.em2.getReferenceFor(param.getCode(),date);
    }
    public String getMetricsFor (Parameter param) {
        return this.em2.getMetricsFor(param.getCode());
    }

    // API 3 - Blood
    public String usedMetricBlood(Parameter param) {
        return this.em3.usedMetric(param.getCode(), ACCESSKEY);
    }
    public Double getMinReferenceValueBlood(Parameter param) {
        return this.em3.getMinReferenceValue(param.getCode(), ACCESSKEY);
    }
    public Double getMaxReferenceValueBlood(Parameter param) {
        return this.em3.getMaxReferenceValue(param.getCode(), ACCESSKEY);
    }
}
