package dsa.algorithms;

/*
   PSEUDOCODE:

ALGORITHM MergeSort(A)
  IF size of A > 1
    mid ← length(A) / 2
    L ← left half of A
    R ← right half of A

    MergeSort(L)
    MergeSort(R)

    Merge L and R into A



       ==Merge Steps==
ALGORITHM Merge(L, R, A)
  i ← 0, j ← 0, k ← 0

  WHILE i < length(L) AND j < length(R)
    IF L[i] ≤ R[j]
      A[k] ← L[i]
      i ← i + 1
    ELSE
      A[k] ← R[j]
      j ← j + 1
    k ← k + 1

  COPY remaining elements from L and R to A

 */
public class MergeSort {

    /**
     * Public method to start the recursive merge sort.
     * @param arr the input array
     * @return a sorted copy of the array
     */
    public static int[] sort(int[] arr) {
        if (arr.length <= 1) return arr;

        int mid = arr.length / 2;

        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        return merge(sort(left), sort(right));
    }

    /**
     * Merges two sorted arrays into one.
     */
    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;

        // Merge elements
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) result[k++] = left[i++];
            else result[k++] = right[j++];
        }

        // Copy remaining elements
        while (i < left.length) result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];

        return result;
    }
}
