package dsa.runner;

import dsa.ui.*;
// Future: import dsa.ui.BubbleSortUI; etc.

import javax.swing.*;

/**
 * Launches the corresponding algorithm interface based on user selection.
 */
public class AlgorithmRunner {

    public static void run(String algorithm) {
        switch (algorithm) {
            case "Linear Search":
                new LinearSearchUI();
                break;
            case "Binary Search":
                new BinarySearchUI();
                break;
            case "Bubble Sort":
                new BubbleSortUI();
                break;
            case "Selection Sort":
                new SelectionSortUI();
                break;
            case "Insertion Sort":
                new InsertionSortUI();
                break;
            case "Merge Sort":
                new MergeSortUI();
                break;
            case "Quick Sort":
                new QuickSortUI();
                break;
            case "Heap Sort":
                new HeapSortUI();
                break;


            default:
                JOptionPane.showMessageDialog(null,
                        "This algorithm is not yet implemented.",
                        "Coming Soon",
                        JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
