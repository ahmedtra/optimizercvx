import java.util.Arrays;

/**
 * Created by ahmedtra on 2/25/2017.
 */
public abstract class opt <T extends opt<T>> {
    int numOptVar;

    protected double alpha = 0.01;
    protected double tolerance= 0.001;
    protected Function functionOptimized;
    protected int iterations = 100000;
    protected double[] currentVarValues = new double[numOptVar];
    protected double currentlValue;
    protected double[] currentGrad;
    protected abstract void oneStepOptimisation();


    public abstract double optimize();

    public opt(){
        Arrays.fill(currentVarValues, 0);
    }

    public T setFuntion(Function f){
        functionOptimized = f;
        numOptVar = f.getnumInput();
        currentVarValues = new double[numOptVar];
        Arrays.fill(currentVarValues, 0);
        return (T) this;
    }

    public T setAlpha(double a){
        alpha = a;
        return (T) this;
    }

    public T setTolerance(double t){
        tolerance = t;
        return (T) this;
    }

    public opt setIterations(int i){
        iterations = i;
        return (T) this;
    }

    public String stringify(){
        return "Function("+Arrays.toString(currentVarValues)+") = "+currentlValue+ " \n" +
                "Gradient("+Arrays.toString(currentVarValues)+") = "+ Arrays.toString(currentGrad);
    }
}
