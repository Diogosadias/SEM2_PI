package app.domain.shared;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.model.TestType;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class CSVFileConverterTest {

    @Test
    public void convertToObject() throws FileNotFoundException {
        CSVFileConverter conv = new CSVFileConverter();
        Company company = App.getInstance().getCompany();
        ParameterCategory categoryCovid = new ParameterCategory("Covid","Covid Test","21001");
        company.getParameterCategoryStore().addParameterCategory(categoryCovid);
        Parameter parameter = new Parameter("IgGAN","IgGAN","Detect presence of antibodies.",categoryCovid.getCode());
        company.getParameterStore().addParameter(parameter);
        TestType type = new TestType("Covid","Covid Test","Sample");
        company.getTestTypeStore().addTestType(type);
        boolean result = conv.convertToObject("covid.csv");
        Assert.assertTrue(result);
    }
}