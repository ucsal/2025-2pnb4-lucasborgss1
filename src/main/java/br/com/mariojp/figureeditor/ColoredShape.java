package br.com.mariojp.figureeditor;

import java.awt.Color;
import java.awt.Shape;

public class ColoredShape {
    private final Shape shape;
    private final Color color;

    public ColoredShape(Shape shape, Color color) {
        this.shape = shape;
        this.color = color;
    }

    public Shape getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }
}