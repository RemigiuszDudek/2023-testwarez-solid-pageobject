package org.example.framework.mui.table;

import java.util.List;

public interface Table<CONTENT> {
    List<String> getHeaders();

    List<CONTENT> getContent();
}
