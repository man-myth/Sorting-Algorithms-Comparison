import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class CountExecutions {

    /**
     * This method will count for the number of executions
     */
    public static void main(String[] args) {
        try {
            ArrayList <Integer> arrayA = readData("res/setAWorseCase.csv");
            ArrayList <Integer> arrayB = readData("res/setBWorseCase.csv");
            ArrayList <Integer> arrayC = readData("res/setCWorseCase.csv");
            ArrayList <Integer> arrayD = readData("res/setDWorseCase.csv");
            ArrayList <Integer> arrayE = readData("res/setEWorseCase.csv");

            System.out.println();
            System.out.printf( "| %10s | %25s | %25s | %25s | %n", "", "Bubble Sort", "Insertion Sort", "Selection Sort");

            long[] numberOfProcessesA = {bubbleSort(copyArray(arrayA)), insertionSort(copyArray(arrayA)), selectionSort(copyArray(arrayA))};
            System.out.printf( "| %10s | %,25d | %,25d | %,25d |%n", "Set A", numberOfProcessesA[0], numberOfProcessesA[1], numberOfProcessesA[2]);

            long[] numberOfProcessesB = {bubbleSort(copyArray(arrayB)), insertionSort(copyArray(arrayB)), selectionSort(copyArray(arrayB))};
            System.out.printf( "| %10s | %,25d | %,25d | %,25d |%n", "Set B", numberOfProcessesB[0], numberOfProcessesB[1], numberOfProcessesB[2]);

            long[] numberOfProcessesC = {bubbleSort(copyArray(arrayC)), insertionSort(copyArray(arrayC)), selectionSort(copyArray(arrayC))};
            System.out.printf( "| %10s | %,25d | %,25d | %,25d |%n", "Set C", numberOfProcessesC[0], numberOfProcessesC[1], numberOfProcessesC[2]);

            long[] numberOfProcessesD = {bubbleSort(copyArray(arrayD)), insertionSort(copyArray(arrayD)), selectionSort(copyArray(arrayD))};
            System.out.printf( "| %10s | %,25d | %,25d | %,25d |%n", "Set D", numberOfProcessesD[0], numberOfProcessesD[1], numberOfProcessesD[2]);

            long[] numberOfProcessesE = {bubbleSort(copyArray(arrayE)), insertionSort(copyArray(arrayE)), selectionSort(copyArray(arrayE))};
            System.out.printf( "| %10s | %,25d | %,25d | %,25d |%n", "Set E", numberOfProcessesE[0], numberOfProcessesE[1], numberOfProcessesE[2]);

            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }

    /**
     * read data from a CSV file and converts it to an ArrayList
     */
    public static ArrayList<Integer> readData(String filename) throws IOException {
        ArrayList<Integer> array = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = "";
        while ((line = br.readLine()) != null) {
            array.add(Integer.parseInt(line));
        }
        return array;
    }

    /**
     * makes a copy of ArrayList
     */
    public static ArrayList<Integer> copyArray(ArrayList<Integer> array){
        ArrayList<Integer> arrayCopy = new ArrayList<>(array);
        return arrayCopy;
    }

    /**
     * Bubble Sort Algorithm
     */
    public static long bubbleSort(ArrayList<Integer> array) {
        long counter = 0;
        int temp;
        boolean sorted = false;                                         // 1 assignment
        counter++;

        while (!sorted) {                                               // 1 logical comparison
            counter ++;
            sorted = true;                                              // 1 assignment
            counter ++;
            for (int i = 0; i < array.size()-1; i++) {                  // 1 assignment, 1 comparison, 2 operation
                counter += 4;
                if (array.get(i).compareTo(array.get(i + 1)) > 0) {     // 1 comparison, 1 operation
                    counter+=2;
                    temp = array.get(i);                                // 1 assignment
                    counter ++;
                    array.set(i, array.get(i + 1));                     // 1 assignment, 1 operation
                    counter += 2;
                    array.set(i + 1, temp);                             // 1 assignment, 1 operation
                    counter += 2;
                    sorted = false;                                     // 1 assignment
                    counter ++;
                }
            }
            counter ++;                                                 //last comparison of for loop condition
        }
        counter ++;                                                     // last comparison of while loop
        return counter;                                                 // Total  = 17

    }

    /**
     * Insertion Sort Algorithm
     */
    public static long insertionSort(ArrayList<Integer> array) {
        long counter = 0;

        for (int j = 1; j < array.size(); j++) {                    // 1 assignment, 1 comparison, 1 operation
            counter += 3;
            int current = array.get(j);                             // 1  assignment
            counter++;
            int i = j-1;                                            // 1 assignment, 1 operation
            counter += 2;
            while ((i > -1) && ((array.get(i).compareTo(current)) > 0)) {   // 3 comparison
                counter += 3;
                array.set(i+1, array.get(i));                       // 1 operation, i assignment
                counter += 2;
                i--;                                                // 1 operation
                counter ++;
            }
            counter ++;                                             // last comparison of while loop
            array.set(i+1, current);                                // 1 operation, 1 assignment
            counter ++;
        }
        counter ++;                                                 //last comparison of for loop condition
        return counter;                                             // Total = 16
    }

    /**
     * Selection Sort Algorithm
     */
    public static long selectionSort(ArrayList<Integer> array) {
        long counter = 0;
        for (int i = 0; i < array.size(); i++) {            // 1 assignment, 1 comparison , 1 operation
            counter += 3;
            int pos = i;                                    // 1 assignment
            counter++;
            for (int j = i; j < array.size(); j++) {        // 1 assignment, 1 comparison, i operation
                counter += 3;
                if (array.get(j) < array.get(pos)) {        // 1 comparison
                    counter++;
                    pos = j;                                // 1 assignment
                    counter++;
                }
            }
            counter ++;                                     // last comparison of for loop condition
            int min = array.get(pos);                       // 1 assignment
            counter ++;
            array.set(pos, array.get(i));                   // 1 assignment,
            counter ++;
            array.set(i, min);                              // 1 assignment
            counter ++;
        }
        counter ++;                                         // last comparison of for loop condition
        return counter;                                     // total = 14
    }
}
