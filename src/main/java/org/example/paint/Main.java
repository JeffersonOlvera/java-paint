package org.example.paint;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new PaintGUI().setVisible(true));
    }
}