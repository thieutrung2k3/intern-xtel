package d1;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 4, 5, -90, 222, -35};
        System.out.print("Original array: ");
        Arrays.stream(arr).forEach(value -> System.out.print(value + " "));

        quickSort(arr, 0, arr.length - 1);
        System.out.print("\nSorted array: ");
        Arrays.stream(arr).forEach(value -> System.out.print(value + " "));
        }
    }

