package app.domain.shared;

import app.domain.model.Parameter;
import com.example1.ExternalModule3API;
import com.example2.EMRefValue;
import com.example2.ExternalModule2API;
import com.example3.CovidReferenceValues1API;

import java.util.Date;

public class ExternalModule {

    private CovidReferenceValues1API crv1;
    private ExternalModule2API em2;
    private ExternalModule3API em3;

    private final static int accessKey = 12345;

    public ExternalModule () {
        this.crv1 = new CovidReferenceValues1API();
        this.em2 = new ExternalModule2API();
        this.em3 = new ExternalModule3API();
    }

    // API 1 - Covid
    public String usedMetricCovid(Parameter param) {
        return this.crv1.usedMetric(param.getCode(),this.accessKey);
    }
    public Double getMinReferenceValueCovid(Parameter param) {
        return this.crv1.getMinReferenceValue(param.getCode(),this.accessKey);
    }
    public Double getMaxReferenceValueCovid(Parameter param) {
        return this.crv1.getMaxReferenceValue(param.getCode(),this.accessKey);
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
        return this.em3.usedMetric(param.getCode(),this.accessKey);
    }
    public Double getMinReferenceValueBlood(Parameter param) {
        return this.em3.getMinReferenceValue(param.getCode(),this.accessKey);
    }
    public Double getMaxReferenceValueBlood(Parameter param) {
        return this.em3.getMaxReferenceValue(param.getCode(),this.accessKey);
    }
}
