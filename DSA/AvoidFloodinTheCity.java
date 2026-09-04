import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AvoidFloodinTheCity {
  public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        TreeSet<Integer> emptyLakes = new TreeSet<>();
        Map<Integer, Integer> fullLakes = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake > 0) {
                res[i] = -1;
                
                if (fullLakes.containsKey(lake)) {
                    Integer emptyDay = emptyLakes.higher(fullLakes.get(lake));
                    if (emptyDay == null) return new int[0];
                    
                    res[emptyDay] = lake;
                    emptyLakes.remove(emptyDay);
                }
                
                fullLakes.put(lake, i);
            } else {
                emptyLakes.add(i);
            }
        }
        
        return res;
    }
}