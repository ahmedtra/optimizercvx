

/**
 * Created by ahmedtra on 2/25/2017.
 */
public class X2 extends Function {
    int numInput = 1;

    public double value(double[] x){
        assert x.length == numInput;

        return (x[0] - 5) * (x[0] - 5) ;
    }

    public double[] grad(double[] x){
        assert x.length == numInput;

        double[] grad = new double[numInput];
        grad[0] = 2 * (x[0] - 5);
        return  grad;
    }
}
