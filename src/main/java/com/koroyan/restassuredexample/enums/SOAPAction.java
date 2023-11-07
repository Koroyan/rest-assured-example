package com.koroyan.restassuredexample.enums;

public enum  SOAPAction {
    Find_Person_List("GetListByName");

    private final String value;

    SOAPAction(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
