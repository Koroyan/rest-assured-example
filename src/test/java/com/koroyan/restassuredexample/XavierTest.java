package com.koroyan.restassuredexample;
import com.koroyan.restassuredexample.data.Data;
import com.koroyan.restassuredexample.pojos.response.GetListByNameResult;
import com.koroyan.restassuredexample.repository.GetListByNameRepository;
import com.koroyan.restassuredexample.repository.GetListByNameRepositoryImpl;
import com.koroyan.restassuredexample.steps.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
public class XavierTest {
    Data data = new Data();
    Step  step = new Step();;
    GetListByNameRepository GetListByNameRepository = new GetListByNameRepositoryImpl();


    @Test
    public void testPersonListByName() {
        GetListByNameResult apiXavier = step.getListByName(data.xavierName);
        GetListByNameResult databaseXavier = GetListByNameRepository.getListByName(data.xavierName);
        Assert.assertEquals(apiXavier, databaseXavier);
    }

}

