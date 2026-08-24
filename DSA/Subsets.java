import java.util.ArrayList;
import java.util.List;

public class Subsets {
  public List<List<Integer>> subsets(int[] n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n.length < 1) return res;
        helper(res, new ArrayList<>(), n, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> cur, int[] n, int index) {
        if (index == n.length) {
            res.add(cur);
            return;
        }
        
        cur.add(n[index]);
        helper(res, cur, n, index + 1);
        cur.remove(cur.size() - 1);
        helper(res, cur, n, index + 1);
    }
}