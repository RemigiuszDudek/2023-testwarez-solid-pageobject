package org.example.solid.inheritance.table;

public class SelectableTable extends Table {
    public SelectableTable select(String desertName) {
        return new SelectableTable();
    }
}
