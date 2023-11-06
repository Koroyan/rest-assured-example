package com.koroyan.restassuredexample.pojos.response;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PersonIdentification")
public class PersonIdentification {
    private int id;
    private String name;
    private String ssn;
    private String dob;

    public PersonIdentification() {
    }

    public PersonIdentification(int id, String name, String ssn, String dob) {
        this.id = id;
        this.name = name;
        this.ssn = ssn;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    @XmlElement(name = "ID")
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "Name")
    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    @XmlElement(name = "SSN")
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getDob() {
        return dob;
    }

    @XmlElement(name = "DOB")
    public void setDob(String dob) {
        this.dob = dob;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    public boolean equalsTo(PersonIdentification personIdentification) {
        return this.id == personIdentification.getId() &&
                this.name.equals(personIdentification.getName()) &&
                this.ssn.equals(personIdentification.getSsn()) &&
                this.dob.equals(personIdentification.getDob());
    }
}
