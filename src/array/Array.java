package array;

public class Array {

    public static int[] delete(int[] arr, int key){
        int j = 0;
        int[] arr2 = new int[arr.length-1];
        for (int i : arr) {
            if (i != key) {
                arr2[j] = i;
                j++;
            }
        }

        return arr2;
    }

    public static int[] insert(int[] arr, int value, int key){

        int[] arr2 = new int[arr.length+1];

        for(int i = 0; i < key; i++){
            arr2[i] = arr[i];
        }
        arr2[key] = value;

        for (int i = key; i < arr.length; i++) {
            arr2[i+1] = arr[i];
        }

        return arr2;
    }

    public static void copy(int[] arr){
        int[] arr2 = new int[arr.length];

        System.arraycopy(arr, 0, arr2, 0, arr.length);

        for(int i: arr2){
            System.out.println(i);
        }

    }

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        int key = 30;
        int[] copiedArray = delete(arr, key);
        for (int num: copiedArray){
            System.out.println(num);
        }

        //copy array
        copy(arr);

        //insert
        int[] inserted = insert(arr,25,2);

        for(int num: inserted){
            System.out.println(num);
        }
    }
}
