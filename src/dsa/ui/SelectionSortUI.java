package dsa.ui;

import dsa.algorithms.SelectionSort;
import dsa.utils.ComplexityUtil;


import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * GUI for Selection Sort algorithm.
 */
public class SelectionSortUI extends JFrame {

    private JTextField inputArrayField;
    private JTextArea resultArea;

    public SelectionSortUI() {
        setTitle("Selection Sort");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Input
        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input"));

        inputPanel.add(new JLabel("Array (comma-separated):"), BorderLayout.NORTH);
        inputArrayField = new JTextField("29, 10, 14, 37, 13");
        inputPanel.add(inputArrayField, BorderLayout.CENTER);

        panel.add(inputPanel, BorderLayout.NORTH);

        // Result area
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Result Output"));
        panel.add(scrollPane, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();

        JButton runButton = new JButton("Run Selection Sort");
        runButton.addActionListener(e -> performSelectionSort());
        buttonPanel.add(runButton);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> {
            dispose();
            new MenuFrame();
        });
        buttonPanel.add(backButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        add(panel);
    }

    private void performSelectionSort() {
        try {
            String input = inputArrayField.getText().trim();

            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Input field cannot be empty.", "Input Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String[] parts = input.split(",");
            int[] array = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                array[i] = Integer.parseInt(parts[i].trim());
            }

            long startTime = System.nanoTime();
            int[] sortedArray = SelectionSort.sort(array.clone());
            long endTime = System.nanoTime();

            StringBuilder output = new StringBuilder();
            output.append("Selection Sort Result:\n");
            output.append("Original Array: ").append(Arrays.toString(array)).append("\n");
            output.append("Sorted Array:   ").append(Arrays.toString(sortedArray)).append("\n");
            output.append("\nTime Taken: ").append(endTime - startTime).append(" ns\n");
            output.append("Complexity: ").append(ComplexityUtil.selectionSort()).append("\n");
            output.append("\nPseudocode:\n").append(ComplexityUtil.selectionSortPseudocode());

            resultArea.setText(output.toString());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter only comma-separated integers.", "Format Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unexpected error: " + e.getMessage(), "System Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
