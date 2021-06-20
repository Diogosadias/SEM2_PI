package app.domain.shared;

import app.controller.App;
import app.domain.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;


public class CovidReportMapperTest {

    private CovidReportMapper mapper = new CovidReportMapper(App.getInstance().getCompany());
    private String varIndependent = "Registered Tests";
    private String historic = "Daily";
    private Date initialDate = new Date("2021/05/3");
    private Date finalDate = new Date("2021/05/13");
    private int histPoints = 15;
    private double alpha = 0.05;
    private app.domain.model.Test test1;

    public CovidReportMapperTest () {
        Client client1 = new Client(1234567890987654L,new Date("1/1/1990"));
        Parameter parameter1 = new Parameter("P0001","Cat1");
        TestType type = new TestType("Covid","Covid","Sample");
        test1 = new app.domain.model.Test(type,type.getCollectingMethod(),client1);
        test1.addParameter(parameter1);
        test1.setNhsCode("123456789012");
        test1.addTestResult(parameter1.getCode(),"result",1.5);
        test1.addResultToList();
        test1.testDiagnosisCompleted();
        test1.isValidated();
        App.getInstance().getCompany().getTestStore().addTest(test1);
    }

    @Test
    public void startNewReport() {
        System.out.println(" startNewReport");
        boolean result = mapper.startNewReport(initialDate,finalDate,histPoints,alpha);
        Assert.assertTrue(result);
    }
/*
    @Test
    public void getData() {
        System.out.println("getData");
        mapper.startNewReport(initialDate,finalDate,histPoints,alpha);

        String result = mapper.getData();
        String expected = fileData();
        System.out.println(expected);
        Assert.assertEquals(expected,result);
    }
*/
    @Test
    public void doLinearRegression() {
    }

    @Test
    public void getHistoricValues() {
    }

    @Test
    public void setN() {
    }

