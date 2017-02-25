

/**
 * Created by ahmedtra on 2/25/2017.
 */
public class exampleX2 {

    public void main(){
        X2  func = new X2();
        cvxopt optimizer = new cvxopt().setFuntion(func);

        double minimum = optimizer.optimize();
        System.out.println(minimum);
        System.out.println(optimizer.stringify());
        }
}
