package org.example.solid.liskov.report;

public class IaqReportPage extends ReportPage<IaqReportPage, IaqReportContent> {
    @Override
    IaqReportContent getReportContent() {
        return new IaqReportContent();
    }

    @Override
    IaqReportPage getChild() {
        return new IaqReportPage();
    }
}
