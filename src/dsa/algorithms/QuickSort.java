package dsa.algorithms;

/*
     PSEUDOCODE:

ALGORITHM QuickSort(A, low, high)
  IF low < high
    pivotIndex ← Partition(A, low, high)
    QuickSort(A, low, pivotIndex - 1)
    QuickSort(A, pivotIndex + 1, high)

ALGORITHM Partition(A, low, high)
  pivot ← A[high]
  i ← low - 1

  FOR j ← low TO high - 1
    IF A[j] < pivot
      i ← i + 1
      SWAP A[i], A[j]

  SWAP A[i + 1], A[high]
  RETURN i + 1

 */


/**
 * Quick Sort implementation.
 */
public class QuickSort {

    /**
     * Sorts the array in place using Quick Sort.
     * @param arr the array
     * @param low the starting index
     * @param high the ending index
     */
    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    /**
     * Partitions the array using the last element as pivot.
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot to correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
