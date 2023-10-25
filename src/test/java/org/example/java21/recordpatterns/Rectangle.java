package org.example.java21.recordpatterns;

public record Rectangle(int width, int height) implements Shape {
    @Override
    public double area() {
        return width * height;
    }
}
