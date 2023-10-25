package org.example.framework.muitable.table;

public interface SelectableRow<CONTENT> extends Row<CONTENT> {
    void select();

    void deselect();

    boolean isSelected();
}
