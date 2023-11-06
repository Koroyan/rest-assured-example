package com.koroyan.restassuredexample.utils;

public class StringRequests {
    public static String getAddIntegerRequest(int x,int y){
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org\">\n" +
                "    <soapenv:Header/>\n" +
                "    <soapenv:Body>\n" +
                "        <tem:AddInteger>\n" +
                "            <tem:Arg1>"+x+"</tem:Arg1>\n" +
                "            <tem:Arg2>"+y+"</tem:Arg2>\n" +
                "        </tem:AddInteger>\n" +
                "    </soapenv:Body>\n" +
                "</soapenv:Envelope>";
    }

    public static String getListByNameRequest(String name){
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <tem:GetListByName>\n" +
                "         <!--Optional:-->\n" +
                "         <tem:name>" + name + "</tem:name>\n" +
                "      </tem:GetListByName>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>\t";
    }
}
