package com.helvetica.Model;

import java.util.Comparator;

public class DeviceComparator implements Comparator<Device> {

    @Override
    public int compare(Device comparableDevice, Device deviceToCompare) {
        return (int) (comparableDevice.getPower() - deviceToCompare.getPower());
    }
}
