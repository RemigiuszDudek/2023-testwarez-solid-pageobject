package org.example.framework.muitable.table;

import java.util.List;

public interface Table<CONTENT> {
    List<CONTENT> content();

    List<String> headers();
}
