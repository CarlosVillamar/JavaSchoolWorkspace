// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.*;

class Solution {
    public int[] solution(int N) {
        // write your code in Java SE 8
        
        //we know that the biggest number in the array will not be more than N/2
        //range of numbers to expect is -halfN....halfN
        
        //if half of N has a reminder we need to add in 0
        
        Set<Integer> set = new HashSet();
        
        int reminder = N%2;
        int halfN = N/2;
        
        for(int i =0; i<halfN; i++){
            
            if(!set.contains(halfN-i)) set.add(-(halfN-i));
            
        }
        
        for(int i =0; i<halfN; i++){
            
            if(!set.contains(halfN-i)) set.add((halfN-i));
            
        }
        
        if(reminder !=0 ) set.add(0);
        
        int[] newArr = new int[set.size()];
        
        int y =0;
        
        for(int i: set){
            newArr[y] = i;
            y++;
        }
        
        return newArr;
        
    }
}

