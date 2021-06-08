package app.domain.shared; /******************************************************************************
 *  Compute least squares solution to y = beta * x + alpha.
 *  Simple linear regression.
 ******************************************************************************/

import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.distribution.TDistribution;

/**
 *  The code LinearRegression class performs a simple linear regression
 *  on an set of n data points (y_i, x_i).
 *  That is, it fits a straight line y = alpha + beta * x,
 *  (where y is the response variable, x is the predictor variable,
 *  alpha is the y-intercept, and beta is the slope)
 *  that minimizes the sum of squared residuals of the linear regression model.
 *  It also computes associated statistics, including the coefficient of
 *  determination R^2 and the standard deviation of the
 *  estimates for the slope and y-intercept.
 *
 */
public class LinearRegression {
    private final double intercept, slope;
    private final double r2;
    private final double svar0, svar1;
    private double ST = 0;
    private double SE = 0;
    private double SR = 0;
    private double dfST = 0;
    private double dfSE = 0;
    private double dfSR = 0;
    private String varIndependent;


    /**
     * Performs a linear regression on the data points (y[i], x[i]).
     *
     * @param  x the values of the predictor variable
     * @param  y the corresponding values of the response variable
     * @throws IllegalArgumentException if the lengths of the two arrays are not equal
     */
    public LinearRegression(double[] x, double[] y, String varIndependent) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("array lengths are not equal");
        }
        this.varIndependent = varIndependent;
        int n = x.length;

        // first pass
        double sumx = 0.0, sumy = 0.0, sumx2 = 0.0;
        for (int i = 0; i < n; i++) {
            sumx  += x[i];
            sumx2 += x[i]*x[i];
            sumy  += y[i];
        }
        double xbar = sumx / n; // average (media) x
        double ybar = sumy / n; // average (media) y

        // second pass: compute summary statistics
        double xxbar = 0.0, yybar = 0.0, xybar = 0.0;
        for (int i = 0; i < n; i++) {
            xxbar += (x[i] - xbar) * (x[i] - xbar); //Sxx
            yybar += (y[i] - ybar) * (y[i] - ybar); //Syy
            xybar += (x[i] - xbar) * (y[i] - ybar); //Sxy
        }
        slope  = xybar / xxbar; //b
        intercept = ybar - slope * xbar; //a

        // more statistical analysis
        double rss = 0.0;      // residual sum of squares
        double ssr = 0.0;      // regression sum of squares
        for (int i = 0; i < n; i++) {
            double fit = slope*x[i] + intercept;
            rss += (fit - y[i]) * (fit - y[i]);
            ssr += (fit - ybar) * (fit - ybar);
        }

        int degreesOfFreedom = n-2;
        this.dfSR = 1 * this.numParameters();
        this.dfST = n - 1;
        this.dfSE = dfST - dfSR;
        this.SR = ssr;
        this.SE = rss;
        this.ST = rss + ssr;
        r2    = ssr / yybar;
        double svar  = rss / degreesOfFreedom; //MSE
        svar1 = svar / xxbar;
        svar0 = svar/n + xbar*xbar*svar1;


    }

    /**
     * Returns the y-intercept alpha of the best of the best-fit line y = alpha + beta * x.
     *
     * @return the y-intercept alpha of the best-fit line y = alpha + beta * x
     */
    public double intercept() {
        return intercept;
    }

    /**
     * Returns the slope beta of the best of the best-fit line y = alpha + beta * x.
     *
     * @return the slope beta of the best-fit line y = alpha + beta * x
     */
    public double slope() {
        return slope;
    }

    /**
     * Returns the coefficient of determination R^2.
     *
     * @return the coefficient of determination R^2,
     *         which is a real number between 0 and 1
     */
    public double R2() {
        return r2;
    }

    /**
     * Returns the standard error of the estimate for the intercept.
     *
     * @return the standard error of the estimate for the intercept
     */
    public double interceptStdErr() {
        return Math.sqrt(svar0);
    }

    /**
     * Returns the standard error of the estimate for the slope.
     *
     * @return the standard error of the estimate for the slope SE
     */
    public double slopeStdErr() {
        return Math.sqrt(svar1);
    }

    /**
     * Returns the expected response y given the value of the predictor
     * variable x.
     *
     * @param  x the value of the predictor variable
     * @return the expected response y given the value of the predictor
     *         variable x
     */
    public double predict(double x) {
        return slope*x + intercept;
    }

    /**
     * Returns a string representation of the simple linear regression model.
     *
     * @return a string representation of the simple linear regression model,
     *         including the best-fit line and the coefficient of determination
     *         R^2
     */



    public void parameterCalculation(double [] x, double [] y){


        double yT = 0;
        double xT = 0;
        double xm;
        double ym;

        double Sxx = 0;
        double Sxy = 0;
        double Syy = 0;
        double SE = 0;
        double SR = 0;

        double R;

        double b;
        double a;

        for(int i = 0; i < y.length; i++){
            yT = yT + y[i];
        }

        for(int i = 0; i < x.length; i++){
            xT = xT + x[i];
        }

        xm = xT/yT;
        ym = yT/y.length;

        for(int i = 0; i < x.length; i++){
            Sxx = Sxx + Math.pow((x[i] - xm),2);
        }

        for(int i = 0; i < y.length; i++){
            Syy = Syy + (y[i] - ym);

        }

        for(int i = 0; i < x.length; i++){
            Sxy = Sxy + (x[i] - xm) * (y[i] - ym);
        }

        b = Sxy/Sxx;
        a = ym - b*xm;

        R = Sxy / (Math.sqrt(Sxx) * Math.sqrt(Syy));


        double [] bY =new double[y.length];


        for(int i = 0; i < bY.length; i++){
            bY[i] = a + b * x[i];
        }






       // SE = Syy - Math.pow(b,2) * Sxx;
        for(int i = 0; i < y.length; i++){
            SE =+ Math.pow(y[i] - bY[i], 2); //determinação do SE
            SR =+ Math.pow(bY[i] - ym, 2);   //determinação do SR
        }

        this.SE = SE;
        this.SR = SR;
        this.ST = SE + SR;



        //Graus de Liberdade





    }

    public double getST(){
        return this.ST;
    }

    public double getSE(){
        return this.SE;
    }

    public double getSR(){
        return this.SR;
    }

    public String decision(){
        // Reject H0/ Don't reject H0
        return "Nao implementado ainda";
    }

    private String decisionF() {
        // Reject H0/ Don't reject H0
        return "Nao implementado ainda";
    }

    private double dfSR() {
        return this.dfSR;
    }

    private double dfSE() {
        return this.dfSE;
    }

    private double dfST() {
        return this.dfST;
    }

    private double MSR() {
        return getSR()/dfSR();
    }

    private double MSE() {
        return getSE()/dfSE();
    }

    private double F() {
        return MSR()/MSE();
    }

    public String toString1() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("Declive (b): %.4f n + %.4f", slope(), intercept()));
        s.append("R2 = " + String.format("%.4f", R2()) + ")");
        return s.toString();
    }

    public String toString(){
        NumberFormat formatter = new DecimalFormat("#0.0000");
        return "b = "+slope+"\na = "+intercept+
                "\n//\nOther statistics"+"\nR2 = " +r2 + "\nR2adjusted = " + "\nR = " + Math.sqrt(r2) +
                "\n//\nHypothesis tests for regression coefficients\nHO:b=0 (a=0) H1: b<>0 (a<>0)" +
                "\nt_obs = " + "\nDecision: " + decision() +
                "\n//\nSignificance model with Anova\nH0: b=0  H1:b<>0" +
                "\n\t\t\tdf\t\tSS\t\tMS\t\tF\t\t" +
                "\nRegression\t" + this.SR + "\t" + formatter.format(getSR()) +"\t" + formatter.format(MSR())+"\t"+ formatter.format(F()) +"\t" +
                "\nResidual\t" + this.SE + "\t" + formatter.format(getSE()) +"\t\t"+ formatter.format(MSE()) +"\t\t" +
                "\nTotal\t\t" + this.ST +"\t" + formatter.format(getST()) +"\t\t" ;
                /*
                "\n\nDecision: f" + formatter.format(this.) +
                "\n//\nPrediction values\n\n" + "Date\tNumber of OBSERVED positive cases\tNumber of ESTIMATED/EXPECTED positive cases\t\t95% intervals "
                ;*/

    }

    private int numParameters() {
        if (this.varIndependent.equals("Registered Test")) {
            return 1; // mudar para 2
        } else if (this.varIndependent.equals("Mean Age")) {
            return  1;
        }
        return -1;
    }


}
