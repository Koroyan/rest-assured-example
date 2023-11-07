package com.koroyan.restassuredexample;

import com.koroyan.restassuredexample.pojos.response.GetListByNameResult;
import com.koroyan.restassuredexample.repository.ListByNameRepository;
import com.koroyan.restassuredexample.repository.ListByNameRepositoryImpl;
import com.koroyan.restassuredexample.steps.Step;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApiTest {

    Step step;
    ListByNameRepository listByNameRepository;
    String name = "Xavier";

    @BeforeMethod
    public void setUp() throws JSONException{
        step = new Step();
        listByNameRepository = new ListByNameRepositoryImpl();
    }

    @Test
    public void getListByName() {
        GetListByNameResult persons = step.GetListByName(name);
        GetListByNameResult db = listByNameRepository.getListByName(name);
        try {
            JSONAssert.assertEquals(persons.toString(), db.toString(), false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}
