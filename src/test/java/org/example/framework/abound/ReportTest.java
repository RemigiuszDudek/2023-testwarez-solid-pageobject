package org.example.framework.abound;

import java.time.LocalDate;

public class ReportTest {
    void reportTest() {
        ReportTemplatePage reportTemplatePage = new ReportTemplatePage();

        reportTemplatePage.selectTimeFrame(PredefinedTimeframe.LAST_MONTH);
        reportTemplatePage.selectTimeFrame(new CustomTimeFrame(new TimeRange(LocalDate.now(), LocalDate.now())));
    }
}
