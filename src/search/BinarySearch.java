package search;
/*
BASIC CONCEPT
Binary search finds an element by repeatedly dividing a sorted array into two halves.
It checks the middle element and searches only the half where the target can be.
*/

public class BinarySearch {

    public static int binarySearch(int[] arr,int key){

        int start = 0;
        int end  = arr.length-1;

        while(start<=end){
            //int mid = (start+end)/2; start and end can overflow
            int mid = start + (end - start)/2;
            if(key > arr[mid]){
                start = mid+1;
            } else if(key < arr[mid]){
                end = mid-1;
            }else{
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {-1, 0, 3, 4, 5, 9, 12}; //odd

        int[] arr2 = {-1, 0, 3, 5, 9, 12}; //even

        System.out.println("Index of 12: "+ binarySearch(arr1,12));
        System.out.println("Index of 3: " + binarySearch(arr2,3));

    }
}
