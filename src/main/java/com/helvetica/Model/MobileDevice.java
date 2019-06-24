package com.helvetica.Model;

public class MobileDevice extends Device{


    /**
     * Overridden
     * @param coordinateToSet (Point) - parameter to change
     */
    @Override
    public void move(Point coordinateToSet) {
        setCoordinate(coordinateToSet);
    }

    /**
     * Overridden method toString
     * @return (String)
     */
    @Override
    public String toString(){
        return "Device: " + currentDevice.getTitle() + "\n" +
                "Power: " + currentDevice.getPower() + " Wt\n" +
                "Status: " + getTextStatus() + "\n" +
                "Place: " + getPlace() + "\n";
    }

    /**
     * Overridden method to get power
     * @return (int) - power
     */

    @Override
    public int getPower(){
        return currentDevice.getPower();
    }

    private mobileDevices currentDevice;

    /**
     * Constructor for MobileDevice
     * @param state (boolean)
     * @param coordinate (Point)
     * @param device (mobileDevices)
     */
    MobileDevice(boolean state, Point coordinate, mobileDevices device){
        setState(state);
        setCoordinate(coordinate);
        this.currentDevice = device;
    }

    /**
     * enum with possible mobile devices
     */
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

        public String getTitle() { return title; }
        public int getPower() { return power; }
    }




}
