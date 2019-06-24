package com.helvetica.Model;

public class Point {

    private double x;
    private double y;

    /**
     * Constructor
     * @param x - coordinate X-axis
     * @param y - coordinate Y-axis
     */
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    private double getX() { return this.x; }
    private double getY() { return this.y; }

    /**
     * Overridden method toString
     * @return (String)
     */
    @Override
    public String toString(){
        return "x: " + getX() + "\n" +
                "y: " + getY();
    }

}
