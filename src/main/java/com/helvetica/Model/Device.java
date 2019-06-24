package com.helvetica.Model;

public abstract class Device {

    private boolean state;
    private Point coordinate;

    /**
     * Default constructor for Device
     */
    Device(){
        this.state = false;
        this.coordinate = new Point(-1, -1);
    }

    /**
     * Setter for
     * @param coordinate (Point) - place where the device is located
     */
    void setCoordinate(Point coordinate){
        this.coordinate = coordinate;
    }

    /**
     * Setter for
     * @param state (boolean) - current state of the device (is it plugged)
     */
    void setState(boolean state){
        this.state = state;
    }

    /**
     * Method to get text status for device
     * @return (String) - "on" if plugged, "off" if not working
     */
    String getTextStatus(){
        return getState() ? "on" : "off";
    }

    /**
     * Getter for coordinate
     * @return (String) - place where located
     */
    String getPlace(){
        return this.coordinate.toString();
    }

    /**
     * Getter fot state
     * @return (boolean) - current state of the device
     */
    boolean getState() {
        return state;
    }

    /**
     * Changes state of the device
     */
    public void changeState(){
        this.state = !this.state;
    }

    /**
     * Abstract method to override
     * @param coordinateToSet (Point) - parameter to change
     */
    public abstract void move(Point coordinateToSet);

    /**
     * Abstract method to get power
     * @return (int) - power consuming quantity
     */
    public abstract int getPower();

}
