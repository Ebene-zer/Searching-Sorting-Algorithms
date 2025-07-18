package dsa.algorithms;

/*
    PSEUDOCODE:

ALGORITHM HeapSort(A)
  n ← length(A)

  // Step 1: Build max heap
  FOR i ← n/2 - 1 DOWNTO 0
    Heapify(A, n, i)

  // Step 2: Extract elements from heap
  FOR i ← n - 1 DOWNTO 1
    SWAP A[0], A[i]
    Heapify(A, i, 0)

ALGORITHM Heapify(A, n, i)
  largest ← i
  left ← 2*i + 1
  right ← 2*i + 2

  IF left < n AND A[left] > A[largest]
    largest ← left

  IF right < n AND A[right] > A[largest]
    largest ← right

  IF largest ≠ i
    SWAP A[i], A[largest]
    Heapify(A, n, largest)

 */


public class HeapSort {

    public static int[] sort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }

        return arr;
    }

    // To heapify a subtree rooted with node i
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;       // Initialize largest as root
        int left = 2 * i + 1;  // left child
        int right = 2 * i + 2; // right child

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}
