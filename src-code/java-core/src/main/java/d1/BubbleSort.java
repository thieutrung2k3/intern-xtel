package d1;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 4, 5, -90, 222, -35};
        System.out.print("Original array: ");
        Arrays.stream(arr).forEach(value -> System.out.print(value + " "));

        //Sap xep giam dan
        bubbleSort(arr);
        System.out.print("\nSorted array: ");
        Arrays.stream(arr).forEach(value -> System.out.print(value + " "));
    }

    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
