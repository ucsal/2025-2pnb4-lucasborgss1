package br.com.mariojp.figureeditor.factory;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircleFactory implements ShapeFactory{
    @Override
    public Shape createShape(Point point, int size) {
        return new Ellipse2D.Double(point.x, point.y, size, size);
    }
}
