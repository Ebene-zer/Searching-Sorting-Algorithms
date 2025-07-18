package dsa.algorithms;

/*
   PSEUDOCODE

ALGORITHM InsertionSort(A)
  n ← length(A)

  FOR i ← 1 TO n-1
    key ← A[i]
    j ← i - 1

    WHILE j ≥ 0 AND A[j] > key
      A[j+1] ← A[j]
      j ← j - 1

    A[j+1] ← key

 */

/**
 * Insertion Sort implementation.
 */
public class InsertionSort {

    /**
     * Sorts the array using insertion sort algorithm.
     * @param arr the input array
     * @return a sorted copy of the array
     */
    public static int[] sort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        return arr;
    }
}
