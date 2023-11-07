package com.koroyan.restassuredexample.enums;

public enum EndPoint {
    Base_URL_For_Findperson("https://www.crcind.com:443/csp/samples/SOAP.Demo.cls");

    private final String value;

    EndPoint(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
