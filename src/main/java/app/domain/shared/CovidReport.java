package app.domain.shared;

import app.domain.model.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CovidReport {

    private List<Test> testList;
    private LinearRegression simpleLR;
    private MultipleRegression multipleLR;
    private SimpleDateFormat fmt;
    private List<Date> historicDateList;

    public CovidReport() {
        testList = new ArrayList<>();
        fmt = new SimpleDateFormat("yyyyMMdd");
        historicDateList = new ArrayList<>();
    }

    public void setTestList(List<Test> list) {
        this.testList = list;
    }

    public int setN (Date initialDate, Date finalDate) {
        return (int) TimeUnit.DAYS.convert((finalDate.getTime() - initialDate.getTime()), TimeUnit.MILLISECONDS) - 1;
    }

    public double[][] getIntervalValues (Calendar start,Calendar end, int n) {
        double [][] values = new double[3][n];
        int i =0;
        while (!start.after(end)) {
            int countx = 0;
            int county = 0;
            int sumAge = 0;
            for (Test t : testList) {
                if (fmt.format(t.getDateRegistered()).equals(fmt.format(start.getTime()))) {
                    countx++;
                    if (t.getTestParam().getResult().getMetric() > 1.4) {
                        county++;
                    }
                    sumAge += t.getClient().calculateAge();
                }

            }
            if(countx > 0 && county >0) {
                values[0][i] = (double)sumAge / (double)countx;
                values[1][i] = countx;
                values[2][i] = county;
                i++;
            }
            start.add(Calendar.DATE, 1);
        }
        return values;
    }

    public double [][] doMatcp(int histPoints,int historicDays){
        Calendar date = Calendar.getInstance();
        double [][] values = new double[3][histPoints];
        int countx = 0;
        int county = 0;

        int i=0;
        date.setTime(new Date(System.currentTimeMillis()));
        date.setTime(new Date("2021/05/29"));
        int countDays = 1;
        int sumAge = 0;
        while( countDays <= (histPoints*historicDays) ) {
            Date targetDay = date.getTime();

            for (Test t : testList) {

                if (fmt.format(t.getDateRegistered()).equals(fmt.format(targetDay))) {
                    countx++;
                    if (t.getTestParam().getResult().getMetric() > 1.4) {
                        county++;
                    }
                    sumAge += t.getClient().calculateAge();
                }

            }

            if(countDays%historicDays == 0){
                if(county > 0 && countx > 0) {
                    values[0][i] += (double)sumAge / (double)countx;
                    values[1][i] += countx;
                    values[2][i] += county;
                    historicDateList.add(targetDay);
                }
                if(values[2][i] > 0) {
                    i++;

                }
                countx = 0;
                county = 0;
                sumAge = 0;

            }
            countDays++;
            date.add(Calendar.DATE, -1);
        }
        return values;
    }

    public void setSimpleLinearRegression(LinearRegression simple) {
        this.simpleLR = simple;
    }

    public void setMultipleLinearRegression(MultipleRegression multiple) {
        this.multipleLR = multiple;
    }

    public String boardSimpleLRString (double[] x, double[] y, int historicDays, SimpleDateFormat dateFormat) {
        NumberFormat formatter = new DecimalFormat("#0.0000");
        String board = "\n\nPrediction values\n\n" + "Date\t\t\t\t\t\tNumber of OBSERVED positive cases\t\tNumber of ESTIMATED/EXPECTED positive cases\t\t\t\t\t95% intervals";
        for(int i = 0; i < this.historicDateList.size(); i ++){
            if(y[i] != 0) {
                double predict = this.simpleLR.predict(x[i]);
                double delta = this.simpleLR.delta(x[i]);
                Date date = historicDateList.get(i);
                board += "\n" + dateFormat.format(date);
                if(historicDays == 7) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(date);
                    cal.add(Calendar.DATE,historicDays-1);
                    board += " - " + dateFormat.format(cal.getTime());
                }
                board += "\t\t\t\t\t\t\t\t" + (int)y[i] + "\t\t\t\t\t\t\t\t" + formatter.format(predict) +"\t\t\t\t\t\t\t\t\t\t\t\t["+formatter.format((predict - delta))+","+formatter.format((predict + delta))+"]";
            }
        }
        return board + "\n\n\n\n";
    }

    public List<Test> getTestList() {
        return testList;
    }

    public LinearRegression getSimpleLR() {
        return simpleLR;
    }

    public MultipleRegression getMultipleLR() {
        return multipleLR;
    }

    public List<Date> getHistoricDateList() {
        return historicDateList;
    }
}
