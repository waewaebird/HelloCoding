import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chapter7 {
    static Map<String, Map<String, Integer>> graph = new HashMap<>();
    static Map<String, Integer> costs = new HashMap<>();
    static Map<String, String> parents = new HashMap<>();
    static List<String> processed = new ArrayList<>();

    static {
        graph.put("start", Map.of("a",6,"b",2));
        graph.put("a", Map.of("fin",1));
        graph.put("b", Map.of("fin",5, "a",3));
        graph.put("fin", Map.of());

        costs.put("a", 6);
        costs.put("b", 2);
        costs.put("fin",Integer.MAX_VALUE);

        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);
    }

    public static String findLowestConstNode(Map<String, Integer> costs) {
        Integer lowestCost = Integer.MAX_VALUE;
        String lowestCostNode = null;

        for(String node : costs.keySet()) {
            Integer cost = costs.get(node);
            if(cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }
        return lowestCostNode;
    }

    public static void dijkstra() {
        String node = findLowestConstNode(costs);

        while (node != null) {
            Integer cost = costs.get(node);
            Map<String, Integer> neighbors = graph.get(node);

            for(String n : neighbors.keySet()) {
                Integer newCost = cost + neighbors.get(n);

                //System.out.println("정점 n : " + n);
                if(costs.get(n) > newCost) {
                    costs.put(n,newCost);
                    parents.put(n, node);
                }
            }
            processed.add(node);
            node = findLowestConstNode(costs);
        }
    }

    public static void main(String[] args) {
        dijkstra();
        System.out.println(processed);
    }
}
