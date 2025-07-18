package dsa;

import dsa.ui.MenuFrame;

/**
 * Entry point of the application.
 * It launches the main GUI window using Swing's thread-safe approach.
 */
public class Main {
    public static void main(String[] args) {
        // Launch GUI on the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(MenuFrame::new);
    }
}
