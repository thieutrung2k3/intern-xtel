package d1;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 4, 5, -90, 222, -35};
        System.out.print("Original array: ");
        Arrays.stream(arr).forEach(value -> System.out.print(value + " "));

        //Sap xep giam dan
        selectionSort(arr);
        System.out.print("\nSorted array: ");
        Arrays.stream(arr).forEach(value -> System.out.print(value + " "));
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int min = i;
            // Tim min
            for(int j = i; j < n; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            //Swap
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

}
