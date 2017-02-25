
/**
 * Created by ahmedtra on 2/25/2017.
 */
public abstract class Function {
    private int numInput;

    public abstract double value(double[] x);

    public abstract double[] grad(double[] x);

    public int getnumInput(){return numInput;};
}
