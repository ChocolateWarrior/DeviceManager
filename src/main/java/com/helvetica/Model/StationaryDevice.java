package com.helvetica.Model;

public class StationaryDevice extends Device{

    @Override
    public void move(Point coordinateToSet) {}

    @Override
    public String toString(){
        return "Device: " + currentDevice.getTitle() + "\n" +
                "Power: " + currentDevice.getPower() + " Wt\n" +
                "Status: " + getTextStatus() + "\n" +
                "Place: " + getPlace() + "\n";
    }

    @Override
    public int getPower(){
        return currentDevice.getPower();
    }

    private stationaryDevices currentDevice;

    public StationaryDevice(boolean state, Point coordinate, stationaryDevices device){
        setState(state);
        setCoordinate(coordinate);
        this.currentDevice = device;
    }

    public enum stationaryDevices{
        STATIONARY_COMPUTER("stationary computer", 700),
        TV("TV", 180),
        REFRIGERATOR("refrigerator", 200),
        MICROWAVE("microwave", 1500),
        OVEN("oven", 4000),
        LAMP("lamp", 100),
        BOILER("boiler", 6000),
        DISHWASHER("dishwasher", 3500);

        private String title;
        private int power;

        stationaryDevices(String title, int power){
            this.title = title;
            this.power = power;
        }

        private void setTitle(String title) { this.title = title; }
        private void setPower(int power) { this.power = power; }

        private String getTitle() { return title; }
        private int getPower() { return power; }
    }


}
