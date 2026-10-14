package recursion;

public class Recursion {


    static int factorial(int n){
        int answer = 1;
        while(n != 0){
            answer *= n;
            n--;
        }

        return answer;
    }


    static long fact(int n){
        if(n == 1){
            return 1;
        }

        return n * fact(n-1);
    }

    static void reverse(int n, int[] arr){
        if(n == 0){
            return;
        }

        System.out.println(arr[n]);

        reverse(n-1, arr);
    }


    static void arrayPrint(int n, int[] arr){
        if(n == arr.length){
            return;
        }

        System.out.println(arr[n]);

        arrayPrint(n+1, arr);

    }


    static int fab(int n){
        if(n == 0 || n == 1){
            return n;
        }

        return fab(n-1) + fab(n-2);

    }


    public static void main(String[] args) {
        //System.out.println(factorial(5));
        //System.out.println(fact(5));

//        int[][] arr = {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        };


        int arr[] = {1,2,4,3,4,5,6};

        // arrayPrint(0, arr);

     //   reverse(arr.length-1, arr);

        System.out.println(fab(20));


    }
}
