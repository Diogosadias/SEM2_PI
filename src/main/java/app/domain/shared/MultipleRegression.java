package app.domain.shared;


import static java.lang.Math.sqrt;

import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.distribution.TDistribution;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *  This shared class allows calculate multiple Linear regression.
 *
 *  @author Diogo Sá Dias <1161605@isep.ipp.pt>
 *
 *
 */

public class MultipleRegression {
    // Attributes
    private final double[][] y;
    private final double[][] betas;
    private final double[][] x;
    private final double[][] inv;
    private final double n ;
    private static final double k = 2;
    private final double sqt;
    private final double sqe;
    private final double sqr;
    private final double mqe;
    private final double mqr;
    private final double f;
    private final double r2;
    private final double raj;
    private final double r;
    private final double f0;
    private double alpha;



    /**
     * Performs a multilinear regression on the data points (y[i], x1[i],x2[i]).
     *
     * @param  x1 the values of one of the independent variable
     * @param  x2 the values of one of the independent variable
     * @param  y the values of the dependent variable
     * @throws IllegalArgumentException if the lengths of the three arrays are not equal
     */    public MultipleRegression(double[] y,double[] x1, double[] x2, double alpha) {
         this.alpha = alpha;
        if (x1.length != y.length || x2.length != y.length) {
            throw new IllegalArgumentException("array lengths are not equal");
        }
        //save values
        this.x=matrizx(x1,x2);
        this.y=matrizy(y);


        //get betas
        double [][] xtx = multiplicar(transposta(this.x),this.x);
        double [][] xty = multiplicar(transposta(this.x),this.y);
        this.inv = inversa(xtx);
        this.betas = multiplicar(inv,xty);



        //Calculo da ANOVA
        n = y.length;
        sqt= valor(multiplicar(transposta(this.y),this.y)) -n*media(y)*media(y);
        sqr=valor(multiplicar(transposta(betas), (multiplicar(transposta(x),this.y)))) -n*media(y)*media(y);
        sqe=valor(multiplicar(transposta(this.y),this.y))-valor(multiplicar(transposta(betas), (multiplicar(transposta(x),this.y))));
        mqr =sqr/k;
        mqe=sqe/(n-(k+1));
        f=mqr/mqe;
        FDistribution fd= new FDistribution(k,(n-(k+1)));
        f0= fd.inverseCumulativeProbability(0.95);

        // coeficiente de determinação e ajustado
        r2=sqr/sqt;
        raj=1-((n-1)/(n-(k+1)))*(1-r2);
        r=sqrt(r2);


    }

    //Getters and Setters

    /**
     * Returns the matrix of Y.
     *
     * @return matrix of Y.
     */
    public double [][] getY() {
        return y;
    }

    /**
     * Returns the matrix of X.
     *
     * @return matrix of X.
     */
    public double [][] getX() {
        return x;
    }

    /**
     * Returns the matrix of coefficients of regression.
     *
     * @return  matrix of coefficients of regression.
     */
    public double [][] getBetas() {
        return betas;
    }

    /**
     * Returns the number of occurrences.
     *
     * @return  the number of occurrences.
     */
    public double  getN() {
        return n;
    }

    /**
     * Returns the degrees of freedom.
     *
     * @return  the degrees of freedom.
     */
    public double  getK() {
        return k;
    }

    /**
     * Returns the coefficient of determination R^2.
     *
     * @return  the coefficient of determination R^2.
     */
    public double  getR2() {
        return r2;
    }

    /**
     * Returns the coefficient of determination R^2 adjusted.
     *
     * @return  the coefficient of determination R^2 adjusted.
     */
    public double  getRaj() {
        return raj;
    }

    /**
     * Returns the square root of the coefficient of determination R^2 .
     *
     * @return  the square root of the coefficient of determination R^2 .
     */
    public double  getR() {
        return r;
    }

    /**
     * Returns the significance of the model.
     *
     * @return  the significance of the model.
     */
    public double  getF() {
        return f;
    }

    /**
     * Returns the SQt.
     *
     * @return the SQt.
     */
    public double getSqt() {
        return sqt;
    }

