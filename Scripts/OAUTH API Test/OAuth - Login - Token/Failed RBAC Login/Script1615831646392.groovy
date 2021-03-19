import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static org.assertj.core.api.Assertions.*
import org.eclipse.jetty.client.api.Request
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.*
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent

RequestObject request = API

TestObjectProperty headerContentType = new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/x-www-form-urlencoded")

ArrayList defaultHeaders = Arrays.asList(headerContentType)

request.setHttpHeaderProperties(defaultHeaders)

//Contraseña incorrecta (7 de mas)
request.setBodyContent(new HttpTextBodyContent('username=bk@produccion.gob.ar&password=sistemabk1234567&grant_type=password&client_id=5c0539ad522fcb091d563024&client_secret=ySpuxlMs18xgMaLy7aSn2asl52KDPqTAiphpfMjI'))

def response = WS.sendRequest(request)

WS.verifyResponseStatusCode(response, 401)

//WS.comment(response.responseBodyContent)