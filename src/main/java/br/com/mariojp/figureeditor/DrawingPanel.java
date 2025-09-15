package br.com.mariojp.figureeditor;

import br.com.mariojp.figureeditor.factory.ShapeFactory;
import br.com.mariojp.figureeditor.factory.CircleFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

class DrawingPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_SIZE = 60;
    private final List<ColoredShape> shapes = new ArrayList<>();
    private ShapeFactory factory;
    private Point startDrag = null;
    private Color currentColor = new Color(30,144,255); //Cor padrão

    DrawingPanel() {
        setBackground(Color.WHITE);
        setOpaque(true);
        setDoubleBuffered(true);

        this.factory = new CircleFactory();

        var mouse = new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && startDrag == null) {
                    int size = Math.max(DEFAULT_SIZE, 10);
                    Shape s = factory.createShape(e.getPoint(), size);
                    shapes.add(new ColoredShape(s, currentColor));
                    repaint();
                }
            }
        };
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
    }

    public void setFactory(ShapeFactory factory) {
        this.factory = factory;
    }

    void clear() {
        shapes.clear();
        repaint();
    }

    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }

    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (ColoredShape cs : shapes) {
            g2.setColor(cs.getColor());
            g2.fill(cs.getShape());
            g2.setColor(new Color(0,0,0,70));
            g2.setStroke(new BasicStroke(1.2f));
            g2.draw(cs.getShape());
        }

        g2.dispose();
    }

}
