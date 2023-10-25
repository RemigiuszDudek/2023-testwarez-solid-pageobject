package org.example.solid.liskov.report;

public class DeviceReportPage extends ReportPage<DeviceReportPage, DeviceReportContent> {

    DeviceReportPage setDevice(Device device) {
        this.setBuilding(device.buildingName());

        return this;
    }

    @Override
    DeviceReportContent getReportContent() {
        return null;
    }

    @Override
    DeviceReportPage getChild() {
        return null;
    }
}
