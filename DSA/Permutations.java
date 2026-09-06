import java.util.ArrayList;
import java.util.List;

public class Permutations {
  public List<List<Integer>> permute(int[] nu) {
        List<List<Integer>> res = new ArrayList<>();
        if (nu.length < 1) return res;
        helper(res, new ArrayList<>(), nu, new boolean[nu.length]);
        return res;
    }
    
    private void helper(List<List<Integer>> res, 
        List<Integer> cur, int[] nu, boolean[] visited) {
        if (cur.size() == nu.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = 0; i < nu.length; i++) {
            if (visited[i]) continue;
            cur.add(nu[i]);
            visited[i] = true;
            helper(res, cur, nu, visited);
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }
    }
}