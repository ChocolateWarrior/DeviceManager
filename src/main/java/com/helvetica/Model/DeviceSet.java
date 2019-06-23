package com.helvetica.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum  DeviceSet {

    SMALL_FLAT(new MobileDevice(false, new Point(1.2, (double)2), MobileDevice.mobileDevices.HAIR_DRYER),
            new MobileDevice(true, new Point(1.2, (double)2), MobileDevice.mobileDevices.LAPTOP),
            new StationaryDevice(false, new Point(1.2, (double)2), StationaryDevice.stationaryDevices.LAMP),
            new StationaryDevice(true, new Point(1.2, (double)2), StationaryDevice.stationaryDevices.MICROWAVE)),
    AVERAGE_FLAT(new MobileDevice(false, new Point(1.2, (double)2), MobileDevice.mobileDevices.HAIR_DRYER),
            new MobileDevice(true, new Point(1.2, (double)2), MobileDevice.mobileDevices.LAPTOP),
            new MobileDevice(true, new Point(1.2, (double)2), MobileDevice.mobileDevices.IRON),
            new StationaryDevice(true, new Point(1.2, (double)2), StationaryDevice.stationaryDevices.LAMP),
            new StationaryDevice(true, new Point(1.2, (double)2), StationaryDevice.stationaryDevices.REFRIGERATOR),
            new StationaryDevice(true, new Point(1.2, (double)2), StationaryDevice.stationaryDevices.TV),
            new StationaryDevice(true, new Point(1.2, (double)2), StationaryDevice.stationaryDevices.MICROWAVE)),
    BIG_HOUSE(new MobileDevice(false, new Point(1.2, (double)2), MobileDevice.mobileDevices.HAIR_DRYER),
            new MobileDevice(true, new Point(1.2, (double)2), MobileDevice.mobileDevices.LAPTOP),
            new MobileDevice(false, new Point(1.2, (double)2), MobileDevice.mobileDevices.IRON),
            new MobileDevice(true, new Point(1.2, (double)2), MobileDevice.mobileDevices.VACUUM_CLEANER),
            new MobileDevice(true, new Point(1.2, (double)2), MobileDevice.mobileDevices.MIXER),
            new StationaryDevice(true, new Point(1.2, (double)2), StationaryDevice.stationaryDevices.LAMP),
            new StationaryDevice(false, new Point(1.2, (double)2), StationaryDevice.stationaryDevices.REFRIGERATOR),
            new StationaryDevice(true, new Point(1.2, (double)2), StationaryDevice.stationaryDevices.TV),
            new StationaryDevice(false, new Point(1.2, (double)2), StationaryDevice.stationaryDevices.DISHWASHER),
            new StationaryDevice(true, new Point(1.2, (double)2), StationaryDevice.stationaryDevices.BOILER),
            new StationaryDevice(true, new Point(1.2, (double)2), StationaryDevice.stationaryDevices.STATIONARY_COMPUTER),
            new StationaryDevice(true, new Point(1.2, (double)2), StationaryDevice.stationaryDevices.MICROWAVE));

    private List<Device> listOfDevices = new ArrayList<>();

    private DeviceSet(Device... devices){
        this.listOfDevices.addAll(Arrays.asList(devices));
    }

    private void addDevice(Device deviceToAdd){
        listOfDevices.add(deviceToAdd);
    }

    public List<Device> getListOfDevices() {
        return listOfDevices;
    }
//    public void setListOfDevices(DeviceSet) {
//        this.listOfDevices = ;
//    }

    public void sortByPower(){
        listOfDevices.sort(new DeviceComparator());
    }

    public int calculatePower(){
        int calculatedPower = 0;
        for(Device device : listOfDevices){
            if(device.getState()) calculatedPower += device.getPower();
        }
        return calculatedPower;
    }

    public ArrayList<Device> findDevicesByRange(double bottomLimit, double topLimit){

        ArrayList<Device> appropriateDevices = new ArrayList<>();
        for(Device device : listOfDevices){
            if(device.getPower() >= bottomLimit && device.getPower() <= topLimit){
                appropriateDevices.add(device);
            }
        }
        return appropriateDevices;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        for (Device device: listOfDevices) {
            res.append(device.toString());
        }
        return res.toString();
    }


}
