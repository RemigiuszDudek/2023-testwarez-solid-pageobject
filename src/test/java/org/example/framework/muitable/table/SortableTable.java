package org.example.framework.muitable.table;

public interface SortableTable<HEADER, CONTENT> extends Table<CONTENT> {
    SortableTable<HEADER, CONTENT> sortBy(HEADER headerName, SortDirection direction);
}
