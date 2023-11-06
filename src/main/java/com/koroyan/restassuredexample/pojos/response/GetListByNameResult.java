package com.koroyan.restassuredexample.pojos.response;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "GetListByNameResult")
public class GetListByNameResult {
    private List<PersonIdentification> personIdentifications;

    public GetListByNameResult(){}

    public GetListByNameResult(List<PersonIdentification> personIdentifications) {
        this.personIdentifications = personIdentifications;
    }

    @XmlElement(name = "PersonIdentification")
    public List<PersonIdentification> getPersonIdentifications() {
        return personIdentifications;
    }

    public void setPersonIdentifications(List<PersonIdentification> personIdentifications) {
        this.personIdentifications = personIdentifications;
    }

    public boolean equalsTo(GetListByNameResult getListByNameResult){
        if(this.personIdentifications.size() != getListByNameResult.getPersonIdentifications().size())
            return false;

        for (int i=0; i<personIdentifications.size(); i++){
            if(!this.personIdentifications.get(i).equalsTo(getListByNameResult.getPersonIdentifications().get(i)))
                return false;
        }
        return true;
    }
}
