package org.dudekre.testwarez2023.java21;

import org.dudekre.testwarez2023.java21.recordpatterns.Circle;
import org.dudekre.testwarez2023.java21.recordpatterns.Rectangle;
import org.dudekre.testwarez2023.java21.recordpatterns.Shape;
import org.dudekre.testwarez2023.java21.recordpatterns.Square;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.SequencedCollection;

import static org.assertj.core.api.Assertions.assertThat;

public class Java21PlaygroundTest {
    private static final Circle CIRCLE = new Circle(1);
    private static final Rectangle RECTANGLE = new Rectangle(1, 2);
    private static final Square SQUARE = new Square(1);

    private static final SequencedCollection<Shape> SHAPES = List.of(CIRCLE, RECTANGLE, SQUARE);

    @Test
    public void sequencedCollections() {
        assertThat(SHAPES.getFirst()).isEqualTo(CIRCLE);
        assertThat(SHAPES.getLast()).isEqualTo(SQUARE);
        assertThat(SHAPES.reversed()).isEqualTo(List.of(SQUARE, RECTANGLE, CIRCLE));
    }

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
