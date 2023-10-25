package org.example.solid.inheritance.table;

import java.util.ArrayList;
import java.util.List;

public class Table {
    public List<String> getHeaders() {
        return new ArrayList<>();
    }

    public List<Desert> getContent() {
        return new ArrayList<>();
    }
}


