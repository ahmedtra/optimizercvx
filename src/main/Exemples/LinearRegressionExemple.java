import com.opencsv.CSVReader;

import org.apache.commons.math3.util.Pair;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ahmedtra on 3/2/2017.
 */
public class LinearRegressionExemple {
    public static void main(String[] args) throws IOException {

        Pair<double[][], double[]> data = readData("src\\main\\resources\\test_random_data.csv", 2, 4000);
        double[][] x = data.getFirst();
        double[] y = data.getSecond();
        LinRegression  reg = new LinRegression(x, y).Regularisation(true).lasso(.001);

        System.out.println(reg.stringify());
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
