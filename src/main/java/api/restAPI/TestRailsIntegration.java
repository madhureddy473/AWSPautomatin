package main.java.api.restAPI;

import com.aventstack.extentreports.ExtentTest;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TestRailsIntegration {
	private final List<String> appendableListOfTestCaseIDsForRun = new ArrayList<>();

//	private static final String typeOfRunString = typeOfRun();

	private static final String baseURLForTestRails = "https://moneygram.testrail.io/index.php?/api/v2/";
	//base url for all requests to TestRails
	private static final String projectID = new GetPropertiesFromSysOrConfig().getPropertyFromSysOrConfig("testRailProjectID");
	private static final String suiteID = new GetPropertiesFromSysOrConfig().getPropertyFromSysOrConfig("testRailSuiteID");
	private static final String planID = new GetPropertiesFromSysOrConfig().getPropertyFromSysOrConfig("currentTestPlanID");
	//suite and project ID's on TestRails. Change if any updates to TestRails

	private static final String testRailUsername = System.getenv("testRailUsername");
	private static final String testRailAPIKey = System.getenv("testRailAPIKey"); //pulled from system variables

	private final boolean testRailActive = Boolean.parseBoolean(new GetPropertiesFromSysOrConfig().getPropertyFromSysOrConfig("testRailActive"));
	private final boolean usingTestPlan = Boolean.parseBoolean(new GetPropertiesFromSysOrConfig().getPropertyFromSysOrConfig("usingTestPlan"));

	public String generateRunName(){

		GetPropertiesFromSysOrConfig props = new GetPropertiesFromSysOrConfig();
		return "AW_Automation_Tests" + "_" + "runBStack_" + "__version_" + "_" ;
	}


	public String addRun(ExtentTest currentTest, String testRunName){ //creates an empty run
		if(testRailActive) {
//			if (testRailUsername == null || testRailUsername.equalsIgnoreCase("null")) {
//				extentReportGenerator.addWarningMessage(currentTest, "testRailUsername is null! Check system properties.");
//			}
//			if (testRailAPIKey == null || testRailAPIKey.equalsIgnoreCase("null")) {
//				extentReportGenerator.addInfoMessage(currentTest, "testRailAPIKey is null! Check system properties.");
//			}

			String addRunJSON = String.format("{\n" +
					"  \"suite_id\": %s,\n" +
					"  \"description\": \"%s\",\n" +
					"  \"include_all\": false,\n" +
					"  \"name\": \"%s\" \n}", suiteID, "Test run created by user: " + testRailUsername, testRunName);

			Response response = null;
			try {
				response =
						given()
								.relaxedHTTPSValidation()
								.auth()
								.preemptive()
								.basic(testRailUsername, testRailAPIKey)
								.contentType(ContentType.JSON)
								.body(addRunJSON)
								.post(new URL(baseURLForTestRails + "add_run/" + projectID))
								.then().extract().response();
			} catch (MalformedURLException e) {
//				extentReportGenerator.addWarningMessage(currentTest, "Malformed exception thrown while trying to add test run to test rails. Stacktrace: " + Arrays.toString(e.getStackTrace())); //extentReports
			}
			String currentRunID = "AwaitingAssignment";
			if (response != null && response.getStatusCode() == 200) {
				JsonObject addRunResponse = JsonParser.parseString(response.asString()).getAsJsonObject();
				currentRunID = addRunResponse.get("id").getAsString();
//				extentReportGenerator.addInfoMessage(currentTest, "Test run successfully generated. Details: " + response.asString() + " || Run ID: " + currentRunID);
				System.out.println("Test run successfully generated. Details: " + response.asString() + " || Run ID: " + currentRunID);
			} else {
//				extentReportGenerator.addWarningMessage(currentTest, "Returned null from test rails when trying to add a test run, or status was not 200!");
				if (response != null && response.getStatusCode() != 200) {
//					extentReportGenerator.addWarningMessage(currentTest, "Non 200 response: " + response.asString());
				}
			}
			return currentRunID;
		} else {
//			extentReportGenerator.addWarningMessage(currentTest, "addRun: Test Rail enabled set to false on properties");
			return "Test rails enabled set to FALSE on properties";
		}
	}
	public boolean checkIfCaseIDExists(String caseID, ExtentTest currentTest){
		if(testRailActive) {
//			extentReportGenerator.addInfoMessage(currentTest, "Checking if case ID is valid: " + caseID);
//			extentReportGenerator.addInfoMessage(currentTest, "Using this URL for request: " + baseURLForTestRails + "get_case/" + caseID);
			Response response = null;
			try {
				response =
						given()
								.relaxedHTTPSValidation()
								.auth()
								.preemptive()
								.basic(testRailUsername, testRailAPIKey)
								.contentType(ContentType.JSON)
								.get(new URL(baseURLForTestRails + "get_case/" + caseID))
								.then().extract().response();
			} catch (MalformedURLException e) {
//				extentReportGenerator.addWarningMessage(currentTest, "Malformed exception thrown while trying to see if case ID: " + caseID + " is valid. Stacktrace: " + Arrays.toString(e.getStackTrace())); //extentReports
			}

			boolean caseIDIsValid; //for passing/failing during test cases
			if (response != null && response.getStatusCode() == 200) {
				JsonObject validCaseIDResponse = JsonParser.parseString(response.asString()).getAsJsonObject();
//				extentReportGenerator.addInfoMessage(currentTest, "Case ID is valid. Details: " + validCaseIDResponse);
				System.out.println("Case ID is valid. Details: " + validCaseIDResponse);
				caseIDIsValid = true;
			} else {
//				extentReportGenerator.addWarningMessage(currentTest, "Returned null from test rails when trying to see if case ID was valid, or status was not 200! With case ID: " + caseID);
				if (response != null && response.getStatusCode() != 200) {
//					extentReportGenerator.addWarningMessage(currentTest, "Non 200 response: " + response.asString());
//					extentReportGenerator.addInfoMessage(currentTest, "Was the invalid case ID: " + caseID + " removed?" + appendableListOfTestCaseIDsForRun.remove(caseID)); //if invalid case ID was provided, it will be removed from the list.
				}
				caseIDIsValid = false;
			}
			return caseIDIsValid;
		} else {
//			extentReportGenerator.addWarningMessage(currentTest, "checkIfCaseIDExists: Test Rail enabled set to false on properties");
			return false;
		}
	}
	public boolean updateRunWithCase(String caseID, String currentRunID, ExtentTest currentTest){
		if(testRailActive) {
			if(!caseID.equalsIgnoreCase("null")) {
				appendableListOfTestCaseIDsForRun.add(caseID);
			} else {
//				extentReportGenerator.addWarningMessage(currentTest, "CASE ID RETURNED NULL! NOT APPENDING. CASE ID: " + caseID);
			}
//			extentReportGenerator.addInfoMessage(currentTest, "Current list of appendable test cases: " + appendableListOfTestCaseIDsForRun);
			String updateRunWithCaseJSON = String.format("{\n" +
					"  \"case_ids\": %s \n}", appendableListOfTestCaseIDsForRun); //will append the list in "[]" format to json body
//			extentReportGenerator.addInfoMessage(currentTest, "Using this URL for request: " + baseURLForTestRails + "update_run/" + currentRunID);
			Response response = null;
			try {
				response =
						given()
								.relaxedHTTPSValidation()
								.auth()
								.preemptive()
								.basic(testRailUsername, testRailAPIKey)
								.contentType(ContentType.JSON)
								.body(updateRunWithCaseJSON)
								.post(new URL(baseURLForTestRails + "update_run/" + currentRunID))
								.then().extract().response();
			} catch (MalformedURLException e) {
//				extentReportGenerator.addWarningMessage(currentTest, "Malformed exception thrown while trying to update test run with a test case to test rails. Stacktrace: " + Arrays.toString(e.getStackTrace())); //extentReports
			}

			boolean addedCaseToTestRunSuccessfully; //for passing/failing during test cases
			if (response != null && response.getStatusCode() == 200) {
				JsonObject addResultForCaseResponse = JsonParser.parseString(response.asString()).getAsJsonObject();
//				extentReportGenerator.addInfoMessage(currentTest, "Test case successfully added to test run. Details: " + addResultForCaseResponse);
				System.out.println("Test case successfully added to test run. Details: " + addResultForCaseResponse);
				addedCaseToTestRunSuccessfully = true;
			} else {
//				extentReportGenerator.addWarningMessage(currentTest, "Returned null from test rails when trying to add test case to run, or status was not 200! With case ID: " + caseID);
				if (response != null && response.getStatusCode() != 200) {
//					extentReportGenerator.addWarningMessage(currentTest, "Non 200 response: " + response.asString());
//					extentReportGenerator.addInfoMessage(currentTest, "Was the invalid case ID: " + caseID + " removed?" + appendableListOfTestCaseIDsForRun.remove(caseID)); //if invalid case ID was provided, it will be removed from the list.
				}
				addedCaseToTestRunSuccessfully = false;
			}
			return addedCaseToTestRunSuccessfully;
		} else {
//			extentReportGenerator.addWarningMessage(currentTest, "updateRunWithCase: Test Rail enabled set to false on properties");
			return false;
		}
	}
	public boolean addResultForCase(String statusID, String caseID, String currentRunID, ExtentTest currentTest){ //pull case id from excel

		if(testRailActive) {
			String addResultForCaseJSON = String.format("{\n" +
					"  \"status_id\": \"%s\" \n}", statusID); //status ID must be between 1 - 5, excluding 3. See TestRails API documentation for more details
//			extentReportGenerator.addInfoMessage(currentTest, "Using this URL for request: " + baseURLForTestRails + "add_result_for_case/" + currentRunID + "/" + caseID);
			Response response = null;
			try {
				response =
						given()
								.relaxedHTTPSValidation()
								.auth()
								.preemptive()
								.basic(testRailUsername, testRailAPIKey)
								.contentType(ContentType.JSON)
								.body(addResultForCaseJSON)
								.post(new URL(baseURLForTestRails + "add_result_for_case/" + currentRunID + "/" + caseID))
								.then().extract().response();
			} catch (MalformedURLException e) {
//				extentReportGenerator.addWarningMessage(currentTest, "Malformed exception thrown while trying to add test run to test rails. Stacktrace: " + Arrays.toString(e.getStackTrace())); //extentReports
			}

			boolean resultForCaseAddedSuccessfully; //for passing/failing during test cases
			if (response != null && response.getStatusCode() == 200) {
				JsonObject addResultForCaseResponse = JsonParser.parseString(response.asString()).getAsJsonObject();
//				extentReportGenerator.addInfoMessage(currentTest, "Test result successfully added. Details: " + addResultForCaseResponse);
				System.out.println("Test result successfully added. Details: " + addResultForCaseResponse);
				resultForCaseAddedSuccessfully = true;
			} else {
//				extentReportGenerator.addWarningMessage(currentTest, "Returned null from test rails when trying to add a result for test case, or status was not 200! With case ID: " + caseID);
				if (response != null && response.getStatusCode() != 200) {
//					extentReportGenerator.addWarningMessage(currentTest, "Non 200 response: " + response.asString());
				}
				resultForCaseAddedSuccessfully = false;
			}
			return resultForCaseAddedSuccessfully;
		} else {
//			extentReportGenerator.addWarningMessage(currentTest, "addResultForCase: Test Rail enabled set to false on properties");
			return false;
		}
	}
	public boolean closeRun(String currentRunID, ExtentTest currentTest){
		if(testRailActive) {
			Response response = null;
			try {
				response =
						given()
								.relaxedHTTPSValidation()
								.auth()
								.preemptive()
								.basic(testRailUsername, testRailAPIKey)
								.contentType(ContentType.JSON)
								.post(new URL(baseURLForTestRails + "close_run/" + currentRunID))
								.then().extract().response();
			} catch (MalformedURLException e) {
//				extentReportGenerator.addWarningMessage(currentTest, "Malformed exception thrown while trying to close test run on test rails. Stacktrace: " + Arrays.toString(e.getStackTrace())); //extentReports
			}

			boolean closedRunSuccessfully; //for passing/failing during test cases
			if (response != null && response.getStatusCode() == 200) {
				JsonObject closeRunResponse = JsonParser.parseString(response.asString()).getAsJsonObject();
//				extentReportGenerator.addInfoMessage(currentTest, "Test run successfully closed. Details: " + closeRunResponse);
				System.out.println("Test run successfully closed. Details: " + closeRunResponse);
				closedRunSuccessfully = true;
			} else {
//				extentReportGenerator.addWarningMessage(currentTest, "Returned null from test rails when trying to close test run, or status was not 200! Run ID: " + currentRunID);
				if (response != null && response.getStatusCode() != 200) {
//					extentReportGenerator.addWarningMessage(currentTest, "Non 200 response: " + response.asString());
				}
				closedRunSuccessfully = false;
			}
			return closedRunSuccessfully;
		} else {
//			extentReportGenerator.addWarningMessage(currentTest, "closeRun: Test Rail enabled set to false on properties");
			return false;
		}
	}

	//test plan/entry APIs:
	public HashMap<String, String> addTestPlanEntry(ExtentTest currentTest, String testRunName){ //creates a test entry. has one filler test case in it because entries cannot be empty
		if(testRailActive && usingTestPlan) {
			if (testRailUsername == null || testRailUsername.equalsIgnoreCase("null")) {
//				extentReportGenerator.addWarningMessage(currentTest, "testRailUsername is null! Check system properties.");
			}
			if (testRailAPIKey == null || testRailAPIKey.equalsIgnoreCase("null")) {
//				extentReportGenerator.addInfoMessage(currentTest, "testRailAPIKey is null! Check system properties.");
			}

			String addRunJSON = String.format("{\n" +
					"  \"suite_id\": %s,\n" +
					"  \"description\": \"%s\",\n" +
					"  \"include_all\": false,\n" +
					"  \"case_ids\": [%s],\n" +
					"  \"name\": \"%s\" \n}", suiteID, "Test Plan Entry_Run created by user: " + testRailUsername, new GetPropertiesFromSysOrConfig().getPropertyFromSysOrConfig("genericTestPlanHolderCaseID"), testRunName);
			Response response = null;
			try {
				response =
						given()
								.relaxedHTTPSValidation()
								.auth()
								.preemptive()
								.basic(testRailUsername, testRailAPIKey)
								.contentType(ContentType.JSON)
								.body(addRunJSON)
								.post(new URL(baseURLForTestRails + "add_plan_entry/" + planID))
								.then().extract().response();
			} catch (MalformedURLException e) {
//				extentReportGenerator.addWarningMessage(currentTest, "Malformed exception thrown while trying to add test plan entry to test rails. Stacktrace: " + Arrays.toString(e.getStackTrace())); //extentReports
			}
			String currentRunID;
			String currentEntryID;
			HashMap<String, String> runAndEntryID = new HashMap<>();
			if (response != null && response.getStatusCode() == 200) {
				JsonObject addRunResponse = JsonParser.parseString(response.asString()).getAsJsonObject();
				currentRunID = addRunResponse.get("runs").getAsJsonArray().get(0).getAsJsonObject().get("id").getAsString();
				currentEntryID = addRunResponse.get("runs").getAsJsonArray().get(0).getAsJsonObject().get("entry_id").getAsString();
				runAndEntryID.put("currentRunID", currentRunID);
				runAndEntryID.put("currentEntryID", currentEntryID);
//				extentReportGenerator.addInfoMessage(currentTest, "Test plan entry successfully generated. Details: " + response.asString() + " || Run ID: " + currentRunID);
				System.out.println("Test plan entry successfully generated. Details: " + response.asString() + " || Run ID: " + currentRunID);
			} else {
//				extentReportGenerator.addWarningMessage(currentTest, "Returned null from test rails when trying to add a test plan entry, or status was not 200!");
				if (response != null && response.getStatusCode() != 200) {
//					extentReportGenerator.addWarningMessage(currentTest, "Non 200 response: " + response.asString());
				}
			}
			return runAndEntryID;
		} else {
//			extentReportGenerator.addWarningMessage(currentTest, "addRun: Test Rail enabled set to false on properties, or test plan is not being used.");
			HashMap<String, String> blankHash = new HashMap<>();
			blankHash.put("currentRunID", "null");
			blankHash.put("currentEntryID", "null");
			return blankHash;
		}
	}
	public boolean updatePlanEntryWithCase(String caseID, String currentEntryID, ExtentTest currentTest){
		if(testRailActive && usingTestPlan) {
			if(!caseID.equalsIgnoreCase("null")) {
				appendableListOfTestCaseIDsForRun.add(caseID);
			} else {
//				extentReportGenerator.addWarningMessage(currentTest, "CASE ID RETURNED NULL! NOT APPENDING. CASE ID: " + caseID);
			}
//			extentReportGenerator.addInfoMessage(currentTest, "Current list of appendable test cases: " + appendableListOfTestCaseIDsForRun);
			String updateRunWithCaseJSON = String.format("{\n" +
					"  \"case_ids\": %s \n}", appendableListOfTestCaseIDsForRun); //will append the list in "[]" format to json body
//			extentReportGenerator.addInfoMessage(currentTest, "Using this URL for request: " + baseURLForTestRails + "update_plan_entry/" + planID + "/" + currentEntryID);
			Response response = null;
			try {
				response =
						given()
								.relaxedHTTPSValidation()
								.auth()
								.preemptive()
								.basic(testRailUsername, testRailAPIKey)
								.contentType(ContentType.JSON)
								.body(updateRunWithCaseJSON)
								.post(new URL(baseURLForTestRails + "update_plan_entry/" + planID + "/" + currentEntryID))
								.then().extract().response();
			} catch (MalformedURLException e) {
//				extentReportGenerator.addWarningMessage(currentTest, "Malformed exception thrown while trying to update test entry with a test case to test rails. Stacktrace: " + Arrays.toString(e.getStackTrace())); //extentReports
			}

			boolean addedCaseToTestRunSuccessfully; //for passing/failing during test cases
			if (response != null && response.getStatusCode() == 200) {
				JsonObject addResultForCaseResponse = JsonParser.parseString(response.asString()).getAsJsonObject();
//				extentReportGenerator.addInfoMessage(currentTest, "Test case successfully added to test run. Details: " + addResultForCaseResponse);
				System.out.println("Test case successfully added to test entry. Details: " + addResultForCaseResponse);
				addedCaseToTestRunSuccessfully = true;
			} else {
//				extentReportGenerator.addWarningMessage(currentTest, "Returned null from test rails when trying to add test entry to run, or status was not 200! With case ID: " + caseID);
				if (response != null && response.getStatusCode() != 200) {
//					extentReportGenerator.addWarningMessage(currentTest, "Non 200 response: " + response.asString());
//					extentReportGenerator.addInfoMessage(currentTest, "Was the invalid case ID: " + caseID + " removed?" + appendableListOfTestCaseIDsForRun.remove(caseID)); //if invalid case ID was provided, it will be removed from the list.
				}
				addedCaseToTestRunSuccessfully = false;
			}
			return addedCaseToTestRunSuccessfully;
		} else {
//			extentReportGenerator.addWarningMessage(currentTest, "updateRunWithCase: Test Rail enabled set to false on properties or not using test plan");
			return false;
		}
	}
}
