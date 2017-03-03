

/**
 * Created by ahmedtra on 2/25/2017.
 */
public class exampleX2 {

    public static void main(String[] args){
        X2  func = new X2();
        cvxopt optimizer = new cvxopt().setFuntion(func).setAlpha(0.0001);

        double minimum = optimizer.optimize();
        System.out.println(minimum);
        System.out.println(optimizer.stringify());
        }
}
