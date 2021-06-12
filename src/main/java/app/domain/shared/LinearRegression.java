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
    private final double xbar;
    private double ST = 0;
    private double SE = 0;
    private double SR = 0;
    private double dfST = 0;
    private double dfSE = 0;
    private double dfSR = 0;
    private  double tDistribution = 0;
    private  double fDistribution = 0;
    private double Sxx;
    private final double ALPHA = 0.05;
    private int n;
    private double[] x;
    private double[] y;


    /**
     * Performs a linear regression on the data points (y[i], x[i]).
     *
     * @param  x the values of the predictor variable
     * @param  y the corresponding values of the response variable
     * @throws IllegalArgumentException if the lengths of the two arrays are not equal
     */
    public LinearRegression(double[] x, double[] y) {
        this.y = y;
        this.x = x;
        if (x.length != y.length) {
            throw new IllegalArgumentException("array lengths are not equal");
        }
        this.n = x.length;
        // first pass
        double sumx = 0.0, sumy = 0.0, sumx2 = 0.0;
        for (int i = 0; i < n; i++) {
            sumx  += x[i];
            sumx2 += x[i]*x[i];
            sumy  += y[i];
        }
        double xbar = sumx / n; // mean x
        double ybar = sumy / n; // mean y

        this.xbar=xbar;


        // second pass: compute summary statistics
        double xxbar = 0.0, yybar = 0.0, xybar = 0.0;
        for (int i = 0; i < n; i++) {
            xxbar += (x[i] - xbar) * (x[i] - xbar); //Sxx
            yybar += (y[i] - ybar) * (y[i] - ybar); //Syy
            xybar += (x[i] - xbar) * (y[i] - ybar); //Sxy
        }
        slope  = xybar / xxbar; //b
        intercept = ybar - slope * xbar; //a
        this.Sxx=xxbar;

        double fit = 0;
        // more statistical analysis
        double rss = 0.0;      // residual sum of squares
        double ssr = 0.0;      // regression sum of squares
        for (int i = 0; i < n; i++) {
            fit = slope*x[i] + intercept;

            rss += (fit - y[i]) * (fit - y[i]);
            ssr += (fit - ybar) * (fit - ybar);
        }

        int degreesOfFreedom = n-2;
        this.tDistribution = new TDistribution(degreesOfFreedom).inverseCumulativeProbability(1-(ALPHA /2));

        this.dfSR = 1;
        this.dfST = n - 1;
        this.dfSE = dfST - dfSR;
        this.SR = ssr;
        this.SE = rss;
        this.ST = rss + ssr;
        r2    = ssr / yybar;
        double svar  = rss / degreesOfFreedom; //MSE
        svar1 = svar / xxbar;
        svar0 = svar/n + xbar*xbar*svar1;

        FDistribution fd= new FDistribution(this.dfSR,this.dfSE);
        this.fDistribution= fd.inverseCumulativeProbability(1- ALPHA);

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



    public double getST(){
        return this.ST;
    }

    public double getSE(){

        return this.SE; //issue
    }

    public double getSR(){
        return this.SR;
    }

    public String decision(){
        if(F()>fDistribution){
            return "Reject H0.";
        }else if(F()<=fDistribution){
            return "Don't Reject H0.";
        }
        return "Error";
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


    public String toString(){
        NumberFormat formatter = new DecimalFormat("#0.0000");
        return "b = "+slope+"\na = "+intercept+
                "\n//\nOther statistics"+"\nR2 = " +r2 + "\nR2adjusted = ..." + "\nR = " + Math.sqrt(r2) +
                "\n//\nHypothesis tests for regression coefficients\nHO:b=0 (a=0) H1: b<>0 (a<>0)" +
                "\nt_obs = " + this.tDistribution + "\nDecision: " + decision() +
                "\n//\nSignificance model with Anova\nH0: b=0  H1:b<>0" +
                "\n\t\t\tdf\t\tSS\t\tMS\t\tF\t\t" +
                "\nRegression\t" + this.dfSR + "\t" + formatter.format(getSR()) +"\t" + formatter.format(MSR())+"\t"+ formatter.format(F()) +"\t" +
                "\nResidual\t" + this.dfSE + "\t" + formatter.format(getSE()) +"\t\t"+ formatter.format(MSE()) +"\t\t" +
                "\nTotal\t\t" + this.dfST +"\t" + formatter.format(getST()) +"\t\t" +
                "\n\nDecision: f \n0 > f" + ALPHA + ",(" + (int)this.dfSR + "." + (int)this.dfSE + ")=" + this.fDistribution;



    }

    public double delta(double x0) {
        double s = 0;
        for (int i = 0; i < n; i++) {
            s += Math.pow(y[i] - predict(x[i]),2);
        }
        s = Math.sqrt(s * 1 / (double)(n - 2));
        return tDistribution * s *  Math.sqrt(1/n + (Math.pow((x0 - xbar),2)/Sxx));
    }
}
