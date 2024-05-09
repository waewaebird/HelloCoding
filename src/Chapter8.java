import java.util.*;

public class Chapter8 {
    public static void greed() {
        Set<String> statesNeeded = new LinkedHashSet<>(){
            {
                add("mt");
                add("wa");
                add("or");
                add("id");
                add("nv");
                add("ut");
                add("ca");
                add("az");
            }
        };

        Map<String, Set<String>> stations = new HashMap<>();
        stations.put("kone", new LinkedHashSet<>(){
            {
                add("id");
                add("nv");
                add("ut");
            }
        });
        stations.put("ktwo", new LinkedHashSet<>(){
            {
                add("wa");
                add("id");
                add("mt");
            }
        });
        stations.put("kthree", new LinkedHashSet<>(){
            {
                add("or");
                add("nv");
                add("ca");
            }
        });
        stations.put("kfour", new LinkedHashSet<>(){
            {
                add("nv");
                add("ut");
            }
        });
        stations.put("kfive", new LinkedHashSet<>(){
            {
                add("ca");
                add("az");
            }
        });
        Set<String> finalStations = new LinkedHashSet<>();

        while(true) {
            String bestStation = null;
            Set<String> statesCovered = new LinkedHashSet<>();

            for (Map.Entry<String, Set<String>> entry : stations.entrySet()) {
                String station = entry.getKey();
                Set<String> statesForStation = entry.getValue();

                Set<String> covered = new LinkedHashSet<>(statesNeeded);
                covered.retainAll(statesForStation);

                if (covered.size() > statesCovered.size()) {
                    bestStation = station;
                    statesCovered = covered;
                }
            }
            statesNeeded.removeAll(statesCovered);
            finalStations.add(bestStation);

            if(statesNeeded.isEmpty()) {
                break;
            }
        }
        System.out.println(finalStations);
    }

    public static void main(String[] args) {
        greed();

    }
}
