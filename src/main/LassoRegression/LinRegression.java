/**
 * Created by ahmedtra on 2/25/2017.
 */
public class LinRegression {
    private LossFunctionMSE lossFunction;
    private double[] beta;
    private cvxopt optimiser;

    public LinRegression(double[][] x, double[] y){
        lossFunction = new LossFunctionMSE(x,y);
        optimiser = new cvxopt();
        optimiser.setFuntion(lossFunction);
        optimiser.optimize();
        beta = optimiser.currentVarValues;
    };

    public void addConstant(boolean constant){
        lossFunction.addConstant(constant);
    }

    public void updateBeta(){
        optimiser.optimize();
        beta = optimiser.currentVarValues;
    }

    public double[] getBeta(){
        return beta;
    }
}
