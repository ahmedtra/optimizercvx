/**
 * Created by ahmedtra on 2/25/2017.
 */
public class LinRegressionExponetialLocalWeights {
    private LossFunctionMSEExponetialWeigths lossFunction;
    private double[] beta;
    private cvxopt optimiser;

    public LinRegressionExponetialLocalWeights(double[][] x, double[] y) {
        lossFunction = new LossFunctionMSEExponetialWeigths(x, y);
        beta = new double[x[0].length];
        optimiser = new cvxopt();
        optimiser.setFuntion(lossFunction).setAlpha(0.001);
//        optimiser.optimize();
        beta = optimiser.currentVarValues;
    }

    public LinRegressionExponetialLocalWeights Regularisation(boolean reg){
        lossFunction.Regularisation(reg);
        return this;
    }

    public LinRegressionExponetialLocalWeights lasso(double lam){
        lossFunction.lasso(lam);
        optimiser.optimize();
        beta = optimiser.currentVarValues;
        for (int i =0; i < beta.length ; i++){
            if (Math.abs(beta[i]) < 1e-10) beta[i] = 0;
        }
        return this;
    }

    public LinRegressionExponetialLocalWeights ridge(double lam){
        lossFunction.ridge(lam);
        return this;
    }

    ;

    public void addConstant(boolean constant) {
        lossFunction.addConstant(constant);
    }

    public void updateBeta() {
        optimiser.optimize();
        beta = optimiser.currentVarValues;
    }

    public double[] getBeta() {
        return beta;
    }

    public String stringify() {
        return optimiser.stringify();
    }
}
