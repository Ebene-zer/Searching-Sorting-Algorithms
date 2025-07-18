package dsa.ui;

import dsa.algorithms.BubbleSort;
import dsa.utils.ComplexityUtil;


import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * GUI for Bubble Sort algorithm.
 */
public class BubbleSortUI extends JFrame {

    private JTextField inputArrayField;
    private JTextArea resultArea;

    public BubbleSortUI() {
        setTitle("Bubble Sort");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();
        setVisible(true);
    }

    /**
     * Set up all components on the frame.
     */
    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Input Section
        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input"));

        inputPanel.add(new JLabel("Array (comma-separated):"), BorderLayout.NORTH);
        inputArrayField = new JTextField("64, 34, 25, 12, 22, 11, 90");
        inputPanel.add(inputArrayField, BorderLayout.CENTER);

        panel.add(inputPanel, BorderLayout.NORTH);

        // Output Area
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Result Output"));
        panel.add(scrollPane, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();

        JButton runButton = new JButton("Run Bubble Sort");
        runButton.addActionListener(e -> performBubbleSort());
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

    /**
     * Reads the input, performs the sort, and displays the result.
     */
    private void performBubbleSort() {
        try {
            String input = inputArrayField.getText().trim();

            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Input field cannot be empty.", "Input Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String[] parts = input.split(",");
            int[] array = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                array[i] = Integer.parseInt(parts[i].trim()); // May throw NumberFormatException
            }

            long startTime = System.nanoTime();
            int[] sortedArray = BubbleSort.sort(array.clone());
            long endTime = System.nanoTime();

            StringBuilder output = new StringBuilder();
            output.append("Bubble Sort Result:\n");
            output.append("Original Array: ").append(Arrays.toString(array)).append("\n");
            output.append("Sorted Array:   ").append(Arrays.toString(sortedArray)).append("\n");
            output.append("\nTime Taken: ").append(endTime - startTime).append(" ns\n");
            output.append("Complexity: ").append(ComplexityUtil.bubbleSort()).append("\n");
            output.append("\nPseudocode:\n").append(ComplexityUtil.bubbleSortPseudocode());

            resultArea.setText(output.toString());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter only comma-separated integers.", "Format Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unexpected error: " + e.getMessage(), "System Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