    /**
     * Returns the SQe.
     *
     * @return the SQe.
     */
    public double getSqe() {
        return sqe;
    }

    /**
     * Returns the SQr.
     *
     * @return the SQr.
     */
    public double getSqr() {
        return sqr;
    }

    /**
     * Returns the MQe.
     *
     * @return the MQe.
     */
    public double getMqe() {
        return mqe;
    }

    /**
     * Returns the MQr.
     *
     * @return the MQr.
     */
    public double getMqr() {
        return mqr;
    }

    /**
     * Returns the fishcher value.
     *
     * @return the fishcher value.
     */
    public double getf0() {
        return f0;
    }

    public void setAlpha(double alpha){
        this.alpha=alpha;
    }

    //Auxiliar

    private double valor(double[][] multiplicar) {
        return multiplicar[0][0];
    }

    private double media(double[] y) {
        double sum = 0;
        for(int i = 0;i<y.length;i++){
            sum+=y[i];
        }
        return sum/y.length;
    }

    private double[][] matrizy(double[] y) {
        double [][] matriz = new double[y.length][1];
        for(int i = 0; i<1;i++){
            for(int j=0;j< y.length;j++){
                matriz[j][i] = y[j];
            }
        }
        return matriz;
    }
    private double[][] matrizx(double[] x1, double[] x2) {
        if (x1.length != x2.length ) {
            throw new IllegalArgumentException("array lengths are not equal");
        }

        double[][]matriz = new double[x1.length][3];

        //populate
        for(int i = 0; i<1;i++){
            for(int j=0;j< x1.length;j++){
                matriz[j][i] = 1;
            }
        }
        for(int i = 1; i<2;i++){
            for(int j=0;j< x1.length;j++){
                matriz[j][i] = x1[j];
            }
        }
        for(int i = 2; i<3;i++){
            for(int j=0;j< x1.length;j++){
                matriz[j][i] = x2[j];
            }
        }
        return matriz;
    }

    private double[][] transposta(double[][] x) {
        double[][] matriz = new double[x[0].length][x.length];

        for(int i = 0; i<x.length;i++){
            for(int j=0;j< x[0].length;j++){
                matriz[j][i] = x[i][j];
            }
        }
        return matriz;
    }

    private double[][] multiplicar(double[][] x, double[][] y) {
        double[][] matriz = new double[x.length][y[0].length];
        for(int i = 0; i<x.length;i++){
            for(int j=0;j< y[0].length;j++){
                for(int a = 0; a<y.length;a++){
                    matriz[i][j] = matriz[i][j] + x[i][a] * y[a][j];
                }
            }
        }

        return matriz;
    }

