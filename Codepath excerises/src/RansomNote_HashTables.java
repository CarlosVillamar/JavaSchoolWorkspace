import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Set<String> set = new HashSet();
        
        Hashtable<String, Integer> mag  = new Hashtable();
        Hashtable<String, Integer> ransom = new Hashtable();

        boolean result = true;



        for(String s1 : magazine){
            mag.put(s1,mag.getOrDefault(s1,0)+1);
        }

        for(String s2 : note){
            if(mag.getOrDefault(s2,0)==0){
                result = false;
            }else{
                mag.put(s2,mag.get(s2)-1);
            }
        }

       if(result){
           System.out.println("Yes");
       }else{
           System.out.println("No");
       }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}

