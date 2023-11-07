package com.koroyan.restassuredexample.pojos.response;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PersonIdentification")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonIdentification {
    private int id;
    private String name;
    private String ssn;
    private String dob;

    @XmlElement(name = "ID")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @XmlElement(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElement(name = "SSN")
    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    @XmlElement(name = "DOB")
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PersonIdentification other = (PersonIdentification) obj;
        return this.id == other.id &&
                this.ssn.equals(other.ssn) &&
                this.dob.equals(other.dob) &&
                this.name.replaceAll("\\s", "").equals(other.name.replaceAll("\\s", ""));
    }
}