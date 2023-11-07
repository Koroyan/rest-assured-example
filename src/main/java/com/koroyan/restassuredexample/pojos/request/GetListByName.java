package com.koroyan.restassuredexample.pojos.request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://tempuri.org")
@XmlRootElement(name = "GetListByName")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GetListByName {

    private String name;


}