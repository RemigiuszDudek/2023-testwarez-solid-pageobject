package org.dudekre.testwarez2023.java21.recordpatterns;

public record Square(int side) implements Shape {
    @Override
    public double area() {
        return Math.pow(side, 2);
    }
}
