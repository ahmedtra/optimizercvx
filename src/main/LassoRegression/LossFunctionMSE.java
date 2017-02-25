/**
 * Created by ahmedtra on 2/25/2017.
 */
public class LossFunctionMSE extends LossFunctionLinRegression{

    public LossFunctionMSE(double[][] x, double[] y){
        super(x,y);
    }

    public double value(double[] beta){

        double cost = 0;
        double error;
        for (int i =0; i< numObservations; i++){
            error = error(beta, i);
            cost += Math.pow(error, 2);
        }

        return cost / numObservations;
    }

    public double[] grad(double[] beta){
        double[] grad = new double[numInput];

        double error;

        for(int j = 0; j < numInput; j++) {
            grad[j] = 0;
            for (int i = 0; i < numObservations; i++) {
                error = error(beta, i);
                grad[j] += error * input[i][j];
            }
        }
        return grad;
    }

}
