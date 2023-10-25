package org.example.solid.liskov.bird;

public class Penguin implements Bird {
    @Override
    public void fly() {
        throw new RuntimeException("This bird cannot fly");
    }
}


