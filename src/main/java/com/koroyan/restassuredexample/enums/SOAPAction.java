package com.koroyan.restassuredexample.enums;

public enum  SOAPAction {
    ADD_INTEGER("AddInteger"),
    DIVIDE_INTEGER("DivideInteger"),
    FIND_PERSON("FindPerson");

    private final String value;

    SOAPAction(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
