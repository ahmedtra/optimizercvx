/**
 * Created by ahmedtra on 3/7/2017.
 */
public class X2numeric extends FunctionNumericGrad{
    public X2numeric()
    {
        numInput = 2;
    }
    public double value(double[] x){
        assert x.length == numInput;

        return (x[0] - 5) * (x[0] - 5) + (x[1] - 3) * (x[1] - 3);
    }

}
