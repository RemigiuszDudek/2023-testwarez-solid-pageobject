package org.example.java21;

import org.example.java21.recordpatterns.Circle;
import org.example.java21.recordpatterns.Rectangle;
import org.example.java21.recordpatterns.Shape;
import org.example.java21.recordpatterns.Square;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Java21PlaygroundTest {
    private static final List<Shape> SHAPES = List.of(
            new Circle(1),
            new Rectangle(1, 2),
            new Square(1)
    );

    @Test
    public void recordPatterns() {
        for (Shape shape : SHAPES) {
            processShape(shape);
        }
    }

    private static void processShape(Shape shape) {
        if (shape instanceof Square(int side)) {
            System.out.printf("this is square with side=%d%n", side);
        } else if (shape instanceof Circle(int radius)) {
            System.out.printf("this is circle with radius=%d%n", radius);
        } else if (shape instanceof Rectangle(int widht, int height)) {
            System.out.printf("this is rectangle with width=%s, height=%d%n", widht, height);
        }
    }

    @Test
    public void recordPatternsWithSwitch() {
        for (Shape shape : SHAPES) {
            switch (shape) {
                case Square(int a) -> System.out.printf("this is square with a=%d%n", a);
                case Circle(int r) -> System.out.printf("this is circle with r=%d%n", r);
                case Rectangle(int w, int h) -> System.out.printf("this is rectangle with w=%s, h=%d%n", w, h);
                default -> throw new RuntimeException("unknown shape");
            }
        }
    }

}
