// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

// class Tree {
//   public int x;
//   public Tree l;
//   public Tree r;
// }

import java.util.*;

class Solution {
    public int solution(Tree T) {
        // write your code in Java SE 8
         HashMap <Integer,Integer> map = new HashMap();
        
        if(T==null) return 0;
        
         if((T.l ==null&&T.r ==null)) return map.size()+1;
        
         
         return largestPath(T,map);
    }
    
    public int largestPath(Tree T, HashMap <Integer,Integer> map){
        
        
        if(T == null) return map.size();
        

        // if((T.l !=null&&T.r ==null)) return map.size()-1;
        
        
        if(map.containsKey(T.x)) map.put(T.x,map.get(T.x)+1);
        
        else map.put(T.x,1);
        
        int maxPath = Math.max(largestPath(T.l,map),largestPath(T.r,map));
        
        
        if(map.containsKey(T.x)) map.put(T.x,map.get(T.x)-1);
        
        if(map.get(T.x)==0) map.remove(T.x);
        
        return maxPath;
    }
    
}

