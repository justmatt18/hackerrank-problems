// Exam Code: 
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        String inWords = "";
        String[] hr = {"one","two", "three", "four", "five", "six", "seven", "eight",                             "nine", "ten","eleven", "twelve"};
        String[] min = {"one","two", "three", "four", "five", "six", "seven", "eight",       "nine", "ten", "eleven","twelve", "thirteen", "fourteen", "quarter", "sixteen",         "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty      three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight",      "twenty nine", "half"};

        if (m == 0){
            inWords = hr[h-1] + " o' clock";
        }else if(m >= 1 && m <= 30){// if min >= 1 and min <= 30  - "past"
            if (m==1){
                inWords = min[m-1] + " minute past " + hr[h-1];
            }else if(m == 15){
                inWords = "quarter past " +hr[h-1];
            }else if (m == 30){
                inWords = "half past " +hr[h-1];
            }else
                inWords = min[m-1] + " minutes past " + hr[h-1];       
        } else if(m > 30){ // if min > 30 - "to"
            int m2 = 60 - m; 
            int h2;
            if(h == 12){
                h2 = 0;
            }else{
                h2 = h;
            }
            if (m2==1){
                inWords = min[m2-1] + " minute to " + hr[h2];
            }else if(m2 == 15){
                inWords = "quarter to " +hr[h2];
            }else{
                inWords = min[m2-1] + " minutes to " + hr[h2]; 
            } 
        }
        
        return inWords;
    }

    private static int[] getRanks(SortedSet<Integer> uniqueScores, int[] alice) {
        int[] ranks = new int[alice.length];
        int i = 0;
        while (i < alice.length) {
            uniqueScores.add(alice[i]);
            ranks[i] = new ArrayList<>(uniqueScores).indexOf(alice[i]) + 1;
            i++;
        }

        return ranks;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}