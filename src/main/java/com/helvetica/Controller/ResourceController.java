package com.helvetica.Controller;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceController {

    USER_INTERFACE("property.message");

    private ResourceBundle resourceBundle;
    private String resourceName;

    /**
     * Constructor for resource controller
     * @param resourceName (String) - string to get bundle from
     */
    ResourceController(String resourceName) {
        this.resourceName = resourceName;
        this.resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
    }

    /**
     * Method to change resource if needed
     * @param locale (Locale) - locale to set
     */
    public void changeResource(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(
                resourceName, locale);

    }

    /**
     * Method to get string value by key
     * @param key (String) - key to get value by
     * @return (String)
     */
    public String getString(String key) {
        return resourceBundle.getString(key);
    }

}
