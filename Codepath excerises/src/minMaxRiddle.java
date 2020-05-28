import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the riddle function below.
    static long[] riddle(long[] arr) {
        // complete this function

        int size = arr.length;
      
        long[] windowSize = new long[size];
        long[] result = new long[size];

        Stack<Long> arrIdx = new Stack();
        Stack<Long> arrVal = new Stack();
        arrIdx.push(-1L);

        //count idx to the left
        for(int i = 0; i<size; i++){
           
            while(!arrVal.isEmpty() && arrVal.peek()>=arr[i]){
                arrIdx.pop();
                arrVal.pop();
            }

            windowSize[i] = i - arrIdx.peek() - 1;
            arrVal.push(arr[i]);
            arrIdx.push((long)i);
        }

        // count number to the right
        arrIdx.clear();
        arrVal.clear();
        arrIdx.push((long) size);

        for(int i = size-1; i>=0; i--){
           
            while(!arrVal.isEmpty() && arrVal.peek()>=arr[i]){
                arrIdx.pop();
                arrVal.pop();
            }

            windowSize[i] += arrIdx.peek() -i - 1;
            arrVal.push(arr[i]);
            arrIdx.push((long)i);
        }

        //fill results
        for(int i = 0; i < size; i++){
            result[(int) windowSize[i]] = Math.max(result[(int) windowSize[i]], arr[i]);
        }

        for(int i = size - 2; i>=0; i--){
            result[i] = Math.max(result[i],result[i+1]);
        }


    return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        long[] res = riddle(arr);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

