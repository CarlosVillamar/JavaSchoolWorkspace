// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.*;

class Solution {
    public int solution(int[] ranks) {
        // write your code in Java SE 8
        
        int rankCount =0;
        
        Map<Integer,Integer> map = new HashMap();
        
        //check how many times each element occurs in the arr and store into the map
        
        
        //keep track of the highs and lows of the array 
        int highRank =0;
        int lowRank = Integer.MAX_VALUE;
        
        for(int i: ranks){
            
            //reassign the ranks if possible
            if(highRank<i) highRank = i;
            if(lowRank>i) lowRank = i;
            
            if(map.containsKey(i)) 
                map.put(i,map.get(i)+1);
            
            else
                map.put(i,1);
        }
        
        //count the number of times a solider has no one to report to in theory
        int skipCount =0;
        
        //iterate throught the map to check the occurances of each rank except the highest
        
        for(int y: map.keySet()){
            if(y==highRank) break;
            
            if(map.get(y)>=1&&y>lowRank){
                //if the rank is higher than the lowest rank and there are more than 1 add them to the count with the addition of those ranks that are under underneth this one
                rankCount+=(map.get(y)+skipCount);
                
                //reasign lowRank to this current rank to keeptrack
                lowRank=y;
                
            }
            
            if(map.get(y)==1&&y==lowRank){
                lowRank+=2;
                skipCount++;
            }
            
        }

        return rankCount;
        
    }
}

