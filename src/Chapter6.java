import java.util.*;

public class Chapter6 {

    public static String personIsSeller(String name) {
        String last = name.substring(name.length()-1).toLowerCase();
        if(last.equals("m")) {
            return name;
        } else {
            return null;
        }
    }

    public static Boolean queue(String name) {
        Map<String, String[]> graph = new HashMap<>();
        graph.put("you", new String[]{"alice", "bob", "claire"});
        graph.put("bob", new String[]{"anuj", "peggy"});
        graph.put("alice", new String[]{"peggy"});
        graph.put("claire", new String[]{"thom","jonny"});
        graph.put("anuj", new String[]{});
        graph.put("peggy", new String[]{});
        graph.put("thom", new String[]{});
        graph.put("jonny", new String[]{});

        Queue<String> searchQue = new LinkedList<>();
        for(String tempName : graph.get(name)) {
            searchQue.add(tempName);
        }

        ArrayList<String> searched = new ArrayList<>();

        while (!searchQue.isEmpty()) {
            String person = searchQue.poll();
            if(!searched.contains(person)) {
                if(personIsSeller(person) != null) {
                    System.out.println(person + " is a mango seller!");
                    return true;
                } else {
                    for(String tempName : graph.get(person)) {
                        searchQue.add(tempName);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        queue("you");
    }
}
