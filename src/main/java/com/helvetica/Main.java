package com.helvetica;

import com.helvetica.Controller.ConsoleReader;
import com.helvetica.Controller.DeviceController;
import com.helvetica.Model.Device;
import com.helvetica.Model.DeviceSet;
import com.helvetica.Model.MobileDevice;
import com.helvetica.Model.Point;
import com.helvetica.View.Viewer;

public class Main {

    public static void main(String[] args) {
//        DeviceSet deviceSet = new DeviceSet(new MobileDevice(true, new Point(1.11, 2.22), MobileDevice.mobileDevices.LAPTOP));
        Viewer viewer = new Viewer();
        ConsoleReader consoleReader = new ConsoleReader();
        DeviceController deviceController = new DeviceController(viewer,DeviceSet.SMALL_FLAT, consoleReader);
        deviceController.startScenario();

    }
}
