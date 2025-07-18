package dsa.utils;

/**
 * Provides complexity information and pseudocode for various algorithms.
 */
public class ComplexityUtil {

    // === Linear Search ===
    public static String linearSearch() {
        return "Time: O(n), Space: O(1)";
    }

    public static String linearSearchPseudocode() {
        return """
            ALGORITHM LinearSearch(array A, target)
              FOR i = 0 TO length(A) - 1
                IF A[i] == target
                  RETURN i
              END FOR
              RETURN -1
            """;
    }

    // === Binary Search ===
    public static String binarySearch() {
        return "Time: O(log n), Space: O(1)";
    }

    public static String binarySearchPseudocode() {
        return """
            ALGORITHM BinarySearch(array A, target)
              left = 0
              right = length(A) - 1
              WHILE left <= right
                mid = (left + right) / 2
                IF A[mid] == target
                  RETURN mid
                ELSE IF A[mid] < target
                  left = mid + 1
                ELSE
                  right = mid - 1
              RETURN -1
            """;
    }

    // === Bubble Sort ===
    public static String bubbleSort() {
        return "Time: O(n^2), Space: O(1)";
    }

    public static String bubbleSortPseudocode() {
        return """
            ALGORITHM BubbleSort(array A)
              FOR i = 0 TO n - 2
                swapped = false
                FOR j = 0 TO n - i - 2
                  IF A[j] > A[j+1]
                    SWAP A[j] and A[j+1]
                    swapped = true
                IF NOT swapped
                  BREAK
            """;
    }


    public static String selectionSort() {
        return "Time: O(n^2), Space: O(1)";
    }

    public static String selectionSortPseudocode() {
        return """
        ALGORITHM SelectionSort(array A)
          FOR i = 0 TO n-2
            minIndex = i
            FOR j = i+1 TO n-1
              IF A[j] < A[minIndex]
                minIndex = j
            IF minIndex ≠ i
              SWAP A[i] and A[minIndex]
        """;
    }


    public static String insertionSort() {
        return "Time: O(n^2), Space: O(1)";
    }

    public static String insertionSortPseudocode() {
        return """
        ALGORITHM InsertionSort(array A)
          FOR i = 1 TO n-1
            key = A[i]
            j = i - 1
            WHILE j >= 0 AND A[j] > key
              A[j + 1] = A[j]
              j = j - 1
            A[j + 1] = key
        """;
    }


    public static String mergeSort() {
        return "Time: O(n log n), Space: O(n)";
    }

    public static String mergeSortPseudocode() {
        return """
        ALGORITHM MergeSort(array A)
          IF length(A) <= 1
            RETURN A
          mid = length(A) / 2
          left = MergeSort(A[0...mid-1])
          right = MergeSort(A[mid...n-1])
          RETURN Merge(left, right)

        FUNCTION Merge(L, R)
          result = empty array
          WHILE L and R not empty
            IF L[0] ≤ R[0]
              append L[0] to result, remove L[0]
            ELSE
              append R[0] to result, remove R[0]
          APPEND remaining elements of L and R
          RETURN result
        """;
    }

    public static String quickSort() {
        return "Time: O(n log n) average, O(n^2) worst; Space: O(log n)";
    }

    public static String quickSortPseudocode() {
        return """
        ALGORITHM QuickSort(array A, low, high)
          IF low < high
            pivotIndex = Partition(A, low, high)
            QuickSort(A, low, pivotIndex - 1)
            QuickSort(A, pivotIndex + 1, high)

        FUNCTION Partition(A, low, high)
          pivot = A[high]
          i = low - 1
          FOR j = low TO high - 1
            IF A[j] <= pivot
              i++
              SWAP A[i], A[j]
          SWAP A[i + 1], A[high]
          RETURN i + 1
        """;
    }


    public static String heapSort() {
        return "Time: O(n log n), Space: O(1)";
    }

    public static String heapSortPseudocode() {
        return """
        ALGORITHM HeapSort(array A)
          BUILD-MAX-HEAP(A)
          FOR i = length(A) - 1 TO 1
            SWAP A[0] and A[i]
            HEAPIFY(A, 0, i)

        FUNCTION BUILD-MAX-HEAP(A)
          FOR i = ⌊n/2⌋ - 1 DOWNTO 0
            HEAPIFY(A, i, n)

        FUNCTION HEAPIFY(A, i, n)
          largest = i
          left = 2*i + 1
          right = 2*i + 2
          IF left < n AND A[left] > A[largest]
            largest = left
          IF right < n AND A[right] > A[largest]
            largest = right
          IF largest ≠ i
            SWAP A[i] and A[largest]
            HEAPIFY(A, largest, n)
        """;
    }

}

