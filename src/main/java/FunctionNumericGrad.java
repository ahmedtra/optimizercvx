import java.util.Arrays;

/**
 * Created by ahmedtra on 3/7/2017.
 */
public abstract class FunctionNumericGrad extends Function{
    double stepDiff = 0.02;
    int gridPoints = 4;
    public double[] grad(double[] x){
        double[] grad = new double[numInput];
        for(int i= 0 ; i<numInput; i++){
            double[] funcValue = new double[gridPoints];
            double point = x[i] - stepDiff * (gridPoints - 1) / 2.;
            double[] xdiff = x.clone();
            double partialderiv = 0;
            for(int j= 0; j< gridPoints; j++){
                xdiff[i] = point;
                funcValue[j] = value(xdiff);
                partialderiv += funcValue[j] / (gridPoints * (xdiff[i] - x[i]));
                point += stepDiff;
            }
            grad[i] = partialderiv;
        }
        return grad;
    }


}
