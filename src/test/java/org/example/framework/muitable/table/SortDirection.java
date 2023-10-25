package org.example.framework.muitable.table;

import java.util.Arrays;

public enum SortDirection {
    ASC("ascending"), DESC("descending"), NONE(null);

    private final String text;

    SortDirection(String text) {
        this.text = text;
    }

    public static SortDirection from(String text) {
        return text == null ? NONE : Arrays.stream(SortDirection.values())
                .filter(it -> it.text.equals(text))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("cannot create sort direction, text=%s".formatted(text)));
    }
}
