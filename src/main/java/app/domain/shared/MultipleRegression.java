package app.domain.shared;


import static java.lang.Math.sqrt;

/**
 *  This shared class allows calculate multiple Linear regression.
 *
 *  @author Diogo Sá Dias <1161605@isep.ipp.pt>
 *
 *
 */

public class MultipleRegression {
    // Attributes
    private double[][] y;
    private double[] meanAge;
    private double[] dailyTests;
    private double[][] betas;
    private double[][] x;
    private double n ;
    private double k ;
    private double sqt;
    private double sqe;
    private double sqr;
    private double mqe;
    private double mqr;
    private double f;
    private double r2;
    private double raj;
    private double r;



    //Constructor/Runner
    public MultipleRegression(double[] y,double[] x1, double[] x2) {
        if (x1.length != y.length || x2.length != y.length) {
            throw new IllegalArgumentException("array lengths are not equal");
        }
        //save values
        this.x=matrizx(x1,x2);
        this.y=matrizy(y);


        //get betas
        this.betas = multiplicar(inversa(multiplicar(transposta(x),x)),multiplicar(transposta(x),this.y));


        //print equação
        // y=b0 + b1 * x1 + b2 * x2

        //Calculo da ANOVA
        n = y.length;
        k=3;
        sqt= valor(multiplicar(transposta(this.y),this.y)) -n*media(y)*media(y);
        sqr=valor(multiplicar(transposta(betas), (multiplicar(transposta(x),this.y)))) -n*media(y)*media(y);
        sqe=valor(multiplicar(transposta(this.y),this.y))-valor(multiplicar(transposta(betas), (multiplicar(transposta(x),this.y))));
        mqr =sqr/k;
        mqe=sqe/(n-(k+1));
        f=mqr/mqe;

        // coeficiente de determinação e ajustado
        r2=sqr/sqt;
        raj=1-((n-1)/(n-(k+1)))*(1-r2);
        r=sqrt(r2);

        //Estimação pontual (substituir)


        //Estimação intervalar 95% (slide 20)

    }

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
        double [][] matriz = new double[1][y.length];
        for(int i = 0; i<1;i++){
            for(int j=0;j< y.length;j++){
                matriz[i][j] = y[j];
            }
        }
        return matriz;
    }
    private double[][] matrizx(double[] x1, double[] x2) {
        if (x1.length != x2.length ) {
            throw new IllegalArgumentException("array lengths are not equal");
        }

        double[][]matriz = new double[3][x1.length];

        //populate
        for(int i = 0; i<1;i++){
            for(int j=0;j< x1.length;j++){
                matriz[i][j] = 1;
            }
        }
        for(int i = 1; i<2;i++){
            for(int j=0;j< x1.length;j++){
                matriz[i][j] = x1[j];
            }
        }
        for(int i = 2; i<3;i++){
            for(int j=0;j< x1.length;j++){
                matriz[i][j] = x2[j];
            }
        }
        return matriz;
    }

    private double[][] transposta(double[][] x) {
        double[][] matriz = new double[x[0].length][x.length];

        for(int i = 0; i<x.length;i++){
            for(int j=0;j< x[0].length;j++){
                matriz[i][j] = x[i][j];
            }
        }
        return matriz;
    }

    private double[][] multiplicar(double[][] x, double[][] y) {
        double[][] matriz = new double[x.length][y[0].length];
        for(int i = 0; i<x.length;i++){
            for(int j=0;j< y[0].length;j++){
                for(int a = 0; a<y[0].length;a++){
                    matriz[i][j] =+ x[i][a] * y[a][j];
                }
            }
        }

        return matriz;
    }

    private double[][] inversa(double[][] x) {
        double det = determinante(x);
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

        double[][] inv = divDeterminante(t,det);

        return inv;
    }




    private double determinante(double[][] x) {
        double d =0;
        double a=0,b=0;

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
        for(int i = 0, w=0; i < temp.length; i++){
            for(int j = 0; j < temp[0].length; j++){
                if(j != a){
                    matriz[w++][j] = temp[i][j];
                }
            }
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

    //Regression


    public double predict(double x1,double x2) {
        return betas[0][0] + x1*betas[1][0] + x2*betas[2][0];
    }


    //Auxiliary Methods
}

