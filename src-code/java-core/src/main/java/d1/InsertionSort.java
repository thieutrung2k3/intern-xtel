package d1;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 4, 5, -90, 222, -35};
        System.out.print("Original array: ");
        Arrays.stream(arr).forEach(value -> System.out.print(value + " "));

        insertionSort(arr);
        System.out.print("\nSorted array: ");
        Arrays.stream(arr).forEach(value -> System.out.print(value + " "));
    }
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

}
