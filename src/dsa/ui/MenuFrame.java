package dsa.ui;

import dsa.runner.AlgorithmRunner;

import javax.swing.*;
import java.awt.*;

/**
 * Main GUI window that allows users to select an algorithm and execute it.
 */
public class MenuFrame extends JFrame {

    private JComboBox<String> algorithmComboBox;
    private JButton proceedButton;

    public MenuFrame() {
        setTitle("Searching & Sorting Visualizer");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();
        setVisible(true);
    }

    /**
     * Initializes and places all components on the frame.
     */
    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel heading = new JLabel("Select an Algorithm", JLabel.CENTER);
        heading.setFont(new Font("SansSerif", Font.BOLD, 16));
        panel.add(heading, BorderLayout.NORTH);

        // Dropdown with algorithm choices
        String[] algorithms = {
                "Linear Search",
                "Binary Search",
                "Bubble Sort",
                "Selection Sort",
                "Insertion Sort",
                "Merge Sort",
                "Quick Sort",
                "Heap Sort"
        };

        algorithmComboBox = new JComboBox<>(algorithms);
        algorithmComboBox.setFont(new Font("SansSerif", Font.PLAIN, 14));
        panel.add(algorithmComboBox, BorderLayout.CENTER);

        // Button to proceed
        proceedButton = new JButton("Let's Go!");
        proceedButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        proceedButton.addActionListener(e -> handleSelection());
        panel.add(proceedButton, BorderLayout.SOUTH);

        add(panel);
    }

    /**
     * Handles user algorithm selection and opens the corresponding interface.
     */
    private void handleSelection() {
        String selected = (String) algorithmComboBox.getSelectedItem();
        if (selected == null || selected.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select an algorithm.");
            return;
        }

        // Close the menu window
        this.dispose();

        // Delegate to the runner class
        AlgorithmRunner.run(selected);
    }
}
