package org.example.framework.muitable.table;

import java.util.List;

public interface SelectableTable<CONTENT> extends Table<CONTENT> {
    SelectableTable<CONTENT> selectAll();

    boolean isAllSelected();

    SelectableTable<CONTENT> select(int rowIdx);

    SelectableTable<CONTENT> deselect(int rowIdx);

    List<CONTENT> selectedContent();
}
