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

    public DeviceController(Viewer viewer, DeviceSet deviceSet, ConsoleReader consoleReader){
        this.viewer = viewer;
        this.deviceSet = deviceSet;
        this.consoleReader = consoleReader;
    }

    public void showMenu(){
        viewer.viewMessage(viewer.getString(viewer.MENU));
    }

    private int getUserNumber() throws java.lang.NumberFormatException{
        int result;
        result = Integer.parseInt(consoleReader.getLine());
        return result;
    }

    private ArrayList<Device> getByRange(){
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
                viewer.viewMessage("Set small flat");
                break;
            case 2:
                this.deviceSet = DeviceSet.AVERAGE_FLAT;
                viewer.viewMessage("Set big flat");

                break;
            case 3:
                this.deviceSet = DeviceSet.BIG_HOUSE;
                viewer.viewMessage("Set big house");

                break;

        }
    }

//    public void changeLanguage(){
////        Locale locale;
////        if(Locale.getDefault() == )
////
//    }

    public void startScenario(){

        int choice = 0;
        viewer.viewMessage(viewer.getString(viewer.GREETING));
        label: while (true){
            showMenu();

            try {
                choice = getUserNumber();
            }catch (java.lang.NumberFormatException e){
                viewer.viewErrorMessage(viewer.getString(viewer.INPUT_EXCEPTION));
            }

            switch (choice){

                case 1: viewer.viewMessage(viewer.getString(viewer.OPTION1));
                    int choiceOfSet = 0;
                    try {
                        choiceOfSet = getUserNumber();
                    }catch (java.lang.NumberFormatException e){
                        viewer.viewErrorMessage(viewer.getString(viewer.INPUT_EXCEPTION));
                        break label;
                    }
                    setChosenSet(choiceOfSet);
                    break;

                case 2:viewer.viewMessage(viewer.getString(viewer.OPTION2));
                    viewer.viewMessage(Double.toString(deviceSet.calculatePower()));
                    break;

                case 3: viewer.viewMessage(viewer.getString(viewer.OPTION3));
                    deviceSet.sortByPower();
                    viewer.viewMessage(deviceSet.toString());
                    break;

                case 4: viewer.viewMessage(viewer.getString(viewer.OPTION4));
                    ArrayList<Device> toShow = getByRange();
                    viewer.viewMessage(toShow.toString());
                    break;

                case 5:
                    viewer.viewMessage(viewer.getString(viewer.OPTION5));

                default: break;
//                    break label;

            }
        }


    }
}
