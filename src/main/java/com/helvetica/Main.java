package com.helvetica;

import com.helvetica.Controller.ConsoleReader;
import com.helvetica.Controller.DeviceController;
import com.helvetica.Model.DeviceSet;

import com.helvetica.View.Viewer;

public class Main {

    public static void main(String[] args) {
        Viewer viewer = new Viewer();
        ConsoleReader consoleReader = new ConsoleReader();
        DeviceController deviceController = new DeviceController(viewer,DeviceSet.SMALL_FLAT, consoleReader);
        deviceController.startScenario();

    }
}
