/**
 * Created by ahmedtra on 2/25/2017.
 */
public class MathUtils {
    public static double normL2(double[] x){
        double norm = 0;
        for(int i = 0; i<x.length; i++){
            norm += Math.pow(x[i],2);
        }
        return Math.sqrt(norm);
    }

    public static double[] gradNormL2(double[] x){
        double[] grad = new double[x.length];
            for (int i = 0; i < x.length; i++) {
                grad[i] = 2 * x[i];
            }

        return grad;
    }

    public static double normL1(double[] x){
        double norm = 0;
        for(int i = 0; i<x.length; i++){
            norm += Math.abs(x[i]);
        }
        return norm;
    }

    public static double[] gradNormL1(double[] x){
        double[] grad = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            grad[i] = Math.abs(x[i]) < 0.001 ? 0 : (x[i] > 0 ? 1 : -1);
        }
        return grad;
    }

    public static double[] mult(double[] x, double y){
        double[] xnew = new double[x.length];
        for(int i = 0; i< x.length; i++) xnew[i] = x[i] * y;
        return xnew;
    }

    public static double[] mult(double[] x, double[] y){
        assert x.length == y.length;
        double[] xnew = new double[x.length];
        for(int i = 0; i< x.length; i++) xnew[i] = x[i] * y[i];
        return xnew;
    }

    public static double[] sum(double[] x, double y){
        double[] xnew = new double[x.length];
        for(int i = 0; i< x.length; i++) xnew[i] = x[i] + y;
        return xnew;
    }

    public static double[] sum(double[] x, double[] y){
        assert x.length == y.length;
        double[] xnew = new double[x.length];
        for(int i = 0; i< x.length; i++) xnew[i] = x[i] + y[i];
        return xnew;
    }
}
