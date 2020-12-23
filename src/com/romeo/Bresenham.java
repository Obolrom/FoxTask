package com.romeo;

import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Bresenham {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Bresenham::run);
    }

    private static void run() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.getContentPane().add(new BresenhamPanel());
        f.pack();
        f.setVisible(true);
    }
}

class BresenhamPanel extends JPanel {

    private final int pixelSize = 10;

    BresenhamPanel() {
        setPreferredSize(new Dimension(980, 560));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

//        int w = (getWidth() - 1) / pixelSize;
//        int h = (getHeight() - 1) / pixelSize;
//        int maxX = (w - 1) / 2;
//        int maxY = (h - 1) / 2;
//        int x1 = -maxX, x2 = maxX * -2 / 3, x3 = maxX * 2 / 3, x4 = maxX;
//        int y1 = -maxY, y2 = maxY * -2 / 3, y3 = maxY * 2 / 3, y4 = maxY;

//        Line2D line = new Line2D.Double(0, 0, 200, 300);
//        ((Graphics2D) g).draw(line);

        drawLine(g, -3, -10, 4, 15, Color.blue); // NNE

    }

    private void plot(Graphics g, int x, int y, Color color) {
        int w = (getWidth() - 1) / pixelSize;
        int h = (getHeight() - 1) / pixelSize;
        int maxX = (w - 1) / 2;
        int maxY = (h - 1) / 2;

        int borderX = getWidth() - ((2 * maxX + 1) * pixelSize + 1);
        int borderY = getHeight() - ((2 * maxY + 1) * pixelSize + 1);
        int left = (x + maxX) * pixelSize + borderX / 2;
        int top = (y + maxY) * pixelSize + borderY / 2;

        g.setColor(color);
        g.drawOval(left, top, pixelSize, pixelSize);
    }

    private void drawLine(Graphics g, int x1, int y1, int x2, int y2, Color color) {
        // delta of exact value and rounded value of the dependent variable
        int d = 0;

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int dx2 = 2 * dx; // slope scaling factors to
        int dy2 = 2 * dy; // avoid floating point

        int ix = x1 < x2 ? 1 : -1; // increment direction
        int iy = y1 < y2 ? 1 : -1;

        int x = x1;
        int y = y1;

        if (dx >= dy) {
            while (true) {
                plot(g, x, y, color);
                if (x == x2)
                    break;
                x += ix;
                d += dy2;
                if (d > dx) {
                    y += iy;
                    d -= dx2;
                }
            }
        } else {
            while (true) {
                plot(g, x, y, color);
                if (y == y2)
                    break;
                y += iy;
                d += dx2;
                if (d > dy) {
                    x += ix;
                    d -= dy2;
                }
            }
        }
    }
}