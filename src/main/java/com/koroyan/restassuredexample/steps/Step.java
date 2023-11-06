package com.koroyan.restassuredexample.steps;

import com.koroyan.restassuredexample.enums.EndPoint;
import com.koroyan.restassuredexample.enums.SOAPAction;
import com.koroyan.restassuredexample.pojos.request.Envelope;
import com.koroyan.restassuredexample.pojos.response.FindPersonResult;
import com.koroyan.restassuredexample.pojos.response.GetListByNameResult;
import com.koroyan.restassuredexample.services.RequestService;
import com.koroyan.restassuredexample.utils.StringRequests;
import com.koroyan.restassuredexample.utils.XmlUtils;
import io.restassured.*;
import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class Step {

    public Step() {
        disableWarning();
    }


    private void disableWarning() {
        System.err.close();
        System.setErr(System.out);
    }

    public int addInteger(int x, int y) {
        Envelope addIntegerRequestModel = RequestService.getAddIntegerRequestModel(x, y);
        return Integer.parseInt(
                given()
                        .contentType("text/xml;charset=UTF-8").and()
                        .header("SOAPAction", SOAPAction.ADD_INTEGER.toString())
                        .body(addIntegerRequestModel)
                        .when().log().all()
                        .post(EndPoint.BASE_URL.toString())
                        .then()
                        .log().ifError()
                        .assertThat()
                        .statusCode(200)
                        //.body("Envelope.Body.AddIntegerResponse.AddIntegerResult", equalTo("2"))
                        .extract().path("Envelope.Body.AddIntegerResponse.AddIntegerResult"));
    }

    public int addIntegerXml(int x, int y) throws IOException {
        String path = "src/main/resources/request.xml";
        XmlUtils.setValue(
                "tem:Arg1", x,
                "tem:Arg2", y);

        FileInputStream fileInputStream = new FileInputStream(path);
        return Integer.parseInt(given()
                .contentType("text/xml;charset=UTF-8").and()
                .header("SOAPAction", SOAPAction.ADD_INTEGER.toString())
                .body(IOUtils.toString(fileInputStream, StandardCharsets.UTF_8))
                .when().log().all()
                .post(EndPoint.BASE_URL.toString())
                .then()
                .log().ifError()
                .assertThat()
                .statusCode(200)
                //.body("Envelope.Body.AddIntegerResponse.AddIntegerResult", equalTo("2"))
                .extract().path("Envelope.Body.AddIntegerResponse.AddIntegerResult"));
    }

    public int addIntegerString(int x, int y){
        String addIntegerRequest = StringRequests.getAddIntegerRequest(x, y);
        return Integer.parseInt(given()
                .contentType("text/xml;charset=UTF-8").and()
                .header("SOAPAction", SOAPAction.ADD_INTEGER.toString())
                .body(addIntegerRequest)
                .when().log().all()
                .post(EndPoint.BASE_URL.toString())
                .then()
                .log().ifError()
                .assertThat()
                .statusCode(200)
                //.body("Envelope.Body.AddIntegerResponse.AddIntegerResult", equalTo("2"))
                .extract().path("Envelope.Body.AddIntegerResponse.AddIntegerResult"));
    }


    public FindPersonResult findPerson(String id) {
        Envelope findPersonRequestModel = RequestService.getFindPersonRequestModel(id);
        RestAssured.baseURI = EndPoint.BASE_URL.toString();
        return given()
                .contentType("text/xml;charset=UTF-8").and()
                .header("SOAPAction", SOAPAction.FIND_PERSON.toString())
                .body(findPersonRequestModel)
//                .when().log().all()
                .post(EndPoint.BASE_URL.toString())
                .then()
                .log().ifError()
                .assertThat()
                .statusCode(200)
                .extract()
                .body().xmlPath().getObject("Envelope.Body.FindPersonResponse.FindPersonResult",
                        FindPersonResult.class);
    }

    public GetListByNameResult getListByName() {
        RestAssured.baseURI = EndPoint.BASE_URL.toString();
        return given()
                .contentType(ContentType.XML)
                .header("SOAPaction", SOAPAction.GET_LIST_BY_NAME.toString())
                .body(new File("src/main/resources/getListByNameRequest.xml"))
                .post(EndPoint.BASE_URL.toString())
                .then()
                .log().ifError()
                .assertThat()
                .statusCode(200)
                .extract()
                .body().xmlPath().getObject("Envelope.Body.GetListByNameResponse.GetListByNameResult", GetListByNameResult.class);
    }

    public GetListByNameResult getListByName(String name) {
        String listByNameRequestModel = StringRequests.getListByNameRequest(name);
        RestAssured.baseURI = EndPoint.BASE_URL.toString();
        return given()
                .contentType("text/xml;charset=UTF-8").and()
                .header("SOAPAction", SOAPAction.GET_LIST_BY_NAME.toString())
                .body(listByNameRequestModel)
                .post(EndPoint.BASE_URL.toString())
                .then()
                .log().ifError()
                .assertThat()
                .statusCode(200)
                .extract()
                .body().xmlPath().getObject("Envelope.Body.GetListByNameResponse.GetListByNameResult", GetListByNameResult.class);
    }

    @Deprecated
    public GetListByNameResult getListByNameEnvelope(String name) {
        Envelope listByNameRequestModel = RequestService.getListByNameRequestModel(name);
        RestAssured.baseURI = EndPoint.BASE_URL.toString();
        return given()
                .contentType(ContentType.XML)
                .header("SOAPAction", SOAPAction.GET_LIST_BY_NAME.toString())
                .body(listByNameRequestModel)
                .post(EndPoint.BASE_URL.toString())
                .then()
                .log().ifError()
                .assertThat()
                .statusCode(200)
                .extract()
                .body().xmlPath().getObject("Envelope.Body.GetListByNameResponse.GetListByNameResult", GetListByNameResult.class);
    }

}
