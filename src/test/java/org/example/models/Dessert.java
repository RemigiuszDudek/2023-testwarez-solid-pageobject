package org.example.models;

public class Dessert {
    public String name;
    public int calories;
    public float fat;
    public float carbs;
    public float protein;

    public Dessert(String name, int calories, float fat, float carbs, float protein) {
        this.name = name;
        this.calories = calories;
        this.fat = fat;
        this.carbs = carbs;
        this.protein = protein;
    }

    @Override
    public String toString() {
        return "Dessert{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", fat=" + fat +
                ", carbs=" + carbs +
                ", protein=" + protein +
                '}';
    }
}
