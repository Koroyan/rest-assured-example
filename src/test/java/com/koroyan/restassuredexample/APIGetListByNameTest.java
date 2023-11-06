package com.koroyan.restassuredexample;


import com.koroyan.restassuredexample.pojos.response.GetListByNameResult;
import com.koroyan.restassuredexample.pojos.response.PersonIdentification;
import com.koroyan.restassuredexample.steps.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APIGetListByNameTest {
    private Step step = new Step();

    @Test
    public void getListByName() {
        GetListByNameResult getListByNameResult1 = step.getListByName();
        // for demonstration only
        for(PersonIdentification person: getListByNameResult1.getPersonIdentifications())
            System.out.println(person.toString());

        GetListByNameResult getListByNameResult2 = step.getListByName("Xavier");
        // for demonstration only
        for(PersonIdentification person: getListByNameResult2.getPersonIdentifications())
            System.out.println(person.toString());

        Assert.assertTrue(getListByNameResult1.equalsTo(getListByNameResult2));


//        GetListByNameResult getListByNameResult3 = step.getListByNameEnvelope("Xavier");
    }
}
