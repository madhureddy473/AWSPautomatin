package main.java.api.xmlAPI;

import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class xmlBodyCreation extends RestAssured {

    private static final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    public String reAuth(HashMap<String, String> excelData){

        return "AGENT_ID=66637611&POS_NUMBER=10&ID_TYPE=AGENT_ID";
    }

    public String checkIn(HashMap<String, String> excelData){

        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "   <Header>\n" +
                "      <wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                "         <wsu:Timestamp />\n" +
                "         <wsse:UsernameToken>\n" +
                "            <wsse:Username>"+excelData.get("agentID")+excelData.get("pos")+"</wsse:Username>\n" +
                "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">456</wsse:Password>\n" +
                "         </wsse:UsernameToken>\n" +
                "      </wsse:Security>\n" +
                "   </Header>\n" +
                "   <Body>\n" +
                "      <checkInRequest xmlns=\"http://www.moneygram.com/AgentConnect"+excelData.get("acVersion")+"\">\n" +
                "         <agentID>"+excelData.get("agentID")+"</agentID>\n" +
                "         <agentSequence>"+excelData.get("pos")+"</agentSequence>\n" +
                "         <timeStamp>"+date.format(new Date())+"</timeStamp>\n" +
                "         <clientSoftwareVersion>"+excelData.get("acVersion")+"</clientSoftwareVersion>\n" +
                "         <poeType>AGENTCONNECT</poeType>\n" +
                "         <channelType>LOCATION</channelType>\n" +
                "         <targetAudience>AGENT_FACING</targetAudience>\n" +
                "      </checkInRequest>\n" +
                "   </Body>\n" +
                "</Envelope>";

    }

    public String confirmToken(HashMap<String, String> excelData){
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "   <Header>\n" +
                "            <wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                "            <wsu:Timestamp/>\n" +
                "            <wsse:UsernameToken>\n" +
                "                <wsse:Username>"+excelData.get("agentID")+excelData.get("pos")+"</wsse:Username>\n" +
                "                <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">456</wsse:Password>\n" +
                "            </wsse:UsernameToken>\n" +
                "        </wsse:Security>\n" +
                "  </Header>\n" +
                "   <Body>\n" +
                "      <confirmTokenRequest xmlns=\"http://www.moneygram.com/AgentConnect1705\">\n" +
                "         <agentID>"+excelData.get("agentID")+"</agentID>\n" +
                "         <agentSequence>"+excelData.get("pos")+"</agentSequence>\n" +
                "         <timeStamp>"+date.format(new Date())+"</timeStamp>\n" +
                "         <clientSoftwareVersion>"+excelData.get("acVersion")+"</clientSoftwareVersion>\n" +
                "         <poeType>AGENTCONNECT</poeType>\n" +
                "         <channelType>LOCATION</channelType>\n" +
                "         <targetAudience>AGENT_FACING</targetAudience>\n" +
                "      </confirmTokenRequest>\n" +
                "   </Body>\n" +
                "</Envelope>";
    }

    public String feeLookup(HashMap<String, String> excelData){
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "   <Header>\n" +
                "            <wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                "            <wsu:Timestamp/>\n" +
                "            <wsse:UsernameToken>\n" +
                "                <wsse:Username>"+excelData.get("agentID")+excelData.get("pos")+"</wsse:Username>\n" +
                "                <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">456</wsse:Password>\n" +
                "            </wsse:UsernameToken>\n" +
                "        </wsse:Security>\n" +
                "  </Header>\n" +
                "   <Body>\n" +
                "      <feeLookupRequest xmlns=\"http://www.moneygram.com/AgentConnect1705\">\n" +
                "         <agentID>"+excelData.get("agentID")+"</agentID>\n" +
                "         <agentSequence>"+excelData.get("pos")+"</agentSequence>\n" +
                "         <timeStamp>"+date.format(new Date())+"</timeStamp>\n" +
                "         <clientSoftwareVersion>"+excelData.get("acVersion")+"</clientSoftwareVersion>\n" +
                "         <poeType>AGENTCONNECT</poeType>\n" +
                "         <channelType>LOCATION</channelType>\n" +
                "         <targetAudience>AGENT_FACING</targetAudience>\n" +
                "         <mgiSessionType>SEND</mgiSessionType>\n" +
                "         <receiveAmount>"+excelData.get("amount")+"</receiveAmount>\n" +
                "         <destinationCountry>"+excelData.get("DestCountry")+"</destinationCountry>\n" +
                "         <destinationCountrySubdivisionCode>"+excelData.get("DestState")+"</destinationCountrySubdivisionCode>\n" +
                "         <serviceOption>WILL_CALL</serviceOption>\n" +
                "         <receiveCurrency>"+excelData.get("receiveCurrency")+"</receiveCurrency>\n" +
                "         <sendCurrency>"+excelData.get("sendCurrency")+"</sendCurrency>\n" +
                "         <defaultMaxFee>true</defaultMaxFee>\n" +
                "         <allOptions>false</allOptions>\n" +
                "         \n" +
                "      </feeLookupRequest>\n" +
                "   </Body>\n" +
                "</Envelope>";
    }

    public String sendValidation(HashMap<String, String> excelData, Map<String, String> apiData){
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "   <Header>\n" +
                "            <wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                "            <wsu:Timestamp/>\n" +
                "            <wsse:UsernameToken>\n" +
                "                <wsse:Username>"+excelData.get("agentID")+excelData.get("pos")+"</wsse:Username>\n" +
                "                <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">456</wsse:Password>\n" +
                "            </wsse:UsernameToken>\n" +
                "        </wsse:Security>\n" +
                "    \n" +
                "  </Header>\n" +
                "   <Body>\n" +
                "      <sendValidationRequest xmlns=\"http://www.moneygram.com/AgentConnect1705\">\n" +
                "         <agentID>"+excelData.get("agentID")+"</agentID>\n" +
                "         <agentSequence>"+excelData.get("pos")+"</agentSequence>\n" +
                "         <mgiSessionID>"+apiData.get("mgiSessionId")+"</mgiSessionID>\n" +
                "         <timeStamp>"+date.format(new Date())+"</timeStamp>\n" +
                "         <clientSoftwareVersion>"+excelData.get("acVersion")+"</clientSoftwareVersion>\n" +
                "         <poeType>AGENTCONNECT</poeType>\n" +
                "         <channelType>LOCATION</channelType>\n" +
                "         <targetAudience>AGENT_FACING</targetAudience>\n" +
                "         <poeCapabilities>\n" +
                "            <poeCapability>\n" +
                "               <infoKey>MGI_INTERNAL_FIELDS</infoKey>\n" +
                "               <value>TRUE</value>\n" +
                "            </poeCapability>\n" +
                "         </poeCapabilities>  \n" +
                "         <transactionStaging>true</transactionStaging>\n" +
                "         <sendAmount>"+excelData.get("amount")+"</sendAmount>\n" +
                "         <sendCurrency>"+excelData.get("sendCurrency")+"</sendCurrency>\n" +
                "         <destinationCountry>"+excelData.get("DestCountry")+"</destinationCountry>\n" +
                "         <serviceOption>WILL_CALL</serviceOption>\n" +
                "         <receiveCurrency>USD</receiveCurrency>\n" +
                "          <fieldValues>\n" +
                "            <fieldValue>\n" +
                "               <infoKey>sender_FirstName</infoKey>\n" +
                "               <value>"+ apiData.get("firstName")+"</value>\n" +
                "            </fieldValue>\n" +
                "            <fieldValue>\n" +
                "               <infoKey>sender_LastName</infoKey>\n" +
                "               <value>"+ apiData.get("lastName")+"</value>\n" +
                "            </fieldValue>\n" +
                "            <fieldValue>\n" +
                "               <infoKey>sender_Country</infoKey>\n" +
                "               <value>"+excelData.get("senCountry")+"</value>\n" +
                "            </fieldValue>\n" +
                "             <fieldValue>\n" +
                "               <infoKey>sender_Address</infoKey>\n" +
                "               <value>3"+RandomStringUtils.randomNumeric(3)+" E SUFFOCK AVE</value>\n" +
                "            </fieldValue>\n" +
                "             <fieldValue>\n" +
                "               <infoKey>sender_City</infoKey>\n" +
                "               <value>KINGMAN</value>\n" +
                "            </fieldValue>\n" +
                "            <fieldValue>\n" +
                "               <infoKey>sender_Country_SubdivisionCode</infoKey>\n" +
                "               <value>"+excelData.get("sendState")+"</value>\n" +
                "            </fieldValue>\n" +
                "            <fieldValue>\n" +
                "               <infoKey>sender_PostalCode</infoKey>\n" +
                "               <value>57991</value>\n" +
                "            </fieldValue>\n" +
                "            <fieldValue>\n" +
                "               <infoKey>sender_PrimaryPhoneCountryCode</infoKey>\n" +
                "               <value>1</value>\n" +
                "            </fieldValue>\n" +
                "            <fieldValue>\n" +
                "               <infoKey>sender_PrimaryPhone</infoKey>\n" +
                "               <value>812"+RandomStringUtils.randomNumeric(7)+"</value>\n" +
                "            </fieldValue>\n" +
                "             <fieldValue>\n" +
                "               <infoKey>sender_DOB</infoKey>\n" +
                "               <value>1979-09-"+apiData.get("date")+"</value>\n" +
                "            </fieldValue>\n" +
                "            <fieldValue>\n" +
                "               <infoKey>sender_Occupation</infoKey>\n" +
                "               <value>ADMIN</value>\n" +
                "            </fieldValue>\n" +
                "             <fieldValue>\n" +
                "               <infoKey>sender_Birth_Country</infoKey>\n" +
                "               <value>USA</value>\n" +
                "            </fieldValue>\n" +
                "            <fieldValue>\n" +
                "               <infoKey>sender_PersonalId1_Type</infoKey>\n" +
                "               <value>PAS</value>\n" +
                "            </fieldValue>\n" +
                "            <fieldValue>\n" +
                "               <infoKey>sender_PersonalId1_Issue_Country_SubdivisionCode</infoKey>\n" +
                "               <value>US-TX</value>\n" +
                "            </fieldValue>\n" +
                "            <fieldValue>\n" +
                "               <infoKey>sender_PersonalId1_Issue_Country</infoKey>\n" +
                "               <value>USA</value>\n" +
                "            </fieldValue>\n" +
                "            <fieldValue>\n" +
                "               <infoKey>sender_PersonalId1_Number</infoKey>\n" +
                "               <value>8765489757</value>\n" +
                "            </fieldValue>\n" +
                "            <fieldValue>\n" +
                "               <infoKey>sender_PersonalId2_Type</infoKey>\n" +
                "               <value>SSN</value>\n" +
                "            </fieldValue>\n" +
                "            <fieldValue>\n" +
                "               <infoKey>sender_PersonalId2_Number</infoKey>\n" +
                "               <value>867516780</value>\n" +
                "            </fieldValue>\n" +
                "\n" +
                "             <fieldValue>\n" +
                "               <infoKey>receiver_FirstName</infoKey>\n" +
                "               <value>"+ RandomStringUtils.randomAlphabetic(4).toLowerCase() +"</value>\n" +
                "            </fieldValue>\n" +
                "             <fieldValue>\n" +
                "               <infoKey>receiver_LastName</infoKey>\n" +
                "               <value>"+ RandomStringUtils.randomAlphabetic(4).toLowerCase()+"</value>\n" +
                "            </fieldValue>\n" +
                "            <fieldValue>\n" +
                "               <infoKey>destination_Country_SubdivisionCode</infoKey>\n" +
                "               <value>US-TX</value>\n" +
                "            </fieldValue>\n" +
                "         </fieldValues>\n" +
                "         <primaryReceiptLanguage>EN-US</primaryReceiptLanguage>\n" +
                "         <secondaryReceiptLanguage>ES-MX</secondaryReceiptLanguage>\n" +
                "      </sendValidationRequest>\n" +
                "   </Body>\n" +
                "</Envelope>";
    }

    public String sessionComplete(HashMap<String, String> excelData, Map<String, String> apiData){
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "   <Header>\n" +
                "            <wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                "            <wsu:Timestamp/>\n" +
                "            <wsse:UsernameToken>\n" +
                "                <wsse:Username>"+excelData.get("agentID")+excelData.get("pos")+"</wsse:Username>\n" +
                "                <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">456</wsse:Password>\n" +
                "            </wsse:UsernameToken>\n" +
                "        </wsse:Security>\n" +
                "    \n" +
                "  </Header>\n" +
                "   <Body>\n" +
                "      <completeSessionRequest xmlns=\"http://www.moneygram.com/AgentConnect1705\">\n" +
                "         <agentID>"+excelData.get("agentID")+"</agentID>\n" +
                "         <agentSequence>"+excelData.get("pos")+"</agentSequence>\n" +
                "         <mgiSessionID>"+apiData.get("mgiSessionId")+"</mgiSessionID>\n" +
                "        \t<timeStamp>"+date.format(new Date())+"</timeStamp>\n" +
                "         <clientSoftwareVersion>"+excelData.get("acVersion")+"</clientSoftwareVersion>\n" +
                "         <poeType>AGENTCONNECT</poeType>\n" +
                "         <channelType>LOCATION</channelType>\n" +
                "         <targetAudience>AGENT_FACING</targetAudience>\n" +
                "         <poeCapabilities>\n" +
                "            <poeCapability>\n" +
                "               <infoKey>MGI_INTERNAL_FIELDS</infoKey>\n" +
                "               <value>TRUE</value>\n" +
                "            </poeCapability>\n" +
                "         </poeCapabilities>\n" +
                "         <commit>false</commit>\n" +
                "         <mgiSessionType>SEND</mgiSessionType>\n" +
                "      </completeSessionRequest>\n" +
                "   </Body>\n" +
                "</Envelope>";
    }

    public String tranLookup(HashMap<String, String> excelData){

        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:agen=\"http://www.moneygram.com/AgentConnect1705\">\n" +
                "    <Header>\n" +
                "            <wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                "            <wsu:Timestamp/>\n" +
                "            <wsse:UsernameToken>\n" +
                "                <wsse:Username>"+excelData.get("agentID")+excelData.get("pos")+"</wsse:Username>\n" +
                "                <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">456</wsse:Password>\n" +
                "            </wsse:UsernameToken>\n" +
                "        </wsse:Security>\n" +
                "  </Header>\n" +
                "   <soapenv:Body>\n" +
                "      <agen:transactionLookupRequest>\n" +
                "         <agen:agentID>"+excelData.get("agentID")+"</agen:agentID>\n" +
                "         <agen:agentSequence>"+excelData.get("pos")+"</agen:agentSequence>\n" +
                "       <agen:mgiSessionID></agen:mgiSessionID>\n" +
                "         <agen:timeStamp>"+date.format(new Date())+"</agen:timeStamp>\n" +
                "         <agen:clientSoftwareVersion>"+excelData.get("acVersion")+"</agen:clientSoftwareVersion>\n" +
                "         <agen:poeType>AGENTCONNECT</agen:poeType>\n" +
                "         <agen:channelType>LOCATION</agen:channelType>\n" +
                "         <agen:targetAudience>AGENT_FACING</agen:targetAudience>\n" +
                "         <agen:poeCapabilities>\n" +
                "            <agen:poeCapability>\n" +
                "               <agen:infoKey>BACK_OFFICE_FIELDS</agen:infoKey>\n" +
                "               <agen:value>true</agen:value>\n" +
                "            </agen:poeCapability>\n" +
                "         </agen:poeCapabilities>\n" +
                "         <agen:purposeOfLookup>RECEIVE</agen:purposeOfLookup>\n" +
                "         <agen:referenceNumber>"+excelData.get("referenceNum")+"</agen:referenceNumber>\n" +
                "      </agen:transactionLookupRequest>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>\n";
    }

    public String receivePersonalIDOne(HashMap<String, String> excelData){
        if(!excelData.get("Id1_Type").equalsIgnoreCase("NA")){
            if(excelData.get("PersonalId1_Number").equalsIgnoreCase("NA")){
                return "\t\t<agen:fieldValue>\t\n" +
                        "\t\t\t<agen:infoKey>receiver_PersonalId1_Type</agen:infoKey>\n" +
                        "               <agen:value>"+excelData.get("Id1_Type")+"</agen:value>\n" +
                        "</agen:fieldValue>\t\n" +
                        "\t\t<agen:fieldValue>\t\n" +
                        "\t\t\t<agen:infoKey>receiver_PersonalId1_Issue_Country_SubdivisionCode</agen:infoKey>\n" +
                        "               <agen:value>"+excelData.get("Id1_Country_SubDivision")+"</agen:value>\n" +
                        "</agen:fieldValue>\t\n" +
                        "\t\t<agen:fieldValue>\t\n" +
                        "\t\t\t<agen:infoKey>receiver_PersonalId1_Issue_Country</agen:infoKey>\n" +
                        "               <agen:value>"+excelData.get("Id1_Issue_Country")+"</agen:value>\n" +
                        "</agen:fieldValue>\t\n" +
                        "\t\t<agen:fieldValue>\t\n" +
                        "\t\t\t<agen:infoKey>receiver_PersonalId1_Number</agen:infoKey>\n" +
                        "               <agen:value>8"+RandomStringUtils.randomNumeric(9)+"</agen:value>\n" +
                        "</agen:fieldValue>\t\n";
            }
            else {
                return "\t\t<agen:fieldValue>\t\n" +
                        "\t\t\t<agen:infoKey>receiver_PersonalId1_Type</agen:infoKey>\n" +
                        "               <agen:value>"+excelData.get("Id1_Type")+"</agen:value>\n" +
                        "</agen:fieldValue>\t\n" +
                        "\t\t<agen:fieldValue>\t\n" +
                        "\t\t\t<agen:infoKey>receiver_PersonalId1_Issue_Country_SubdivisionCode</agen:infoKey>\n" +
                        "               <agen:value>"+excelData.get("Id1_Country_SubDivision")+"</agen:value>\n" +
                        "</agen:fieldValue>\t\n" +
                        "\t\t<agen:fieldValue>\t\n" +
                        "\t\t\t<agen:infoKey>receiver_PersonalId1_Issue_Country</agen:infoKey>\n" +
                        "               <agen:value>"+excelData.get("Id1_Issue_Country")+"</agen:value>\n" +
                        "</agen:fieldValue>\t\n" +
                        "\t\t<agen:fieldValue>\t\n" +
                        "\t\t\t<agen:infoKey>receiver_PersonalId1_Number</agen:infoKey>\n" +
                        "               <agen:value>"+excelData.get("PersonalId1_Number")+"</agen:value>\n" +
                        "</agen:fieldValue>\t\n";
            }
        }

        else{
            return "";
        }
    }

    public String receivePersonalIDTwo(HashMap<String, String> excelData){
        if(!excelData.get("PersonalId2_Type").equalsIgnoreCase("NA")) {
            if(excelData.get("PersonalId2_Number").equalsIgnoreCase("NA")) {
                return "\t\t<agen:fieldValue>\t\n" +
                        "               <agen:infoKey>receiver_PersonalId2_Type</agen:infoKey>\n" +
                        "               <agen:value>"+excelData.get("PersonalId2_Type")+"</agen:value>\n" +
                        "</agen:fieldValue>\t\n" +
                        "\t\t<agen:fieldValue>\t\n" +
                        "\t\t\t<agen:infoKey>receiver_PersonalId2_Number</agen:infoKey>\n" +
                        "               <agen:value>7"+RandomStringUtils.randomNumeric(8)+"</agen:value>\n" +
                        "</agen:fieldValue>\t\n" +
                        "\t\t\n" ;
            }
            else {
                return "\t\t<agen:fieldValue>\t\n" +
                        "               <agen:infoKey>receiver_PersonalId2_Type</agen:infoKey>\n" +
                        "               <agen:value>"+excelData.get("PersonalId2_Type")+"</agen:value>\n" +
                        "</agen:fieldValue>\t\n" +
                        "\t\t<agen:fieldValue>\t\n" +
                        "\t\t\t<agen:infoKey>receiver_PersonalId2_Number</agen:infoKey>\n" +
                        "               <agen:value>"+excelData.get("PersonalId2_Number")+"</agen:value>\n" +
                        "</agen:fieldValue>\t\n" +
                        "\t\t\n" ;
            }
        }
        else {
            return "";
        }
    }

    public String receiveValidation(HashMap<String, String> excelData, Map<String, String> apiData){

        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:agen=\"http://www.moneygram.com/AgentConnect1705\">\n" +
                "    <Header>\n" +
                "            <wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                "            <wsu:Timestamp/>\n" +
                "            <wsse:UsernameToken>\n" +
                "                <wsse:Username>"+excelData.get("agentID")+excelData.get("pos")+"</wsse:Username>\n" +
                "                <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">456</wsse:Password>\n" +
                "            </wsse:UsernameToken>\n" +
                "        </wsse:Security>\n" +
                "  </Header>\n" +
                "   <soapenv:Body>\n" +
                "      <agen:receiveValidationRequest>\n" +
                "         <agen:agentID>"+excelData.get("agentID")+"</agen:agentID>\n" +
                "          <agen:agentSequence>"+excelData.get("pos")+"</agen:agentSequence>\n" +
                "         <agen:mgiSessionID>"+apiData.get("receiveMgiSessionId")+"</agen:mgiSessionID>\n" +
                "         <agen:timeStamp>"+date.format(new Date())+"</agen:timeStamp>\n" +
                "         <agen:clientSoftwareVersion>"+excelData.get("acVersion")+"</agen:clientSoftwareVersion>\n" +
                "         <agen:poeType>AGENTCONNECT</agen:poeType>\n" +
                "         <agen:channelType>LOCATION</agen:channelType>\n" +
                "         <agen:targetAudience>AGENT_FACING</agen:targetAudience>\n" +
                "          <agen:poeCapabilities>\n" +
                "               <agen:poeCapability>\n" +
                "               <agen:infoKey>BACK_OFFICE_FIELDS</agen:infoKey>\n" +
                "                <agen:value>true</agen:value>\n" +
                "            </agen:poeCapability>\n" +
                "         </agen:poeCapabilities>\n" +
                "         <agen:GAFVersionNumber>1.1.20190118</agen:GAFVersionNumber>\n" +
                "         <agen:transactionStaging>true</agen:transactionStaging>\n" +
                "         <agen:receiveCurrency>"+excelData.get("receiveCurrency")+"</agen:receiveCurrency>\n" +
                "         <agen:receiveAmount>"+excelData.get("amount")+"</agen:receiveAmount>\n" +
                "          <agen:fieldValues>\n" +
                "               <agen:fieldValue>\n" +
                "               <agen:infoKey>sender_FirstName</agen:infoKey>\n" +
                "               <agen:value>"+excelData.get("senFirstName")+"</agen:value>\n" +
                "\t\t\t</agen:fieldValue>\n" +
                " <agen:fieldValue>\n" +
                "\n" +
                "               <agen:infoKey>receiver_Country</agen:infoKey>\n" +
                "               <agen:value>"+excelData.get("DestCountry")+"</agen:value>\n" +
                "\t\t</agen:fieldValue>\t\n" +
                "\t\t<agen:fieldValue>\t\n" +
                "\t\t\t<agen:infoKey>receiver_Address</agen:infoKey>\n" +
                "               <agen:value>1"+RandomStringUtils.randomNumeric(3)+" N UNIT</agen:value>\n" +
                "</agen:fieldValue>\t\n" +
                "\t\t<agen:fieldValue>\t\n" +
                "\t\t\t<agen:infoKey>receiver_City</agen:infoKey>\n" +
                "               <agen:value>UNION SPRINGS</agen:value>\n" +
                "</agen:fieldValue>\t\n" +
                "\t\t<agen:fieldValue>\t\n" +
                "\t\t\t<agen:infoKey>receiver_Country_SubdivisionCode</agen:infoKey>\n" +
                "               <agen:value>US-TX</agen:value>\n" +
                "</agen:fieldValue>\t\n" +
                "\t\t<agen:fieldValue>\t\n" +
                "\t\t\t<agen:infoKey>receiver_PostalCode</agen:infoKey>\n" +
                "               <agen:value>50942</agen:value>\n" +
                "</agen:fieldValue>\t\n" +
                "\t\t<agen:fieldValue>\t\n" +
                "\t\t\t<agen:infoKey>receiver_PrimaryPhoneCountryCode</agen:infoKey>\n" +
                "               <agen:value>1</agen:value>\n" +
                "</agen:fieldValue>\t\n" +
                "\t\t<agen:fieldValue>\t\n" +
                "\t\t\t<agen:infoKey>receiver_PrimaryPhone</agen:infoKey>\n" +
                "               <agen:value>2"+RandomStringUtils.randomNumeric(9)+"</agen:value>\n" +
                "</agen:fieldValue>\t\n" +
                "\t\t<agen:fieldValue>\t\n" +
                "\t\t\t<agen:infoKey>receiver_DOB</agen:infoKey>\n" +
                "               <agen:value>1985-07-14</agen:value>\n" +
                "</agen:fieldValue>\t\n" +
                "    " + receivePersonalIDOne(excelData)  +
                "    " + receivePersonalIDTwo(excelData)  +
                "         </agen:fieldValues>\n" +
                "         <agen:primaryReceiptLanguage>en-US</agen:primaryReceiptLanguage>\n" +
                "         <agen:secondaryReceiptLanguage>es-MX</agen:secondaryReceiptLanguage>\n" +
                "      \n" +
                "      </agen:receiveValidationRequest>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

    }

    public String receiveCompleteSession(HashMap<String, String> excelData, Map<String, String> apiData){

        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:agen=\"http://www.moneygram.com/AgentConnect1705\">\n" +
                "    <Header>\n" +
                "            <wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                "            <wsu:Timestamp/>\n" +
                "            <wsse:UsernameToken>\n" +
                "                <wsse:Username>"+excelData.get("agentID")+excelData.get("pos")+"</wsse:Username>\n" +
                "                <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">456</wsse:Password>\n" +
                "            </wsse:UsernameToken>\n" +
                "        </wsse:Security>\n" +
                "  </Header>\n" +
                "   <soapenv:Body>\n" +
                "      <agen:completeSessionRequest>\n" +
                "         <agen:agentID>"+excelData.get("agentID")+"</agen:agentID>\n" +
                "         <agen:agentSequence>"+excelData.get("pos")+"</agen:agentSequence>\n" +
                "         <agen:mgiSessionID>"+apiData.get("receiveMgiSessionId")+"</agen:mgiSessionID>\n" +
                "         <agen:timeStamp>"+date.format(new Date())+"</agen:timeStamp>\n" +
                "         <agen:clientSoftwareVersion>"+excelData.get("acVersion")+"</agen:clientSoftwareVersion>\n" +
                "         <agen:poeType>AGENTCONNECT</agen:poeType>\n" +
                "         <agen:channelType>LOCATION</agen:channelType>\n" +
                "         <agen:targetAudience>AGENT_FACING</agen:targetAudience>\n" +
                "         <agen:poeCapabilities>\n" +
                "             <agen:poeCapability>\n" +
                "               <agen:infoKey>BACK_OFFICE_FIELDS</agen:infoKey>\n" +
                "                <agen:value>true</agen:value>\n" +
                "            </agen:poeCapability>\n" +
                "         </agen:poeCapabilities>\n" +
                "         <agen:commit>false</agen:commit>\n" +
                "         <agen:mgiSessionType>RCV</agen:mgiSessionType>\n" +
                "              </agen:completeSessionRequest>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
    }





}
