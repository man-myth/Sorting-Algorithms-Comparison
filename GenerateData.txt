import java.io.*;
import java.util.*;

public class GenerateData {

    /**
     * Main method of the Program
     */
    public static void main(String[] args) throws IOException {
        produceRandomDataSet("res/setA.csv", 10000);
        produceRandomDataSet("res/setB.csv", 50000);
        produceRandomDataSet("res/setC.csv", 200000);
        produceRandomDataSet("res/setD.csv", 500000);
        produceRandomDataSet("res/setE.csv", 1000000);
    }

    /**
     * Writes to or creates a CSV file
     */
    public static void writeData(ArrayList<Integer> array, String filename) throws FileNotFoundException {
        PrintWriter outputFile = new PrintWriter(filename);
        for (int integer : array) {
            outputFile.println(integer);
        }
        outputFile.close();
    }

    /**
     * Produces a CSV containing a randomly generated data set of integers
     */
    public static void produceRandomDataSet(String setName, int setSize) throws FileNotFoundException {
        ArrayList<Integer> array = new ArrayList<>();
        Random rn = new Random();
        int element;
        for (int i = 0; setSize > i; i++) {
            element = rn.nextInt(100);
            array.add(element);

        }
        writeData(array, setName);
    }


}


