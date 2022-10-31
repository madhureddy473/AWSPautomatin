package main.java.api.xmlAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.json.XML;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class xmlAPITest extends xmlBodyCreation{

//    String baseURL = new GetPropertiesFromSysOrConfig().getPropertyFromSysOrConfig("xmlBaseUrl");

    String baseURL = "http://q1ws.qa.moneygram.com/";
    String baseURL1 = "https://q1ws.qa.moneygram.com/";


   public void getReAuthServlet(){

       String url = baseURL+ "ac2web/servlet/ReauthServlet";

       Response response = RestAssured.
               given().
               header("Connection", "keep-alive").
               header("Referer", "q1ws.qa.moneygram.com/servlet/ReauthServlet").
               header("Host", "q1ws.qa.moneygram.com").
               when().
               get(url).then().
               extract().response();

   }


   public Map<String, String> reAuthServlet(HashMap<String, String> excelData){
       Map<String, String> returnData = new HashMap<>();

       String requestBody = reAuth(excelData);

       String url = baseURL+ "ac2web/servlet/ReauthServlet";

       Response response = RestAssured.
               given().
               header("Connection", "keep-alive").
               header("Referer", "q1ws.qa.moneygram.com/servlet/ReauthServlet").
               header("Host", "q1ws.qa.moneygram.com").
               body(requestBody).
               when().
               post(url);

       return returnData;
   }

   public Map<String, String> checkInRequest(HashMap<String, String> excelData){
       Map<String, String> returnData = new HashMap<>();

       String requestBody = checkIn(excelData);

       String url = baseURL + "ac2/services/AgentConnect1705";

       Response response = RestAssured.
               given().
               header("SOAPAction", "SOAP 1.1").
               header("Content-Type", "text/xml").
               header("Host", "q1ws.qa.moneygram.com").
               body(requestBody).
               when().
               post(url);

       return returnData;
   }

    public Map<String, String> confirmTokenRequest(HashMap<String, String> excelData){
        Map<String, String> returnData = new HashMap<>();
        String requestBody = confirmToken(excelData);

        String url = baseURL + "ac2/services/AgentConnect1705";

        Response response = RestAssured.
                given().
                header("SOAPAction", "SOAP 1.1").
                header("Content-Type", "text/xml").
                header("Host", "q1ws.qa.moneygram.com").
                body(requestBody).
                when().
                post(url);

        return returnData;
    }

    public Map<String, String> feeLookupRequest(HashMap<String, String> excelData) throws Exception {
        HashMap<String, String> returnData = new HashMap<>();

        String url = baseURL + "ac2/services/AgentConnect1705";

        System.out.println("---fee lookup request is---" + feeLookup(excelData));

        Response response = RestAssured.
                given().
                header("SOAPAction", "SOAP 1.1").
                header("Content-Type", "text/xml").
                header("Host", "q1ws.qa.moneygram.com").
                body(feeLookup(excelData)).
                when().
                post(url).
                then().contentType(ContentType.XML).
                extract().response();

        System.out.println("---fee lookup response is--"+ response.asString());

        if (response.getStatusCode() == 200) {

            JSONObject json = XML.toJSONObject(response.asString());
            returnData.put("mgiSessionId", (String) json.getJSONObject("soapenv:Envelope").getJSONObject("soapenv:Body").getJSONObject("ac:feeLookupResponse").getJSONObject("ac:payload").getJSONObject("ac:feeInfos").getJSONObject("ac:feeInfo").get("ac:mgiSessionID"));
        }
        else{
            System.out.println("The Status code is " + response.getStatusCode());
            throw new Exception("Unexpected error " + "\n" + response.asString());
        }

        return returnData;
    }

    public Map<String, String> sendValidationRequest(HashMap<String, String> excelData, Map<String, String> apiData) throws Exception {
        HashMap<String, String> returnData = new HashMap<>();
        String firstName = RandomStringUtils.randomAlphabetic(4).toLowerCase();
        String lastName = RandomStringUtils.randomAlphabetic(4).toLowerCase();
        String date = String.valueOf((int) ((Math.random() *(19 -1)) + 10));

        apiData.put("firstName", firstName );
        apiData.put("lastName", lastName);
        apiData.put("date", date);

        String url = baseURL + "ac2/services/AgentConnect1705";

        System.out.println("---request is---" + sendValidation(excelData, apiData));

        Response response = RestAssured.
                given().
                header("SOAPAction", "SOAP 1.1").
                header("Content-Type", "text/xml").
                header("Host", "q1ws.qa.moneygram.com").
                body(sendValidation(excelData, apiData)).
                when().
                post(url).
                then().contentType(ContentType.XML).
                extract().response();

        System.out.println("---response is--"+ response.asString());

        JSONObject json = XML.toJSONObject(response.asString());

        if (response.getStatusCode() == 200) {

            returnData.put("firstName", firstName);
            returnData.put("lastName", lastName);
            returnData.put("date", date);
        }
        else{
            System.out.println("The Status code is " + response.getStatusCode());
            throw new Exception("Unexpected error " + "\n" + response.asString());
        }
        return returnData;

    }

    public Map<String, String> completeSessionRequest(HashMap<String, String> excelData, Map<String, String> apiData) throws Exception {
        HashMap<String, String> returnData = new HashMap<>();

        String url = baseURL + "ac2/services/AgentConnect1705";

        System.out.println("---request is---" + sessionComplete(excelData, apiData));

        Response response = RestAssured.
                given().
                header("SOAPAction", "SOAP 1.1").
                header("Content-Type", "text/xml").
                header("Host", "q1ws.qa.moneygram.com").
                body(sessionComplete(excelData, apiData)).
                when().
                post(url).
                then().contentType(ContentType.XML).
                extract().response();

        System.out.println("---response is--"+ response.asString());

        JSONObject json = XML.toJSONObject(response.asString());

        if (response.getStatusCode() == 200) {

        }

        else{
            System.out.println("The Status code is " + response.getStatusCode());
            throw new Exception("Unexpected error " + "\n" + response.asString());
        }

        return returnData;

    }

    public Map<String, String> tranLookupRequest(HashMap<String, String> excelData) throws Exception {
        HashMap<String, String> returnData = new HashMap<>();

        String url = baseURL + "ac2/services/AgentConnect1705";

        System.out.println("---tran request is---" + tranLookup(excelData));

        Response response = RestAssured.
                given().
                header("SOAPAction", "SOAP 1.1").
                header("Content-Type", "text/xml").
                header("Host", "q1ws.qa.moneygram.com").
                body(tranLookup(excelData)).
                when().
                post(url).
                then().contentType(ContentType.XML).
                extract().response();

        System.out.println("---tran response is--"+ response.asString());

        JSONObject json = XML.toJSONObject(response.asString());

        if (response.getStatusCode() == 200) {
            returnData.put("receiveMgiSessionId", (String) json.getJSONObject("soapenv:Envelope").getJSONObject("soapenv:Body").getJSONObject("ac:transactionLookupResponse").getJSONObject("ac:payload").get("ac:mgiSessionID"));
        }

        else{
            System.out.println("The Status code is " + response.getStatusCode());
            throw new Exception("Unexpected error " + "\n" + response.asString());
        }

        return returnData;

    }

    public Map<String, String> receiveValidationRequest(HashMap<String, String> excelData, Map<String, String> apiData) throws Exception {
        HashMap<String, String> returnData = new HashMap<>();

        String url = baseURL + "ac2/services/AgentConnect1705";

        System.out.println("---receive validation request is---" + receiveValidation(excelData, apiData));

        Response response = RestAssured.
                given().
                header("SOAPAction", "SOAP 1.1").
                header("Content-Type", "text/xml").
                header("Host", "q1ws.qa.moneygram.com").
                body(receiveValidation(excelData, apiData)).
                when().
                post(url).
                then().contentType(ContentType.XML).
                extract().response();

        System.out.println("---receive validation response is--"+ response.asString());

        JSONObject json = XML.toJSONObject(response.asString());

        Assert.assertEquals(response.getStatusCode(), 200);

        if (response.getStatusCode() == 200) {
            System.out.println("Successful response");
            returnData.put("receiveMgiSessionId", apiData.get("receiveMgiSessionId"));
        }

        else{
            System.out.println("The Status code is " + response.getStatusCode());
            throw new Exception("Unexpected error " + "\n" + response.asString());
        }
        return returnData;
    }

    public Map<String, String> receiveCompleteSessionRequest(HashMap<String, String> excelData, Map<String, String> apiData) throws Exception {
        HashMap<String, String> returnData = new HashMap<>();

        String url = baseURL + "ac2/services/AgentConnect1705";

        System.out.println("---receive complete request is---" + receiveCompleteSession(excelData, apiData));

        Response response = RestAssured.
                given().
                header("SOAPAction", "SOAP 1.1").
                header("Content-Type", "text/xml").
                header("Host", "q1ws.qa.moneygram.com").
                body(receiveCompleteSession(excelData, apiData)).
                when().
                post(url).
                then().contentType(ContentType.XML).
                extract().response();

        System.out.println("---receive complete response is--"+ response.asString());

        JSONObject json = XML.toJSONObject(response.asString());

        if (response.getStatusCode() == 200) {
            System.out.println("Successful response");
        }

        else{
            System.out.println("The Status code is " + response.getStatusCode());
            throw new Exception("Unexpected error " + "\n" + response.asString());
        }
        return returnData;
    }


}
