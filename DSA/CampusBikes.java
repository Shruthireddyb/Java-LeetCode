import java.util.*;

public class CampusBikes {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        int m = bikes.length;
        int[] res = new int[n];
        boolean[] assigned = new boolean[n];
        boolean[] occupied = new boolean[m];
        @SuppressWarnings("unchecked")
        List<int[]>[] list = new ArrayList[2001];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int dist = dist(workers[i], bikes[j]);
                if (list[dist] == null) list[dist] = new ArrayList<>();
                list[dist].add(new int[]{i, j});
            }
        }
        int count = 0;
        for(int d=0; d<2001 && count < n; d++){
            if(list[d]==null) continue;
            for(int[] pair: list[d]){
                if(!assigned[pair[0]] &&!occupied[pair[1]]){
                    assigned[pair[0]] = true;
                    occupied[pair[1]] = true;
                    res[pair[0]] = pair[1];
                    count++;
                }
            }
        }
        return res;
    }
    private int dist(int[] w, int[] b){
        return Math.abs(w[0]-b[0]) + Math.abs(w[1]-b[1]);
    }
}