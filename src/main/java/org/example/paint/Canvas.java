package org.example.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {

    private final static int STROKE_SIZE = 5;

    private List<ColorPoint> currentPath;

    private Color color;
    private  int x, y;

    public Canvas(int targetWidth, int targetHeight){
        super();
        setPreferredSize(new Dimension(targetWidth,targetHeight));
        setOpaque(true);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        MouseAdapter mouseAdapter = new MouseAdapter() {

            @Override
            public void mousePressed (MouseEvent e) {
                x = e.getX();
                y = e.getY();

                Graphics g = getGraphics();
                g.setColor(color);
                g.fillRect(x,y,STROKE_SIZE, STROKE_SIZE);
                g.dispose();

                currentPath = new ArrayList<>(25);
                currentPath.add(new ColorPoint(color, x, y));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                currentPath = null;
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                x = e.getX();
                y = e.getY();

                Graphics2D g2d = (Graphics2D) getGraphics();
                g2d.setColor(color);
                if (!currentPath.isEmpty()){
                    ColorPoint prevPoint = currentPath.get(currentPath.size() -1);
                    g2d.setStroke(new BasicStroke(STROKE_SIZE));

                    g2d.drawLine(prevPoint.getX(), prevPoint.getY(), x, y);
                }
                g2d.dispose();

                ColorPoint nextPoint = new ColorPoint(color, e.getX(),e.getY());
                currentPath.add(nextPoint);

            }
        };

        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
