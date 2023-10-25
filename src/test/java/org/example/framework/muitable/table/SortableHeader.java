package org.example.framework.muitable.table;

public interface SortableHeader extends TableCell<String> {
    void sort(SortDirection direction);
}
