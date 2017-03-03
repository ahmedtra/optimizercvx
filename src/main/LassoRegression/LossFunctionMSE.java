import java.util.Arrays;

/**
 * Created by ahmedtra on 2/25/2017.
 */
public class LossFunctionMSE extends LossFunctionLinRegression{

    private boolean regularisation;
    private int typeRegularisation = 1;
    private double lambda = 0.05;

    public LossFunctionMSE(double[][] x, double[] y){
        super(x,y);
    }

    public LossFunctionMSE Regularisation(boolean reg){
        regularisation = reg;
        return this;
    }

    public LossFunctionMSE lasso(double lam){
        typeRegularisation = 1;
        lambda = lam;
        return this;
    }

    public LossFunctionMSE ridge(double lam){
        typeRegularisation = 2;
        lambda = lam;
        return this;
    }


    public double value(double[] beta){

        double cost = 0;
        double errorPoint;
        for (int i =0; i< numObservations; i++){
            errorPoint = error(beta, i);
            cost += Math.pow(errorPoint, 2);
        }

        return cost / numObservations + regularisation(beta, lambda);
    }

    public double[] grad(double[] beta){
        double[] grad = new double[numInput];

        double errorPoint;

        for(int j = 0; j < numInput; j++) {
            grad[j] = 0;
            for (int i = 0; i < numObservations; i++) {
                errorPoint = error(beta, i);
                grad[j] += 2 * (-errorPoint) * input[i][j];
            }
            grad[j] /= numObservations;
        }
        return MathUtils.sum(grad, regularisationGrad(beta, lambda));
    }

    public double regularisation(double[] beta, double lambda) {
        if (regularisation) {
            if (typeRegularisation == 1) return lambda * MathUtils.normL1(beta);
            if (typeRegularisation == 2) return lambda * MathUtils.normL2(beta);
        }
        return 0;
    }

    public double[] regularisationGrad(double[] beta, double lambda) {
        if (regularisation) {
            if (typeRegularisation == 1) return MathUtils.mult(MathUtils.gradNormL1(beta), lambda);
            if (typeRegularisation == 2) return MathUtils.mult(MathUtils.gradNormL2(beta), lambda);
        }
        return new double[beta.length];
    }
}
