/**
 * Created by ahmedtra on 2/25/2017.
 */
public class cvxopt extends opt<cvxopt>{

    protected void oneStepOptimisation(){
        currentlValue = functionOptimized.value(currentVarValues);
        currentGrad = functionOptimized.grad(currentVarValues);

        double[] newVarValues = new double[numOptVar];
        for (int i = 0; i<numOptVar; i++){
            newVarValues[i] = currentVarValues[i];
            newVarValues[i] -= currentGrad[i] * alpha;
        }
        currentVarValues = newVarValues;
    }


    public double optimize(){
        for (int i = 0; i<iterations; i++){
            oneStepOptimisation();
            if (MathUtils.normL2(currentGrad) < tolerance) break;
        }
        return currentlValue;
    }

}
