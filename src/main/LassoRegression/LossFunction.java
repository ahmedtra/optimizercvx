/**
 * Created by ahmedtra on 2/25/2017.
 */
abstract class LossFunctionLinRegression extends Function {

    protected int numObservations;
    protected boolean constant = false;

    double[][] input;
    double[] output;


    public LossFunctionLinRegression(double[][] x, double[] y){
        assert x.length == y.length;
        assert  y.length > 0;
        numInput = x[0].length;
        numObservations = y.length;
        input = x;
        output = y;
    }

    public void addConstant(boolean con){
        if (constant == con) return;
        double[][] newinput;
        if (con) {
            numInput += 1;

            newinput = new double[numObservations][numInput];
            for(int j = 0; j< numInput; j++) {
                for (int i = 0; i < numObservations; i++) {
                    if (j == 0) {
                        newinput[i][j] = 1;
                    } else {
                        newinput[i][j] = newinput[i][j - 1];
                    }
                    ;
                }
            }

        }
        else{
            numInput -= 1;
            newinput = new double[numObservations][numInput];
            for(int j = 0; j< numInput; j++) {
                for (int i = 0; i < numObservations; i++) {
                        newinput[i][j] = newinput[i][j +1];
                }
            }
        }
        constant = con;
    }

    public abstract double value(double[] beta);
    public abstract double[] grad(double[] beta);
    protected double value(double[] beta, int observation){
        double betaX = 0;
        if (constant) betaX = beta[0];
        for(int j=0; j<numInput; j++){
            betaX += beta[j] * input[observation][j];
        }
        return betaX;
    }
    protected double error(double[] beta , int observation){
        return output[observation] - value(beta, observation);
    }
}
