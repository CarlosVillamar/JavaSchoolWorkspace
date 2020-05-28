import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class time_convert {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here
         */

         StringBuilder hour = new StringBuilder();
         StringBuilder timeOfDay = new StringBuilder(); 
         StringBuilder newStr = new StringBuilder(s); 

         timeOfDay =  timeOfDay.append(s.subSequence(s.length()-2,s.length()));
         hour = hour.append(s.subSequence(0,2));
        
         int hr = Integer.parseInt(hour.toString());

         String tod = timeOfDay.toString();

        System.out.println(hr);
         if(tod.equals("AM")&&hr==12){
             
            newStr = newStr.replace(0,2,"00");
        }   
         

        if(tod.equals("PM")&&hr<12){

            hr = hr+12;

            newStr = newStr.replace(0,2,String.valueOf(hr));
        }

            newStr= newStr.delete(s.length()-2,s.length());

         return newStr.toString();

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // String s = scan.nextLine();

        String s = "12:40:22AM";

        String result = timeConversion(s);

        System.out.println(result);

        // bw.write(result);
        // bw.newLine();

        // bw.close();
    }
}
