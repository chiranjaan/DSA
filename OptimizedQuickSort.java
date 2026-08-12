/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

/**
 *
 * @author DELL
 */
public class OptimizedQuickSort {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {

        while (low < high) {

            
            if (high - low + 1 <= 10) {
                insertionSort(arr, low, high);
                return;
            }

            
            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[low]) {
                swap(arr, low, mid);
            }

            if (arr[high] < arr[low]) {
                swap(arr, low, high);
            }

            if (arr[high] < arr[mid]) {
                swap(arr, mid, high);
            }

            int pivot = arr[mid];

            // Move pivot to the end
            swap(arr, mid, high - 1);

            int i = low;
            int j = high - 1;

            while (true) {

                while (arr[++i] < pivot) {
                }

                while (arr[--j] > pivot) {
                }

                if (i >= j) {
                    break;
                }

                swap(arr, i, j);
            }

            swap(arr, i, high - 1);

            
            if (i - low < high - i) {
                quickSort(arr, low, i - 1);
                low = i + 1;
            } else {
                quickSort(arr, i + 1, high);
                high = i - 1;
            }
        }
    }

    private static void insertionSort(int[] arr, int low, int high) {

        for (int i = low + 1; i <= high; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {40, 20, 60, 10, 50, 30, 70};

        quickSort(arr);

        System.out.println("Sorted Array:");

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
