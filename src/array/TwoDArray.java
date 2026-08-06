package array;

public class TwoDArray{

    // traverse a array forward
    public static void printForward(int[][] arr){
        System.out.println("Print 2d array");
        for (int[] innerArr : arr) {
            for (int value : innerArr) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    // traverse array in reverse
    public static void printReverse(int[][] arr){
        System.out.println("Reverse 2d array");
        for(int i = arr.length - 1; i >= 0; i--){
            for (int j = arr[i].length - 1; j >= 0; j--) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // transpose of a array
    public static void printTranspose(int[][] arr){
        int rows = arr.length;
        int cols = arr[0].length;

        int[][] transpose = new int[cols][rows];

        System.out.println("Transpose");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = arr[i][j];
            }
        }

        for(int[] row: transpose ){
            for(int value: row){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public  static void main(String[]args){
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        printForward(arr);
        printReverse(arr);
        printTranspose(arr);
    }
}