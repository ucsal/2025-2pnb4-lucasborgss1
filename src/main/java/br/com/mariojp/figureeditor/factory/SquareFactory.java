package br.com.mariojp.figureeditor.factory;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class SquareFactory implements ShapeFactory{
    @Override
    public Shape createShape(Point point, int size) {
        return new Rectangle2D.Double(point.x, point.y, size, size);
    }
}
