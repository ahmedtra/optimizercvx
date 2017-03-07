import com.opencsv.CSVReader;
import org.apache.commons.math3.util.Pair;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ahmedtra on 3/2/2017.
 */
public class LinearRegressionExpWeightedExemple {
    public static void main(String[] args) throws IOException {

        Pair<double[][], double[]> data = readData("src\\main\\resources\\test_exponetial_weighted_reg.csv", 2, 2000);
        double[][] x = data.getFirst();
        double[] y = data.getSecond();

        for (int i = 500; i<x.length; i+= 100){
            double[][] x_new = new double[i][x[0].length];
            double[] y_new = new double[i];

            for(int j = 0; j<i; j++){
                y_new[j] = y[j];
                for(int k = 0; k<x[0].length ; k++){
                    x_new[j][k] = x[j][k];
                }
            }

            LinRegressionExponetialLocalWeights reg = new LinRegressionExponetialLocalWeights(x_new, y_new).Regularisation(true).lasso(0.2);
//            reg.updateBeta();
            System.out.println(reg.stringify());
        }


    }

    public static Pair<double[][], double[]> readData(String dataFile, int nbReg, int  nbLine) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(dataFile));
        String[] nextLine;

        double[][] x = new double[nbLine][nbReg];
        double[] y = new double[nbLine];
        int i = 0;

        while (((nextLine = reader.readNext()) != null) && i < nbLine) {
            y[i] = Double.parseDouble(nextLine[1]);
            for (int j = 0; j < nbReg; j++) {
                x[i][j] = Double.parseDouble(nextLine[j + 2]);
            }
            i++;
        }
        return new Pair<double[][], double[]> (x,y);
    }

}
