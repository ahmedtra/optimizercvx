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

    public static double normL1(double[] x){
        double norm = 0;
        for(int i = 0; i<x.length; i++){
            norm += Math.abs(x[i]);
        }
        return norm;
    }
}
