package sort;

import common.ConfigUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class SortProgram {
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
        //Lay map chua cac gia tri cua file config
        Map<String, String> configMap = ConfigUtil.readConfigFile();

        //Lay gia tri mang
        String value = configMap.get("array");
        //Chuyen qua mang
        String[] arrayString = value.split(",");

        //Chuyen qua mang int
        int[] arrayInt = Arrays.stream(arrayString).mapToInt(Integer::parseInt).toArray();

        System.out.print("Origin array: ");
        Arrays.stream(arrayInt).forEach(i -> System.out.print(i + " "));
        quickSort(arrayInt, 0, arrayInt.length - 1);
        System.out.print("\nSorted array: ");
        Arrays.stream(arrayInt).forEach(i -> System.out.print(i + " "));

    }
}
