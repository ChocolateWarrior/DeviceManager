package com.helvetica.Controller;

import com.helvetica.Model.Device;
import com.helvetica.Model.DeviceSet;
import com.helvetica.View.Viewer;

import java.util.ArrayList;
import java.util.Locale;

public class DeviceController {

    private Viewer viewer;
    private DeviceSet deviceSet;
    private ConsoleReader consoleReader;
    private Locale locale;

    /**
     * Constructor for DeviceController
     * @param viewer (Viewer)
     * @param deviceSet (DeviceSet)
     * @param consoleReader (ConsoleReader)
     */
    public DeviceController(Viewer viewer, DeviceSet deviceSet, ConsoleReader consoleReader){
        this.viewer = viewer;
        this.deviceSet = deviceSet;
        this.consoleReader = consoleReader;
        this.locale = new Locale("en");
    }

    private void showMenu(){
        viewer.viewMessage(viewer.getString(viewer.MENU));
    }

    private int getUserNumber() throws java.lang.NumberFormatException{
        int result;
        result = Integer.parseInt(consoleReader.getLine());
        return result;
    }

    private ArrayList<Device> getByRange() throws NumberFormatException{
        int bottomLimit = 0;
        int topLimit = 0;

        while (bottomLimit >= topLimit){
            viewer.viewMessage(viewer.getString(viewer.REQUEST_BOTTOM_LIMIT));
            bottomLimit = getUserNumber();
            viewer.viewMessage(viewer.getString(viewer.REQUEST_TOP_LIMIT));
            topLimit = getUserNumber();
        }

        return deviceSet.findDevicesByRange(bottomLimit,topLimit);

    }

    private void setChosenSet(int num){
        switch (num) {
            case 1:
                this.deviceSet = DeviceSet.SMALL_FLAT;
                viewer.viewMessage(viewer.getString(viewer.SET_SMALL_FLAT));
                break;
            case 2:
                this.deviceSet = DeviceSet.AVERAGE_FLAT;
                viewer.viewMessage(viewer.getString(viewer.SET_BIG_FLAT));

                break;
            case 3:
                this.deviceSet = DeviceSet.BIG_HOUSE;
                viewer.viewMessage(viewer.getString(viewer.SET_BIG_HOUSE));

                break;

            default: viewer.viewMessage(viewer.getString(viewer.WRONG_OPTION));
                break;

        }
    }

    private void changeLanguage(){

        if(locale.getLanguage().equals("en")){
            locale = new Locale("uk");
        } else {
            locale = new Locale("en");
        }

        viewer.changeResource(locale);

    }

    /**
     * Method to execute, manages connection with user
     * Contains private methods, needed for proper execution
     */
    public void startScenario(){

        int choice = 0;

        viewer.viewMessage(viewer.getString(viewer.GREETING));
        label: while (true){
            showMenu();

            try {
                choice = getUserNumber();
            }catch (java.lang.NumberFormatException e){
                viewer.viewErrorMessage(viewer.getString(viewer.INPUT_EXCEPTION));
                viewer.viewErrorMessage(viewer.getString(viewer.TRY_AGAIN));
                startScenario();
            }

            switch (choice){

                case 1: viewer.viewMessage(viewer.getString(viewer.OPTION1));
                    int choiceOfSet;
                    try {
                        choiceOfSet = getUserNumber();
                        setChosenSet(choiceOfSet);
                    }catch (java.lang.NumberFormatException e){
                        viewer.viewErrorMessage(viewer.getString(viewer.INPUT_EXCEPTION));
                        viewer.viewErrorMessage(viewer.getString(viewer.TRY_AGAIN));
                        break;
                    }
                    break;

                case 2:viewer.viewMessage(viewer.getString(viewer.OPTION2));
                    viewer.viewMessage(Double.toString(deviceSet.calculatePower()));
                    break;

                case 3: viewer.viewMessage(viewer.getString(viewer.OPTION3));
                    deviceSet.sortByPower();
                    viewer.viewMessage(deviceSet.toString());
                    break;

                case 4: viewer.viewMessage(viewer.getString(viewer.OPTION4));
                    try {
                        ArrayList<Device> toShow = getByRange();
                        viewer.viewMessage(toShow.toString());
                    }catch (java.lang.NumberFormatException e) {
                        viewer.viewErrorMessage(viewer.getString(viewer.INPUT_EXCEPTION));
                        viewer.viewErrorMessage(viewer.getString(viewer.TRY_AGAIN));
                        break;
                    }
                    break;

                case 5:
                    changeLanguage();
                    viewer.viewMessage(viewer.getString(viewer.OPTION5));
                    break;

                case 6: viewer.viewMessage(viewer.getString(viewer.BYE));
                    break label;

                default: viewer.viewMessage(viewer.getString(viewer.WRONG_OPTION));
                    viewer.viewErrorMessage(viewer.getString(viewer.TRY_AGAIN));
                    break;

            }
        }


    }
}
