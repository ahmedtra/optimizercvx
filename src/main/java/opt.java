/**
 * Created by ahmedtra on 2/25/2017.
 */
public abstract class opt <T extends opt<T>> {
    int numOptVar;

    protected double alpha = 0.01;
    protected double tolerance= 0.000001;
    protected Function functionOptimized;
    protected int iterations = 10;
    protected double[] currentVarValues = new double[numOptVar];
    protected double currentlValue;
    protected double[] currentGrad;
    protected abstract void oneStepOptimisation();

    public abstract double optimize();


    public T setFuntion(Function f){
        functionOptimized = f;
        numOptVar = f.getnumInput();
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
        return "Function("+currentVarValues+") = "+currentlValue+ " \n" +
                "Gradient("+currentVarValues+") = "+ currentGrad;
    }
}
