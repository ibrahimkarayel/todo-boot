package com.pironix.utils;

/**
 * Created by ibrahim
 *
 * @author ibrahim KARAYEL
 * @version 1.0
 * @since 9/3/2016.
 */
public enum TodoCategories {
    MEETING("MEETING"),
    PROJECT("PROJECT"),
    SHOPPING("PROJECT"),
    LESSON("LESSON"),
    OUTDOOR("OUTDOOR");
    private String value;

    TodoCategories(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
