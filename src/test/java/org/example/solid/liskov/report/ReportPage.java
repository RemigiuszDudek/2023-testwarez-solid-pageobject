package org.example.solid.liskov.report;

public abstract class ReportPage<CHILD extends ReportPage<CHILD, CONTENT>, CONTENT> {
    CHILD setBuilding(String buildName) {
        return getChild();
    }

    abstract CONTENT getReportContent();

    abstract CHILD getChild();
}
