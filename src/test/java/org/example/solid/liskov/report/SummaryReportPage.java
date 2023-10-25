package org.example.solid.liskov.report;

// Meta-report, how many reports of given type do we have,
public class SummaryReportPage extends ReportPage<SummaryReportPage, SummaryReportContent> {
    @Override
    SummaryReportPage setBuilding(String buildName) {
        throw new RuntimeException("setting building for SummaryReport does not make sense");
    }

    @Override
    SummaryReportContent getReportContent() {
        return null;
    }

    @Override
    SummaryReportPage getChild() {
        return null;
    }
}
