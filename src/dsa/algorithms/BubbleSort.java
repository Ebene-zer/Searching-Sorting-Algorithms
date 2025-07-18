package dsa.algorithms;

/*
     PSEUDOCODE:

ALGORITHM BubbleSort(A)
  n ← length(A)

  FOR i ← 0 TO n-1
    FOR j ← 0 TO n-i-2
      IF A[j] > A[j+1]
        SWAP A[j], A[j+1]

 */

/**
 * Bubble Sort implementation.
 */
public class BubbleSort {

    /**
     * Sorts the array using bubble sort algorithm.
     *
     * @param arr the input array
     * @return a sorted copy of the array
     */
    public static int[] sort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // Optimization: if no swaps, array is already sorted
            if (!swapped) break;
        }

        return arr;
    }
}
