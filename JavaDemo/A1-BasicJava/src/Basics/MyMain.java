package Basics;

public class MyMain {
    private static int square(int n){
        return n*n;
    }

    private static String getNumberDescription(int n){
        boolean isEven = (n%2) == 0;
        String evenStr;

        if (isEven){
            evenStr = "even";
        }
        else{
            evenStr = "odd";
        }

        int squared = square(n);
        double root = Math.sqrt(n);

        return "Number " + n
                + " is" + evenStr
                + ", square is " + squared
                + ", square root " + root;
    }
    public static void main(String args[]){
        System.out.println("Hello world from Java!");
        System.out.println("type sout");
        int squared = square(42);
        System.out.println("42^2 = " + squared);

        String info = getNumberDescription(42);
        System.out.println(info);

        for (int i=0; i<10; i++){
            System.out.println(getNumberDescription(i));
        }
    }
}
