package com.helvetica.Model;

public abstract class Device {

    private boolean state;
    private Point coordinate;

    Device(){
        this.state = false;
        this.coordinate = new Point(-1, -1);
    }

    Device(boolean state, Point coordinate){
        this.coordinate = coordinate;
        this.state = state;
    }

    void setCoordinate(Point coordinate){
        this.coordinate = coordinate;
    }

    void setState(boolean state){
        this.state = state;
    }

    String getTextStatus(){
        return getState() ? "on" : "off";
    }

    String getPlace(){
        return this.coordinate.toString();
    }

    boolean getState() {
        return state;
    }

    public void changeState(){
        this.state = !this.state;
    }
    public abstract void move(Point coordinateToSet);
    public abstract double getPower();

}
