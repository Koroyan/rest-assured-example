package com.koroyan.restassuredexample.pojos.response;


import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "GetListByNameResult")
@AllArgsConstructor
@NoArgsConstructor
public class GetListByNameResult {

    private List<PersonIdentification> personIdentification;
    @XmlElement(name = "PersonIdentification")
    public List<PersonIdentification> getPersonIdentification() {
        return personIdentification;
    }

    public void setPersonIdentification(List<PersonIdentification> personIdentification) {
        this.personIdentification = personIdentification;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GetListByNameResult other = (GetListByNameResult) obj;
        return this.personIdentification.equals(other.personIdentification);
    }
}