package dsa.algorithms;

/*
     PSEUDOCODE:

ALGORITHM BinarySearch(A, target)
  low ← 0
  high ← length(A) - 1

  WHILE low ≤ high
    mid ← (low + high) / 2
    IF A[mid] == target
      RETURN mid
    ELSE IF A[mid] < target
      low ← mid + 1
    ELSE
      high ← mid - 1

  RETURN -1  // not found


 */


/**
 * Binary Search implementation on sorted arrays.
 */
public class BinarySearch {

    /**
     * Performs binary search on a sorted array.
     *
     * @param arr    the sorted array
     * @param target the value to search for
     * @return index of target if found, else -1
     */
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Not found
    }
}
