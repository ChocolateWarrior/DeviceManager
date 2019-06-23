package com.helvetica.View;

import com.helvetica.Controller.ResourceController;

import java.util.Locale;

public class Viewer {
    public final String GREETING = "interface.welcome";
    public final String MENU = "interface.menu";
    public final String REQUEST_BOTTOM_LIMIT = "interface.bottomlimit";
    public final String REQUEST_TOP_LIMIT = "interface.toplimit";
    public final String INPUT_EXCEPTION = "interface.inputexception";
    public final String OPTION1 = "interface.chooseset";
    public final String OPTION2 = "interface.calculatedpower";
    public final String OPTION3 = "interface.sortbypower";
    public final String OPTION4 = "interface.chooserange";
    public final String OPTION5 = "interface.changelanguage";
    public final String BYE = "interface.bye";
    public final String WRONG_OPTION = "interface.wrongoption";
    public final String TRY_AGAIN = "invalid.tryagain";
    public final String SET_SMALL_FLAT = "interface.setsmallflat";
    public final String SET_BIG_FLAT = "interface.setbigflat";
    public final String SET_BIG_HOUSE = "interface.setbighouse";



    private ResourceController resourceController;
    public Viewer(){
        this.resourceController = ResourceController.USER_INTERFACE;
    }

    public void viewMessage(String msg){
        System.out.println(msg);
    }
    public void viewErrorMessage(String msg){ System.err.println(msg); }
    public void changeResource(Locale locale) {
        resourceController.changeResource(locale);
    }

    public String getString(String string){
        return resourceController.getString(string);
    }

}
