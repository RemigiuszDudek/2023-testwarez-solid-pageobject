package org.example.java21.recordpatterns;

public record Square(int side) implements Shape {
    @Override
    public double area() {
        return Math.pow(side, 2);
    }
}
