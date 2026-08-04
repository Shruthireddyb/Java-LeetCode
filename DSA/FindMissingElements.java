
import java.util.*;

class findMissingElements{
    public List<Integer> findmissingElements(int[] n) {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int num:n){
            min=Math.min(min,num);
            max=Math.max(max,num);
        }
        HashSet<Integer> present=new HashSet<>();
        for(int num:n){
            present.add(num);
        }
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=min;i<=max;i++){
            if(!present.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
}