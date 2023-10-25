package org.example.solid.inheritance.table;

public class SortedTable extends Table {
    public SortedTable sort(String columnName) {
        return new SortedTable();
    }
}


