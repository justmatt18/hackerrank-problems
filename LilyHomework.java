// Exam Code: 

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the lilysHomework function below.
    static int lilysHomework(int[] arr) {
        // work goal
        int[] sortedWork = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedWork);

        int swapCountAscendingOrder = helpSolve(Arrays.copyOf(arr, arr.length), arr.length, sortedWork);
        fastReverse(sortedWork);
        int swapCountDescendingOrder = helpSolve(Arrays.copyOf(arr, arr.length), arr.length, sortedWork);

        return Math.min(swapCountAscendingOrder, swapCountDescendingOrder);
    }


    private static int helpSolve(int[] currentValues, int arraySize, int[] sortedWork) {
        int swapCount = 0;
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        // store current values with its current index position in map
        for (int i = 0; i < arraySize; i++) {
        valueIndexMap.put(currentValues[i], i);
        }

        for (int i = 0; i < arraySize; i++) {
            if (currentValues[i] != sortedWork[i]) {
                // search the index position of value sortedWork[i] in the input array
                int index = valueIndexMap.get(sortedWork[i]);

                // swap the sortedWork[i] with currentValues[i]
                swap(currentValues, i, index);

                // modify index position of currentValues[index] inside the valueIndexMap map
                valueIndexMap.put(currentValues[index], index);

                swapCount++;
            }
        }

        return swapCount;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // swaps the array's first element with last element,
    // second element with last second element
    // third element with the last third element and etc.
    static void fastReverse(int a[]) {
        int i, k, t;
        for (i = 0; i < a.length / 2; i++) {
        t = a[i];
        a[i] = a[a.length - i - 1];
        a[a.length - i - 1] = t;
        }
    }

    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
