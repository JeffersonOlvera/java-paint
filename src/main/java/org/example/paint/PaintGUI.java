package org.example.paint;

import javax.swing.*;
import java.awt.*;

public class PaintGUI extends JFrame {

    public PaintGUI() {
        super("Paint");
        setPreferredSize(new Dimension(1000, 600));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addGuiComponents();
    }

    public void addGuiComponents() {
        JPanel canvasPanel = new JPanel();
        SpringLayout springLayout = new SpringLayout();
        canvasPanel.setLayout(springLayout);

        Canvas canvas = new Canvas(975, 500);
        canvasPanel.add(canvas);
        canvas.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        canvasPanel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        springLayout.putConstraint(SpringLayout.NORTH, canvas, 50 , SpringLayout.NORTH, canvasPanel);
        springLayout.putConstraint(SpringLayout.WEST, canvas, 5 , SpringLayout.WEST, canvasPanel);

        JLabel colorTag = new JLabel("Color: ");
        canvasPanel.add(colorTag);
        springLayout.putConstraint(SpringLayout.NORTH, colorTag, 17 , SpringLayout.NORTH, canvasPanel);
        springLayout.putConstraint(SpringLayout.WEST, colorTag, 5 , SpringLayout.WEST, canvasPanel);

        JButton chooseAColorBtn = new JButton("");
        chooseAColorBtn.setPreferredSize(new Dimension(35, 35));
        chooseAColorBtn.setBackground(Color.BLACK);
        chooseAColorBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        chooseAColorBtn.addActionListener(e -> {
            Color c = JColorChooser.showDialog(null, "Select a color", Color.BLACK);
            chooseAColorBtn.setBackground(c);
            canvas.setColor(c);
        });

        canvasPanel.add(chooseAColorBtn);
        springLayout.putConstraint(SpringLayout.NORTH, chooseAColorBtn, 8 , SpringLayout.NORTH, canvasPanel);
        springLayout.putConstraint(SpringLayout.WEST, chooseAColorBtn, 45 , SpringLayout.WEST, canvasPanel);

        JButton resetBtn = new JButton("Reset");
        resetBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        resetBtn.setPreferredSize(new Dimension(70,35));
        resetBtn.addActionListener(e ->{
            canvas.resetCanvas();
        });

        canvasPanel.add(resetBtn);
        springLayout.putConstraint(SpringLayout.NORTH, resetBtn, 8 , SpringLayout.NORTH, canvasPanel);
        springLayout.putConstraint(SpringLayout.WEST, resetBtn, 90 , SpringLayout.WEST, canvasPanel);



        this.getContentPane().add(canvasPanel);

    }
}
