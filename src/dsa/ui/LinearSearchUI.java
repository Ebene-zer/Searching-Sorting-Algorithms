package dsa.ui;

import dsa.algorithms.LinearSearch;
import dsa.utils.ComplexityUtil;

import javax.swing.*;
import java.awt.*;

/**
 * GUI class for running and displaying Linear Search results.
 */
public class LinearSearchUI extends JFrame {

    private JTextField inputArrayField;
    private JTextField targetField;
    private JTextArea resultArea;

    public LinearSearchUI() {
        setTitle("Linear Search");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();
        setVisible(true);
    }

    /**
     * Builds and arranges all components of the Linear Search GUI.
     */
    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // === Top Input Fields ===
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input"));

        inputPanel.add(new JLabel("Array (comma-separated):"));
        inputArrayField = new JTextField("34, 67, 23, 89, 12");
        inputPanel.add(inputArrayField);

        inputPanel.add(new JLabel("Target to Search:"));
        targetField = new JTextField("23");
        inputPanel.add(targetField);

        panel.add(inputPanel, BorderLayout.NORTH);

        // === Result Output Area ===
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Result Output"));

        panel.add(scrollPane, BorderLayout.CENTER);

        // === Bottom Buttons ===
        JPanel buttonPanel = new JPanel();
        JButton runButton = new JButton("Run Linear Search");
        runButton.addActionListener(e -> performLinearSearch());
        buttonPanel.add(runButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    /**
     * Parses input and runs Linear Search with timing and complexity reporting.
     */
    private void performLinearSearch() {
        try {
            // Parse input array
            String[] parts = inputArrayField.getText().split(",");
            int[] array = new int[parts.length];

            for (int i = 0; i < parts.length; i++) {
                array[i] = Integer.parseInt(parts[i].trim());
            }

            // Parse target
            int target = Integer.parseInt(targetField.getText().trim());

            // Run the algorithm and time it
            long startTime = System.nanoTime();
            int index = LinearSearch.search(array, target);
            long endTime = System.nanoTime();

            // Build result output
            StringBuilder output = new StringBuilder();
            output.append("Linear Search Result:\n");
            output.append("Target: ").append(target).append("\n");
            output.append("Array: ").append(java.util.Arrays.toString(array)).append("\n");

            if (index != -1) {
                output.append("Status: Found at index ").append(index).append("\n");
            } else {
                output.append("Status: Not Found\n");
            }

            output.append("\nTime Taken: ").append((endTime - startTime)).append(" ns\n");
            output.append("Complexity: ").append(ComplexityUtil.linearSearch()).append("\n");
            output.append("\nPseudocode:\n");
            output.append(ComplexityUtil.linearSearchPseudocode());

            resultArea.setText(output.toString());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter numbers only.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
