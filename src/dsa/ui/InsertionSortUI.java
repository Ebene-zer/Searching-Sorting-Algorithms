package dsa.ui;

import dsa.algorithms.InsertionSort;
import dsa.utils.ComplexityUtil;


import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * GUI for Insertion Sort algorithm.
 */
public class InsertionSortUI extends JFrame {

    private JTextField inputArrayField;
    private JTextArea resultArea;

    public InsertionSortUI() {
        setTitle("Insertion Sort");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input"));

        inputPanel.add(new JLabel("Array (comma-separated):"), BorderLayout.NORTH);
        inputArrayField = new JTextField("12, 11, 13, 5, 6");
        inputPanel.add(inputArrayField, BorderLayout.CENTER);

        panel.add(inputPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Result Output"));
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton runButton = new JButton("Run Insertion Sort");
        runButton.addActionListener(e -> performInsertionSort());
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

    private void performInsertionSort() {
        try {
            String[] parts = inputArrayField.getText().split(",");
            int[] array = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                array[i] = Integer.parseInt(parts[i].trim());
            }

            long startTime = System.nanoTime();
            int[] sortedArray = InsertionSort.sort(array.clone());
            long endTime = System.nanoTime();

            StringBuilder output = new StringBuilder();
            output.append("Insertion Sort Result:\n");
            output.append("Original Array: ").append(Arrays.toString(array)).append("\n");
            output.append("Sorted Array:   ").append(Arrays.toString(sortedArray)).append("\n");
            output.append("\nTime Taken: ").append(endTime - startTime).append(" ns\n");
            output.append("Complexity: ").append(ComplexityUtil.insertionSort()).append("\n");
            output.append("\nPseudocode:\n").append(ComplexityUtil.insertionSortPseudocode());

            resultArea.setText(output.toString());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter only comma-separated integers.", "Format Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unexpected error: " + e.getMessage(), "System Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
