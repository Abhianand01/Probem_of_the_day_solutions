import java.util.ArrayList;
import java.util.HashMap;

public class DistinctDifference{

    /*
     * Take two hasmap one for left and one for right,
     * initially you will be in 0th position , so the left map contains no element and right map
     * contains all the elements  that is from 0 to N-1 and its count.
     * 
     * do: 
     *      iterate from 0 to N-1
     *      decrease the count of curr element from right , if count is zero remove it from right map
     *      for position i the ans will be left.size()-right.size()
     *      now add ith element to left map
     * */

    public static ArrayList<Integer> getDistinctDifference(int N, int[] A) {   
        
        HashMap<Integer,Integer> right=new HashMap<>();
        HashMap<Integer,Integer> left =new HashMap<>();
        
        for(int i=0;i<N;i++){
            right.put(A[i],right.getOrDefault(A[i],0)+1);        
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<N;i++){
             if(right.get(A[i])==1){
                 right.remove(A[i]);
             }else{
                 right.put(A[i],right.get(A[i])-1);
             }
            
            ans.add(left.size()-right.size());        
            left.put(A[i],right.getOrDefault(A[i],0)+1);
              
        }    
        return ans;
    }
}