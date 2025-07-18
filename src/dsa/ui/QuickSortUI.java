package dsa.ui;

import dsa.algorithms.QuickSort;
import dsa.utils.ComplexityUtil;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * GUI for Quick Sort algorithm.
 */
public class QuickSortUI extends JFrame {

    private JTextField inputArrayField;
    private JTextArea resultArea;

    public QuickSortUI() {
        setTitle("Quick Sort");
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
        inputArrayField = new JTextField("10, 7, 8, 9, 1, 5");
        inputPanel.add(inputArrayField, BorderLayout.CENTER);

        panel.add(inputPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Result Output"));
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton runButton = new JButton("Run Quick Sort");
        runButton.addActionListener(e -> performQuickSort());
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

    private void performQuickSort() {
        try {
            String[] parts = inputArrayField.getText().split(",");
            int[] array = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                array[i] = Integer.parseInt(parts[i].trim());
            }

            long startTime = System.nanoTime();
            QuickSort.sort(array, 0, array.length - 1);
            long endTime = System.nanoTime();

            StringBuilder output = new StringBuilder();
            output.append("Quick Sort Result:\n");
            output.append("Sorted Array: ").append(Arrays.toString(array)).append("\n");
            output.append("\nTime Taken: ").append(endTime - startTime).append(" ns\n");
            output.append("Complexity: ").append(ComplexityUtil.quickSort()).append("\n");
            output.append("\nPseudocode:\n").append(ComplexityUtil.quickSortPseudocode());

            resultArea.setText(output.toString());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter only comma-separated integers.", "Format Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unexpected error: " + e.getMessage(), "System Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
