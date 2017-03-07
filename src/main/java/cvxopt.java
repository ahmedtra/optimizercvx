import java.util.Arrays;

/**
 * Created by ahmedtra on 2/25/2017.
 */
public class cvxopt extends opt<cvxopt>{

    public cvxopt(){
        super();
    }

    protected void oneStepOptimisation(){
        currentlValue = functionOptimized.value(currentVarValues);
        currentGrad = functionOptimized.grad(currentVarValues);

        double[] newVarValues = new double[numOptVar];
        int div = 0;
        do {
            for (int i = 0; i < numOptVar; i++) {
                newVarValues[i] = currentVarValues[i];
                newVarValues[i] -= currentGrad[i] * alpha / Math.pow(2,div);
            }
            div += 1;
        }
        while((div<100) && (currentlValue < functionOptimized.value(newVarValues)));
        currentVarValues = newVarValues;
    }


    public double optimize(){
        for (int i = 0; i<iterations; i++){
            double oldValue = functionOptimized.value(currentVarValues);
            oneStepOptimisation();
            double diffValue = Math.abs(currentlValue- functionOptimized.value(currentVarValues));
            if (MathUtils.normL2(currentGrad) < tolerance || diffValue < tolerance) break;
        }
        return currentlValue;
    }

}
