package org.dudekre.testwarez2023.java21.recordpatterns;

public record Circle(int radius) implements Shape {
    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}
