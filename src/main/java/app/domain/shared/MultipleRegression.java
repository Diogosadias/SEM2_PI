package app.domain.shared;


/**
 *  This shared class allows calculate multiple Linear regression.
 *
 *  @author Diogo Sá Dias <1161605@isep.ipp.pt>
 *
 *
 */

public class MultipleRegression {
    // Attributes
    private double[] positives;
    private double[] meanAge;
    private double[] dailyTests;
    private double[] betas;
    private double[][] x;
    private double sqt;
    private double sqe;
    private double sqr;
    private double mqe;
    private double mqr;
    private double b0;
    private double b1;
    private double b2;




    //Constructor/Runner
    public MultipleRegression(double[] y,double[] x1, double[] x2) {
        if (x1.length != y.length || x2.length != y.length) {
            throw new IllegalArgumentException("array lengths are not equal");
        }

        //get betas
        // betas = multiplicar(inversa(multiplicar(transposta(matriz de X),matriz de X)),multiplicar(transposta(matriz de X),matriz de Y))

        //print equação
        // y=b0 + b1 * x1 + b2 * x2

        // coeficiente de determinação e ajustado

        //Estimação pontual (substituir)

        //Estimação intervalar 95% (slide 20)

    }

    //Regression

    //Auxiliary Methods
}

