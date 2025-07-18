package dsa.ui;

import dsa.algorithms.BinarySearch;
import dsa.utils.ComplexityUtil;


import javax.swing.*;
import java.awt.*;
import java.util.Arrays;


/**
 * GUI class for Binary Search input, execution, and result display.
 * Note: Input array must be sorted for Binary Search to work correctly.
 */
public class BinarySearchUI extends JFrame {

    private JTextField inputArrayField;
    private JTextField targetField;
    private JTextArea resultArea;

    public BinarySearchUI() {
        setTitle("Binary Search");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input"));

       //Sample data for use guide
        inputPanel.add(new JLabel("Sorted Array (comma-separated):"));
        inputArrayField = new JTextField("12, 23, 34, 56, 78, 89");
        inputPanel.add(inputArrayField);

        inputPanel.add(new JLabel("Target to Search:"));
        targetField = new JTextField("34");
        inputPanel.add(targetField);

        panel.add(inputPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Result Output"));
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton runButton = new JButton("Run Binary Search");
        runButton.addActionListener(e -> performBinarySearch());
        buttonPanel.add(runButton);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> {
            dispose();               // Close this window
            new MenuFrame();         // Reopen the main menu
        });
        buttonPanel.add(backButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        add(panel);
    }

    private void performBinarySearch() {
        try {
            // Parse input array
            String[] parts = inputArrayField.getText().split(",");
            int[] array = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                array[i] = Integer.parseInt(parts[i].trim());
            }

            // Ensure array is sorted (safety net)
            Arrays.sort(array);

            int target = Integer.parseInt(targetField.getText().trim());

            long startTime = System.nanoTime();
            int index = BinarySearch.search(array, target);
            long endTime = System.nanoTime();

            StringBuilder output = new StringBuilder();
            output.append("Binary Search Result:\n");
            output.append("Target: ").append(target).append("\n");
            output.append("Array: ").append(Arrays.toString(array)).append("\n");

            if (index != -1) {
                output.append("Status: Found at index ").append(index).append("\n");
            } else {
                output.append("Status: Not Found\n");
            }

            output.append("\nTime Taken: ").append(endTime - startTime).append(" ns\n");
            output.append("Complexity: ").append(ComplexityUtil.binarySearch()).append("\n");
            output.append("\nPseudocode:\n").append(ComplexityUtil.binarySearchPseudocode());

            resultArea.setText(output.toString());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter only comma-separated integers.", "Format Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unexpected error: " + e.getMessage(), "System Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
