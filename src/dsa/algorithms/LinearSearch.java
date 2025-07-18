package dsa.algorithms;

/*    PSEUDOCODE:

ALGORITHM LinearSearch(A, target)
FOR i ← 0 TO length(A) - 1
IF A[i] == target
RETURN i
RETURN -1  // not found
*/


/**
 * Contains logic for performing a Linear Search on an array.
 */
public class LinearSearch {

    /**
     * Searches for the target element in the array using linear search.
     * @param arr the array to search
     * @param target the number to find
     * @return index of target if found, else -1
     */
    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Not found
    }
}
