import java.util.*;

public class ContainsDuplicate {
  public boolean containsDuplicate(int[] n) {
        Set<Integer> intSet=new HashSet<>();
        for(int num:n){
            if(intSet.contains(num))
              return true;
            intSet.add(num);
        }
        return false;
    }
}
