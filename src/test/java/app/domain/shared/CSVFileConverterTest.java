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

    CSVFileConverter converter = new CSVFileConverter();

    @Test
    public void convertToObject() {
        Company company = App.getInstance().getCompany();
        company.getTestTypeStore().addTestType(new TestType("Covid","Covid","Covid"));
        ParameterCategory categoryCovid = new ParameterCategory("Covid","Covid Test","21001");
        company.getParameterCategoryStore().addParameterCategory(categoryCovid);
        Parameter parameter8 = new Parameter("IgGAN","IgGAN","Detect presence of antibodies.",categoryCovid.getCode());
        company.getParameterStore().addParameter(parameter8);
        try {
            boolean result = converter.convertToObject("covid.csv");
            Assert.assertTrue(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}