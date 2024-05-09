public class Chapter3 {
    private static void countdown(int i) {
        System.out.println(i);

        if(i <= 1) {
            return;
        } else {
            countdown(i-1);
        }
    }

    private static void greet(String name) {
        System.out.println("hello, " + name + "!");
        greet2(name);
        bye();
    }

    private static void greet2(String name) {
        System.out.println("how are u, " + name + "?");
    }

    private static void bye() {
        System.out.println("Bye");
    }

    private static int fact(int x){
        if(x == 1) {
            return 1;
        } else {
            return x * fact(x-1);
        }
    }


    public static void main(String[] args) {
        //countdown(30);
        //greet("RRRR");
        System.out.println(fact(3));
    }
}
