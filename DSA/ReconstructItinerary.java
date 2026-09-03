import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {
  public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();

        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }

        dfs("JFK", flights, res);
        return res;
    }

    public void dfs(String dep, Map<String, PriorityQueue<String>> flights, LinkedList<String> res) {
        PriorityQueue<String> arrivals = flights.get(dep);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), flights, res);
        }

        res.addFirst(dep);
    }
}