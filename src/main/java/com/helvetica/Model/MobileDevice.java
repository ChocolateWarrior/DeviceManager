package com.helvetica.Model;

public class MobileDevice extends Device{


    @Override
    public void move(Point coordinateToSet) {
        setCoordinate(coordinateToSet);
    }

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

    private mobileDevices currentDevice;

    public MobileDevice(boolean state, Point coordinate, mobileDevices device){
        setState(state);
        setCoordinate(coordinate);
        this.currentDevice = device;
    }

    public enum mobileDevices{
        LAPTOP("laptop", 150),
        HAIR_DRYER("hair dryer", 800),
        VACUUM_CLEANER("vacuum cleaner", 1000),
        IRON("iron", 1000),
        MIXER("mixer", 200);

        private String title;
        private int power;

        mobileDevices(String title, int power){
            this.title = title;
            this.power = power;
        }

        public void setTitle(String title) { this.title = title; }
        public void setPower(int power) { this.power = power; }

        public String getTitle() { return title; }
        public int getPower() { return power; }
    }




}
