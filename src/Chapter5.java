import java.util.HashMap;

public class Chapter5 {
    static HashMap<String, Boolean> voter = new HashMap<String, Boolean>();
    public static void checkVoter(String name) {
        if(voter.get(name)) {
            System.out.println("쫓아내세요");
        } else {
            voter.put(name,Boolean.TRUE);
            System.out.println("투표 Go");
        }
    }

    static HashMap<String, String> cache = new HashMap<>();
    public static void getPage(String url) {
        if(cache.containsKey(url)) {
            System.out.println(cache.get(url));
        } else {
            cache.put(url, "data");
        }
    }


    public static void test() throws InterruptedException {
        HashMap<Integer, String> temp = new HashMap<Integer, String>(1000);


        temp.put(0,"00");
        temp.put(1,"11");
        System.out.println(temp);

        Thread.sleep(10000);

        System.out.println(temp.size());
    }


    public static void main(String[] args) throws InterruptedException {
        //checkVoter("tom");
        //getPage("www.www");
        test();
    }
}