    private double[][] inversa(double[][] x) {
        double det = determinante(x);
        int rows = x.length;
        int cols = x[0].length;
        double[][] inv = new double[rows][cols];
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < cols; ++j)
                inv[i][j] = (((x[(j+1)%rows][(i+1)%cols] * x[(j+2)%rows][(i+2)%cols]) - (x[(j+1)%rows][(i+2)%cols] * x[(j+2)%rows][(i+1)%cols]))/ det);
        }
        /*
        //Adjacente
        double[][] adj = x;
        for(int i = 0; i< x.length;i++){
            for(int j=0;j< x[0].length;j++){
                if(((j+i) % 2) == 0){
                    adj[i][j] = determinante(alteramatriz(x,i,j));
                } else{
                    adj[j][i] = - determinante(alteramatriz(x,i,j));
                }
            }
        }
        double[][] t = transposta(adj);

        double[][] inv = divDeterminante(t,det);*/
        return inv;
    }

    private double determinante(double[][] x) {
        double d =0;
        double a=0;
        double b=0;

        int tamanho = x.length;

        switch (tamanho){
            case 2:
                d = x[0][0]*x[1][1] - x[0][1]*x[1][0];
                break;
            case 3:
                a=  x[0][0]*x[1][1]*x[2][2] + x[0][1]*x[1][2]*x[2][0] +x[0][2]*x[1][0]*x[2][1];
                b=  x[0][2]*x[1][1]*x[2][0] + x[0][0]*x[1][2]*x[2][1] +x[0][1]*x[1][0]*x[2][2];
                d =a -b;
                break;
            default:
                d = x[0][0]*x[1][1] - x[0][1]*x[1][0];
                throw new IllegalArgumentException("Could not calculate Determinante!");
        }

        return d;
    }

    private double[][] alteramatriz(double[][] x,int a, int b) {
        double[][] matriz = new double[x[0].length -1][x[0].length-1];
        double[][] temp = new double[x.length][x[0].length-1];

        for(int i = 0; i < x.length; i++){
            for(int j = 0,w=0; j < x[0].length; j++){
                if(j != b){
                    temp[i][w++] = x[i][j];
                }
            }
        }
        for(int j = 0, w= 0; j < temp.length; j++){
            for(int i = 0, k=0; i < temp[0].length; i++){
                if(j != a){
                    matriz[w][k++] = temp[j][i];
                }
            }
            if(j>0) w++;
        }

        return matriz;
    }

    private double[][] divDeterminante(double[][] t,double d) {
        for(int i = 0; i<t.length;i++){
            for(int j=0;j< t[0].length;j++){
                t[i][j] = t[i][j]/d;
            }
        }
        return t;
    }

    //Predictions


    public double predict(double x1,double x2) {
        return betas[0][0] + x1*betas[1][0] + x2*betas[2][0];
    }

    public double mininterval(double x1, double x2){
        double [][] x0 = {{1},{x1},{x2}};
        double degreesOfFreedom = (n-(k+1));
        double t = new TDistribution(degreesOfFreedom).inverseCumulativeProbability(1-(alpha /2));
        double delta = mqe * valor(multiplicar(transposta(x0),multiplicar(inv,x0)));
        return predict(x1,x2) - t*sqrt(delta);
    }

    public double maxinterval(double x1, double x2){
        double [][] x0 = {{1},{x1},{x2}};
        double degreesOfFreedom = (n-(k+1));
        double t = new TDistribution(degreesOfFreedom).inverseCumulativeProbability(1-(alpha /2));
        double delta = mqe * valor(multiplicar(transposta(x0),multiplicar(inv,x0)));
        return predict(x1,x2) + t*sqrt(delta);
    }

    //Decision

    public String decision(){
        if(f>f0){
            return "Reject H0.";
        }else if(f<=f0){
            return "Don't Reject H0.";
        }
        return "Error";
    }

    public String decisionf(){
        if(f>f0){
            return "Reject H0\n" +
                    "The regression model is significant.";
        }else if(f<=f0){
            return "Don't reject H0\n" +
                    "The regression model is not significant.";
        }
        return "Error";
    }

//Priting
    @Override
    public String toString(){
        NumberFormat formatter = new DecimalFormat("#0.0000");
        return "\nThe regression model fitted using data from the interval \n" +
                "\n//\nOther statistics"+"\nR2 = " + formatter.format(r2) + "\nR2adjusted = " + formatter.format(raj) + "\nR = " + formatter.format(r) +
                "\n//\nHypothesis tests for regression coefficients\nHO:b1=b2=0, k=2 H1: bj<>0 , j=1,2 " +
                "\nf_obs = " + formatter.format(this.f0) + "\nDecision: " + "\n" + decision() +
                "\n//\nSignificance model with Anova\nHO:b1=b2=0, k=2 H1: bj<>0 , j=1,2 " +
                "\n\t\t\tdf\t\tSS\t\tMS\t\tF\t\t" +
                "\nRegression\t" + this.k + "\t" + formatter.format(sqr) +"\t" + formatter.format(mqr)+"\t"+ formatter.format(f) +"\t" +
                "\nResidual\t" + (n-(k+1)) + "\t" + formatter.format(sqe) +"\t\t"+ formatter.format(mqe) +"\t\t" +
                "\nTotal\t" + (n-1) +"\t" + formatter.format(sqt) +"\t\t" +
                "\n\nDecision: f \n0 > f" + alpha + ",(" + (int)this.k + "." + (int)(n-(k+1)) + ")=" + formatter.format(this.f0) +
                "\n" + decisionf() ;



    }

}