    private String fileData() {
        return  " === Linear Regression - Daily - Registered Tests === \n" +
                "\n" +
                "The regression model fitted using data from the interval \n" +
                "^y = a + bx <=> ^y = NaN + NaN * x\n" +
                "b = NaN\n" +
                "a = NaN\n" +
                "//\n" +
                "Other statistics\n" +
                "R2 = NaN\n" +
                "R2adjusted = ...\n" +
                "R = NaN\n" +
                "//\n" +
                "Hypothesis tests for regression coefficients\n" +
                "HO:b=0 (a=0) H1: b<>0 (a<>0)\n" +
                "t_obs = 2,3060\n" +
                "Decision: Error\n" +
                "//\n" +
                "Significance model with Anova\n" +
                "H0: b=0  H1:b<>0\n" +
                "\t\t\tdf\t\tSS\t\tMS\t\tF\t\t\n" +
                "Regression\t1.0\tNaN\tNaN\tNaN\t\n" +
                "Residual\t8.0\tNaN\t\tNaN\t\t\n" +
                "Total\t\t9.0\tNaN\t\t\n" +
                "\n" +
                "Decision: f \n" +
                "0 > f0.05,(1.8)=0,0042\n" +
                "\n" +
                "Prediction values\n" +
                "\n" +
                "Date\t\t\t\t\t\tNumber of OBSERVED positive cases\t\tNumber of ESTIMATED/EXPECTED positive cases\t\t\t\t\t95% intervals\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                " === Linear Regression - Daily - Mean Age === \n" +
                "\n" +
                "The regression model fitted using data from the interval \n" +
                "^y = a + bx <=> ^y = NaN + NaN * x\n" +
                "b = NaN\n" +
                "a = NaN\n" +
                "//\n" +
                "Other statistics\n" +
                "R2 = NaN\n" +
                "R2adjusted = ...\n" +
                "R = NaN\n" +
                "//\n" +
                "Hypothesis tests for regression coefficients\n" +
                "HO:b=0 (a=0) H1: b<>0 (a<>0)\n" +
                "t_obs = 2,3060\n" +
                "Decision: Error\n" +
                "//\n" +
                "Significance model with Anova\n" +
                "H0: b=0  H1:b<>0\n" +
                "\t\t\tdf\t\tSS\t\tMS\t\tF\t\t\n" +
                "Regression\t1.0\tNaN\tNaN\tNaN\t\n" +
                "Residual\t8.0\tNaN\t\tNaN\t\t\n" +
                "Total\t\t9.0\tNaN\t\t\n" +
                "\n" +
                "Decision: f \n" +
                "0 > f0.05,(1.8)=0,0042\n" +
                "\n" +
                "Prediction values\n" +
                "\n" +
                "Date\t\t\t\t\t\tNumber of OBSERVED positive cases\t\tNumber of ESTIMATED/EXPECTED positive cases\t\t\t\t\t95% intervals\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                " === Linear Regression - Daily - Multiple === \n" +
                "\n" +
                "The regression model fitted using data from the interval \n" +
                "\n" +
                "//\n" +
                "Other statistics\n" +
                "R2 = NaN\n" +
                "R2adjusted = NaN\n" +
                "R = NaN\n" +
                "//\n" +
                "Hypothesis tests for regression coefficients\n" +
                "HO:b1=b2=0, k=2 H1: bj<>0 , j=1,2 \n" +
                "f_obs = 4,7374\n" +
                "Decision: \n" +
                "Error\n" +
                "//\n" +
                "Significance model with Anova\n" +
                "HO:b1=b2=0, k=2 H1: bj<>0 , j=1,2 \n" +
                "\t\t\tdf\t\tSS\t\tMS\t\tF\t\t\n" +
                "Regression\t2.0\tNaN\tNaN\tNaN\t\n" +
                "Residual\t7.0\tNaN\t\tNaN\t\t\n" +
                "Total\t9.0\t0,0000\t\t\n" +
                "\n" +
                "Decision: f \n" +
                "0 > f0.05,(2.7)=4,7374\n" +
                "Error\n" +
                "\n" +
                "Prediction values\n" +
                "\n" +
                "Date\t\t\tNumber of OBSERVED positive cases\t\tNumber of ESTIMATED/EXPECTED positive cases\t\t\t\t\t95% intervals\n" +
                "\n" +
                "\n" +
                " === Linear Regression - Weekly - Registered Tests === \n" +
                "\n" +
                "The regression model fitted using data from the interval \n" +
                "^y = a + bx <=> ^y = NaN + NaN * x\n" +
                "b = NaN\n" +
                "a = NaN\n" +
                "//\n" +
                "Other statistics\n" +
                "R2 = NaN\n" +
                "R2adjusted = ...\n" +
                "R = NaN\n" +
                "//\n" +
                "Hypothesis tests for regression coefficients\n" +
                "HO:b=0 (a=0) H1: b<>0 (a<>0)\n" +
                "t_obs = 2,3060\n" +
                "Decision: Error\n" +
                "//\n" +
                "Significance model with Anova\n" +
                "H0: b=0  H1:b<>0\n" +
                "\t\t\tdf\t\tSS\t\tMS\t\tF\t\t\n" +
                "Regression\t1.0\tNaN\tNaN\tNaN\t\n" +
                "Residual\t8.0\tNaN\t\tNaN\t\t\n" +
                "Total\t\t9.0\tNaN\t\t\n" +
                "\n" +
                "Decision: f \n" +
                "0 > f0.05,(1.8)=0,0042\n" +
                "\n" +
                "Prediction values\n" +
                "\n" +
                "Date\t\t\t\t\t\tNumber of OBSERVED positive cases\t\tNumber of ESTIMATED/EXPECTED positive cases\t\t\t\t\t95% intervals\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                " === Linear Regression - Weekly - Mean Age === \n" +
                "\n" +
                "The regression model fitted using data from the interval \n" +
                "^y = a + bx <=> ^y = NaN + NaN * x\n" +
                "b = NaN\n" +
                "a = NaN\n" +
                "//\n" +
                "Other statistics\n" +
                "R2 = NaN\n" +
                "R2adjusted = ...\n" +
                "R = NaN\n" +
                "//\n" +
                "Hypothesis tests for regression coefficients\n" +
                "HO:b=0 (a=0) H1: b<>0 (a<>0)\n" +
                "t_obs = 2,3060\n" +
                "Decision: Error\n" +
                "//\n" +
                "Significance model with Anova\n" +
                "H0: b=0  H1:b<>0\n" +
                "\t\t\tdf\t\tSS\t\tMS\t\tF\t\t\n" +
                "Regression\t1.0\tNaN\tNaN\tNaN\t\n" +
                "Residual\t8.0\tNaN\t\tNaN\t\t\n" +
                "Total\t\t9.0\tNaN\t\t\n" +
                "\n" +
                "Decision: f \n" +
                "0 > f0.05,(1.8)=0,0042\n" +
                "\n" +
                "Prediction values\n" +
                "\n" +
                "Date\t\t\t\t\t\tNumber of OBSERVED positive cases\t\tNumber of ESTIMATED/EXPECTED positive cases\t\t\t\t\t95% intervals\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                " === Linear Regression - Weekly - Multiple === \n" +
                "\n" +
                "The regression model fitted using data from the interval \n" +
                "\n" +
                "//\n" +
                "Other statistics\n" +
                "R2 = NaN\n" +
                "R2adjusted = NaN\n" +
                "R = NaN\n" +
                "//\n" +
                "Hypothesis tests for regression coefficients\n" +
                "HO:b1=b2=0, k=2 H1: bj<>0 , j=1,2 \n" +
                "f_obs = 4,7374\n" +
                "Decision: \n" +
                "Error\n" +
                "//\n" +
                "Significance model with Anova\n" +
                "HO:b1=b2=0, k=2 H1: bj<>0 , j=1,2 \n" +
                "\t\t\tdf\t\tSS\t\tMS\t\tF\t\t\n" +
                "Regression\t2.0\tNaN\tNaN\tNaN\t\n" +
                "Residual\t7.0\tNaN\t\tNaN\t\t\n" +
                "Total\t9.0\t0,0000\t\t\n" +
                "\n" +
                "Decision: f \n" +
                "0 > f0.05,(2.7)=4,7374\n" +
                "Error\n" +
                "\n" +
                "Prediction values\n" +
                "\n" +
                "Date\t\t\tNumber of OBSERVED positive cases\t\tNumber of ESTIMATED/EXPECTED positive cases\t\t\t\t\t95% intervals\n" +
                "\n" +
                "\n";
    }
}