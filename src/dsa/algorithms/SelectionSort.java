package dsa.algorithms;

/*
      PSEUDOCODE:
ALGORITHM SelectionSort(A)
  n ← length(A)

  FOR i ← 0 TO n-1
    minIndex ← i
    FOR j ← i+1 TO n-1
      IF A[j] < A[minIndex]
        minIndex ← j

    SWAP A[i] and A[minIndex]

 */

/**
 * Selection Sort implementation.
 */
public class SelectionSort {

    /**
     * Sorts an array using the selection sort algorithm.
     * @param arr the input array
     * @return a sorted copy of the array
     */
    public static int[] sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the minimum element in unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap found minimum with current position
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        return arr;
    }
}
