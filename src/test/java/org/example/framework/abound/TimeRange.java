package org.example.framework.abound;

import java.time.LocalDate;

public record TimeRange(
        LocalDate from,
        LocalDate to
) {
    public static TimeRange createTimeRange(PredefinedTimeframe timeFrame) {
        return null;
    }
}
