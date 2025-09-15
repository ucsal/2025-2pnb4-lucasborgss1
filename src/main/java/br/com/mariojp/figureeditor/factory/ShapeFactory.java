package br.com.mariojp.figureeditor.factory;

import java.awt.*;

public interface ShapeFactory {
    Shape createShape(Point point, int size);
}
