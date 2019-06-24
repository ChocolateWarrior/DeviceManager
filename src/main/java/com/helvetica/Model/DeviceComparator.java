package com.helvetica.Model;

import java.util.Comparator;

public class DeviceComparator implements Comparator<Device> {

    /**
     * Overridden Comparator method
     * @param comparableDevice (Device)
     * @param deviceToCompare (Device)
     * @return (int) to compare by
     */
    @Override
    public int compare(Device comparableDevice, Device deviceToCompare) {
        return comparableDevice.getPower() - deviceToCompare.getPower();
    }
}
