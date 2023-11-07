package com.koroyan.restassuredexample.steps;

import com.koroyan.restassuredexample.enums.EndPoint;
import com.koroyan.restassuredexample.enums.SOAPAction;
import com.koroyan.restassuredexample.pojos.request.Envelope;
import com.koroyan.restassuredexample.pojos.response.GetListByNameResult;
import com.koroyan.restassuredexample.services.RequestService;
import io.restassured.RestAssured;


import static io.restassured.RestAssured.given;

public class Step {

    public Step() {
        disableWarning();
    }


    private void disableWarning() {
        System.err.close();
        System.setErr(System.out);
    }

    public GetListByNameResult GetListByName(String name) {
        Envelope getListByName = RequestService.getFindListPersonRequestModel(name);
        RestAssured.baseURI = EndPoint.Base_URL_For_Findperson.toString();
        return given()
                .contentType("text/xml;charset=UTF-8").and()
                .header("SOAPAction", SOAPAction.Find_Person_List.toString())
                .body(getListByName)
                .when().log().all()
                .post(EndPoint.Base_URL_For_Findperson.toString())
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .body().xmlPath().getObject("Envelope.Body.GetListByNameResponse.GetListByNameResult",
                        GetListByNameResult.class);
    }
}
