package recursion;

public class Practice {

    static void printNum(int n){
        if(n == 0){
            return;
        }
        System.out.print(n + " ");

        printNum(n-1);
    }

    static void printSpecific(int n, int end){
        if(n == end){
            return;
        }
        System.out.print(n + " ");

        printSpecific(n-1, end);
    }

    static int sum(int n){
        if(n == 0){
            return 0;
        }

        return n + sum(n-1);
    }

    static int fab(int n){
        if(n == 0 || n == 1){
            return n;
        }

        return fab(n-1) + fab(n-2);

    }


    public static void main(String[] args) {
        //printNum(5);
        //printSpecific(5,1);
//        System.out.println(sum(5));
//        System.out.println(fab(6));

        for (int i = 0; i < 5; i++) {
            System.out.println(fab(i));
        }
    }
}
